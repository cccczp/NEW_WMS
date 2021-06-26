package com.zorax.http.parser;

import com.zorax.http.request.IRequest;
import com.zorax.http.response.IResponse;
import com.zorax.http.result.IResult;

/**
 * @创作者 czp
 * @创作时间 2021/6/10 16:37
 * @描述
 */
public interface IParser {
    IResult paseResponse(IRequest request, IResponse iResponse);
}
