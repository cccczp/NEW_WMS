package com.zorax.http.request;

import com.zorax.http.response.IResponse;
import com.zorax.http.response.OkHttpResponse;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @创作者 czp
 * @创作时间 2021/6/7 21:44
 * @描述
 */
public class OkHttpCall implements ICall {
    private Call mCall;
    private IRequest mIRequest;

    public OkHttpCall(IRequest request, Call call) {
        this.mCall = call;
        this.mIRequest = request;
    }

    @Override
    public IResponse execute() {
        Response response = null;
        try {
            response = this.mCall.execute();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        OkHttpResponse okHttpResponse = new OkHttpResponse(response);
        return okHttpResponse;
    }

    @Override
    public IRequest getRequest() {
        return mIRequest;
    }
}
