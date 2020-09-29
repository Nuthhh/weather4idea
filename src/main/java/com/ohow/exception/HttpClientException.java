package com.ohow.exception;


public class HttpClientException extends Exception {

    private static final long serialVersionUID = -5672019722614020061L;

    private String message;

    public HttpClientException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "HttpClientException{" +
                "message='" + message + '\'' +
                "} " + super.toString();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
