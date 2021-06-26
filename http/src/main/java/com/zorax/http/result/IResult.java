package com.zorax.http.result;

/**
 * @创作者 czp
 * @创作时间 2021/6/10 15:42
 * @描述
 */
public interface IResult<T> {
    boolean isSucess();

    T data();
}
