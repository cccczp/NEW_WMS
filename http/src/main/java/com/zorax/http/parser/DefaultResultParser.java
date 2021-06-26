package com.zorax.http.parser;

import com.google.gson.Gson;
import com.zorax.http.request.IRequest;
import com.zorax.http.response.IResponse;
import com.zorax.http.result.IResult;
import com.zorax.http.result.Result;

import java.lang.reflect.Type;

/**
 * @创作者 czp
 * @创作时间 2021/6/10 16:39
 * @描述
 */
public class DefaultResultParser implements IParser {
    private static DefaultResultParser instance;
    private Gson mGson;

    public DefaultResultParser() {
        this.mGson = new Gson();
    }

    public static IParser getInstance() {
        if (instance == null) {
            instance = new DefaultResultParser();
        }
        return instance;
    }


    @Override
    public IResult paseResponse(IRequest request, IResponse iResponse) {
        Type type = request.getType();
        String responseStr = iResponse.getResponseStr();
        Object object = mGson.fromJson(responseStr, type);
        if (object == null)
        {
            return Result.fail(Result.CODE_404);
        }
        else
        {
            return Result.success(object);
        }
    }
}
