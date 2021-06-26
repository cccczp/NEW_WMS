package com.zorax.http.httpScheduler;


import com.zorax.http.parser.IParser;
import com.zorax.http.request.ICall;
import com.zorax.http.request.IRequest;
import com.zorax.http.response.IResponse;
import com.zorax.http.result.IResult;


/**
 * @创作者 czp
 * @创作时间 2021/6/7 21:04
 * @描述
 */
public abstract class HttpScheduler {
     public abstract ICall newCall(IRequest request);

     public IResult execute(ICall iCall) {
          IResponse iResponse = iCall.execute();
          //IRrsult 与 IResponse进行转换
          IRequest request = iCall.getRequest();
          IParser iParser = request.getIParser();
          return iParser.paseResponse(request,iResponse);
     }
}
