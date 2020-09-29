package com.ohow.util;

import com.ohow.exception.HttpClientException;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;


public class HttpClientUtil {

    /**
     * 连接超时时间 单位：毫秒
     */
    private static final int CONNECTION_TIME = PropertyUtil.getInt("file.http.config.connection_time", 20000);
    /**
     * 等待响应超时时间 单位：毫秒
     */
    private static final int SOCKET_TIME = PropertyUtil.getInt("file.http.config.socket_time", 20000);
    /**
     * 请求失败重试次数
     */
    private static final int RETRY_COUNT = PropertyUtil.getInt("file.http.config.max_retry_count", 3);
    /**
     * 最大重试次数
     */
    private static final int MAX_RETRY_COUNT = 10;

    private static CloseableHttpClient httpClient;

    static {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(CONNECTION_TIME)
                .setSocketTimeout(SOCKET_TIME)
                .build();
        httpClient = HttpClients.custom()
                .setRetryHandler(new DefaultHttpRequestRetryHandler(Math.min(RETRY_COUNT, MAX_RETRY_COUNT), true))
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(poolingHttpClientConnectionManager)
                .build();
    }

    /**
     * 功能描述: 发送get请求
     *
     * @param url    发送请求的url
     * @param params 相关参数
     */
    public static String get(String url, Map<String, String> params) throws HttpClientException {
        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && !params.isEmpty()) {
            urlBuilder.append("?");
            StringJoiner stringJoiner = new StringJoiner("&");
            params.forEach((key, value) -> stringJoiner.add(key + "=" + value));
            urlBuilder.append(stringJoiner.toString());
        }

        HttpGet httpGet = new HttpGet(urlBuilder.toString());
        return execute(httpGet);
    }

    /**
     * 功能描述: 发送post请求，传参
     *
     * @param url    发送请求的url
     * @param params 相关参数
     */
    public static String post(String url, Map<String, String> params) throws HttpClientException {
        HttpPost httpPost = new HttpPost(url);
        if (params != null && !params.isEmpty()) {
            List<BasicNameValuePair> basicNameValuePairs = params.entrySet().stream().map(param -> new BasicNameValuePair(param.getKey(), param.getValue())).collect(Collectors.toList());
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(basicNameValuePairs, StandardCharsets.UTF_8);
            httpPost.setEntity(urlEncodedFormEntity);
        }
        return execute(httpPost);
    }


    private static String execute(HttpRequestBase httpRequestBase) throws HttpClientException {
        ResponseHandler<String> responseHandler = response -> {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode >= HttpStatus.SC_OK && statusCode < HttpStatus.SC_MULTIPLE_CHOICES) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : "";
            } else {
                throw new ClientProtocolException("Unexpected response status: " + statusCode);
            }
        };

        String execute;
        try {
            execute = httpClient.execute(httpRequestBase, responseHandler);
        } catch (IOException e) {
            throw new HttpClientException(String.format("请求url[%s]错误[%s]", httpRequestBase.getURI().toString(), e.getMessage()));
        }
        return execute;
    }

}
