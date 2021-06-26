package com.zorax.wms.base;

import com.zorax.http.annotation.IRequestMethod;
import com.zorax.http.parser.DefaultResultParser;
import com.zorax.http.request.IRequest;
import com.zorax.http.request.LfRequest;

import java.lang.reflect.Type;

/**
 * @创作者 czp
 * @创作时间 2021/6/11 13:43
 * @描述
 */
public class WMSRequest extends LfRequest {
    public static IRequest sendHttp(String path, @IRequestMethod int requestMethod, Type type)
    {
        WMSRequest request = new WMSRequest();
        request.host = IHostManager.iHost;
        request.path = path;
        request.requestMethod = requestMethod;
        request.resultParser = DefaultResultParser.getInstance();
        request.type = type;
        return request;
    }
}
