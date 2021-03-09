package com.imindersingh.http;

import com.github.sitture.env.config.EnvConfig;
import kong.unirest.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class ApiReferenceRequests extends Requests {

    private final String ACCEPT = "Accept";

    public ApiReferenceRequests() {
        super(EnvConfig.get("HOST"));
    }

    public HttpResponse get(String path) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(ACCEPT, "*/*");
        return getRequest(path, headers);
    }

    public HttpResponse get(String path, Map<String, String> headers) {
        return getRequest(path, headers);
    }

    public HttpResponse post(String path, String body) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(ACCEPT, "*/*");
        headers.put("Content-Type", "application/vnd.json");
        return postRequest(path, headers, body);
    }

    public HttpResponse post(String path, Map<String, String> headers, String body) {
        return postRequest(path, headers, body);
    }
}
