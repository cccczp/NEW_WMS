package com.zorax.http;

import com.zorax.http.request.IRequest;
import com.zorax.http.result.IResult;

import java.util.Map;

/**
 * @创作者 czp
 * @创作时间 2021/6/7 20:18
 * @描述
 */
public class LfHttpServer {

    protected <T> IResult<T> execute(IRequest request, Map<String,Object> params)
    {
        return HttpHelper.execute(request,params);
    }
}
