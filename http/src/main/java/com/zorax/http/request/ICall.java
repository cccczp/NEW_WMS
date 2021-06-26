package com.zorax.http.request;

import com.zorax.http.response.IResponse;

/**
 * @创作者 czp
 * @创作时间 2021/6/7 21:00
 * @描述
 */
public interface ICall {
    IResponse execute();
    IRequest getRequest();
}
