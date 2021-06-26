package com.zorax.http;

import com.zorax.http.httpScheduler.HttpScheduler;
import com.zorax.http.okhttp.OkHttpScheduler;
import com.zorax.http.request.ICall;
import com.zorax.http.request.IRequest;
import com.zorax.http.result.IResult;

import java.util.Map;

/**
 * @创作者 czp
 * @创作时间 2021/6/7 20:20
 * @描述
 */
class HttpHelper {
    private volatile static HttpScheduler sHttpScheduler;


    public static HttpScheduler getHttpScheduler()
    {
        if (sHttpScheduler == null)
        {
            synchronized (HttpHelper.class)
            {
                if (sHttpScheduler == null)
                {
                    sHttpScheduler = new OkHttpScheduler();
                }
            }
        }
        return sHttpScheduler;
    }

    public static <T> IResult<T> execute(IRequest request, Map<String, Object> params) {
        request.setParams(params);
        ICall iCall =  getHttpScheduler().newCall(request);
        return getHttpScheduler().execute(iCall);
    }
}
