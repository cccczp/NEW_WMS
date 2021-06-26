package com.zorax.http.request;

import com.zorax.http.annotation.IRequestMethod;
import com.zorax.http.parser.IParser;
import com.zorax.http.request.host.IHost;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @创作者 czp
 * @创作时间 2021/6/7 20:19
 * @描述
 */
public interface IRequest {
    void setParams(Map<String, Object> params);

    Map<String,Object> getParams();

    @IRequestMethod
    int getRequestMethod();

    IHost getHost();

    String getPath();

    IParser getIParser();
    Type getType();
}
