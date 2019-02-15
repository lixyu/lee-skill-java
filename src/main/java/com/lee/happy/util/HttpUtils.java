package com.lee.happy.util;

import com.lee.happy.exception.HttpRequestException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Isaac
 * @Date: 11/22/2018 11:15
 * @Description:
 */
@Slf4j
public class HttpUtils {
    private static OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder();

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static String doJson(String url, String param, long timeout) throws HttpRequestException {
        RequestBody body = RequestBody.create(JSON, param);
        Request request = new Request.Builder().url(url).post(body).build();
        return request(url, param, timeout, request);
    }

    /**
     * @param url
     * @param timeout
     * @return
     * @throws HttpRequestException
     */
    public static String doGet(String url, long timeout) throws HttpRequestException {
        Request request = new Request.Builder().url(url).build();
        return request(url, "", timeout, request);
    }

    /**
     * @param url
     * @param params
     * @param timeout
     * @param request
     * @return
     * @throws HttpRequestException
     */
    private static String request(String url, String params, long timeout, Request request) throws HttpRequestException {
        OkHttpClient okHttpClient = okHttpClientBuilder.readTimeout(timeout, TimeUnit.SECONDS).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                String message = response.body().string();
                log.debug(MessageFormat.format("HTTP请求成功：Url:[{0}],Params:[{1}],Response:[{2}]", url, params, response.message()));
                return message;
            } else {
                String errorMessage = MessageFormat.format("HTTP请求失败：Url:[{0}],Params:[{1}],RequestException:[{2}]", url, params, response.message());
                log.error(errorMessage);
                throw new HttpRequestException(errorMessage);
            }
        } catch (IOException e) {
            String errorMessage = MessageFormat.format("HTTP请求异常：Url:[{0}],Params:[{1}],IOException:[{2}]", url, params, e.getMessage());
            log.error(errorMessage);
            throw new HttpRequestException(errorMessage);
        }
    }
}