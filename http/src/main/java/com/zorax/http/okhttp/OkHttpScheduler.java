package com.zorax.http.okhttp;

import com.google.gson.Gson;
import com.zorax.http.annotation.IRequestMethod;
import com.zorax.http.httpScheduler.HttpScheduler;
import com.zorax.http.request.ICall;
import com.zorax.http.request.IRequest;
import com.zorax.http.request.OkHttpCall;

import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @创作者 czp
 * @创作时间 2021/6/7 21:06
 * @描述
 */
public class OkHttpScheduler extends HttpScheduler {
    private OkHttpClient mOkHttpClient;

    // TODO: 2021/6/7
    @Override
    public ICall newCall(IRequest request) {
        Map<String, Object> params = request.getParams();
        int requestMethod = request.getRequestMethod();
        Request.Builder requestBuilder = new Request.Builder();
        StringBuilder stringBuilder = new StringBuilder(request.getHost().getHost());
        stringBuilder.append(request.getPath());
        switch (requestMethod) {
            case IRequestMethod.GET:
                HttpUrl.Builder urlBuilder = HttpUrl.parse(stringBuilder.toString()).newBuilder();
                if (params != null && params.size() > 0) {
                    Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Object> next = iterator.next();
                        urlBuilder.addEncodedQueryParameter(next.getKey(), String.valueOf(next.getValue()));
                    }
                }
                requestBuilder.get().url(urlBuilder.build());
                break;
            case IRequestMethod.POST:
                FormBody.Builder builder = new FormBody.Builder();
                Gson gson = new Gson();
                RequestBody body = null;
                if (params != null && params.size() > 0) {
                    Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Object> next = iterator.next();
                        //                        builder.add(next.getKey(), String.valueOf(next.getValue()));
                        String json = gson.toJson(next.getValue());
                        body = FormBody.create(json, MediaType.parse("application/json; charset=utf-8"));
                    }
                }
                requestBuilder.post(body).url(stringBuilder.toString());
                break;
        }
        Request okHttpRequest = requestBuilder.build();
        Call call = getClient().newCall(okHttpRequest);
        OkHttpCall okHttpCall = new OkHttpCall(request, call);
        return okHttpCall;
    }


    private OkHttpClient getClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
        }
        return mOkHttpClient;
    }

}
