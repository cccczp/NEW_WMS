package com.zorax.http.result;

/**
 * @创作者 czp
 * @创作时间 2021/6/11 9:00
 * @描述
 */
public interface IResultCallBack<T> {

    void onSuccess(IResult<T> t);

    void onFailed(IResult<T> t);

}
