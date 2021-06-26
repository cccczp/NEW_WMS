package com.zorax.http.request;

import com.zorax.http.annotation.IRequestMethod;
import com.zorax.http.parser.IParser;
import com.zorax.http.request.host.IHost;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @创作者 czp
 * @创作时间 2021/6/7 20:33
 * @描述
 */
public class LfRequest implements IRequest {
    protected IHost host;

    @IRequestMethod
    protected int requestMethod;
    protected String path;
    protected Type type;
    protected IParser resultParser;

    private Map<String,Object> params;

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public Map<String, Object> getParams() {
        return this.params;
    }

    @Override
    public int getRequestMethod() {
        return this.requestMethod;
    }

    @Override
    public IHost getHost() {
        return this.host;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public IParser getIParser() {
        return resultParser;
    }

    @Override
    public Type getType() {
        return type;
    }
}
