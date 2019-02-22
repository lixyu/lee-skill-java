package com.lee.happy.util;

import com.lee.happy.exception.HttpRequestException;
import io.micrometer.core.instrument.binder.okhttp3.OkHttpMetricsEventListener;
import io.micrometer.core.ipc.http.HttpSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;


@Component
@Slf4j
public class ReactiveHttpRequest {
    private final HttpSender httpSender;

    @Autowired
    public ReactiveHttpRequest(@Qualifier("okhttp") HttpSender httpSender) {
        this.httpSender = httpSender;
    }

    public String doJson(String url, String param, long timeout) throws HttpRequestException {
        return request(httpSender.post(url).withHeader(OkHttpMetricsEventListener.URI_PATTERN, getUri(url)).withJsonContent(param), url, param);
    }

    public String doGet(String url, long timeout) throws HttpRequestException {
        return request(httpSender.get(url).withHeader(OkHttpMetricsEventListener.URI_PATTERN, getUri(url)), url, "");
    }

    private String request(HttpSender.Request.Builder request, String url, String params) throws HttpRequestException {
        try {
            HttpSender.Response response = request.send();
            if (response.isSuccessful()) {
                log.debug(MessageFormat.format("HTTP请求成功：Url:[{0}],Params:[{1}],Response:[{2}]", url, params, response.body()));
                return response.body();
            } else {
                String errorMessage = MessageFormat.format("HTTP请求失败：Url:[{0}],Params:[{1}],RequestException:[{2}]", url, params, response.body());
                log.error(errorMessage);
                throw new HttpRequestException(errorMessage);
            }
        } catch (Throwable e) {
            String errorMessage = MessageFormat.format("HTTP请求异常：Url:[{0}],Params:[{1}],IOException:[{2}]", url, params, e.getMessage());
            log.error(errorMessage);
            throw new HttpRequestException(errorMessage);
        }
    }

    private String getUri(String url) {
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return url;
        }
        return uri.getPath();
    }
}
