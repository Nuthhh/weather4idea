package com.ohow.weather.data;


import com.alibaba.fastjson.JSONObject;
import com.ohow.exception.HttpClientException;
import com.ohow.util.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

public class WeatherDataService {


    public static final String url = "https://tianqiapi.com/api";

    private WeatherDataService() {
    }

    private static JSONObject requestData() {
        Map<String, String> param = new HashMap<>(4);
        param.put("appid", "82996889");
        param.put("appsecret", "dLytq4BJ");
        param.put("version", "v6");

        JSONObject object = null;
        try {
            String result = HttpClientUtil.get(url, param);
            object = JSONObject.parseObject(result);
        } catch (HttpClientException e) {
            e.printStackTrace();
        }

        return object;
    }

    private static WeatherInfo convertData(JSONObject data) {
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setCityId(data.getString("cityid"));
        weatherInfo.setCityName(data.getString("city"));
        weatherInfo.setUpdateTime(data.getString("update_time"));
        weatherInfo.setWeather(data.getString("wea"));
        weatherInfo.setWeatherImage(data.getString("wea_img"));
        weatherInfo.setTemperature(data.getString("tem"));
        weatherInfo.setMaxTemperature(data.getString("tem1"));
        weatherInfo.setMinTemperature(data.getString("tem2"));
        weatherInfo.setWind(data.getString("win"));
        weatherInfo.setWindLevel(data.getString("win_speed"));
        weatherInfo.setWindSpeed(data.getString("win_meter"));
        weatherInfo.setHumidity(data.getString("humidity"));
        weatherInfo.setVisibility(data.getString("visibility"));
        weatherInfo.setPressure(data.getString("pressure"));
        weatherInfo.setAir(data.getString("air"));
        weatherInfo.setAirLevel(data.getString("air_level"));
        weatherInfo.setAirTips(data.getString("air_tips"));
        return weatherInfo;
    }


    public static WeatherInfo get() {
        JSONObject data = requestData();
        WeatherInfo weatherInfo = convertData(data);
        // TODO: 2020/9/30 视图层转化
        return weatherInfo;
    }

    public static void main(String[] args) {
        get();
    }


}
