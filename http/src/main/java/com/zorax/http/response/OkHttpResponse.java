package com.zorax.http.response;

import java.io.IOException;

import okhttp3.Response;

/**
 * @创作者 czp
 * @创作时间 2021/6/10 16:16
 * @描述
 */
public class OkHttpResponse implements IResponse {
    private Response mResponse;

    public OkHttpResponse(Response response) {
        this.mResponse = response;
    }

    @Override
    public String  getResponseStr(){
        try {
            return mResponse.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
