package com.zorax.wms.base;

import com.zorax.http.request.host.IHost;

/**
 * @创作者 czp
 * @创作时间 2021/6/11 13:46
 * @描述
 */
public interface IHostManager {
    IHost iHost = new IHost() {
        @Override
        public String getHost() {
            return "http://192.168.0.219:8091";
        }

        @Override
        public String getDefaultPath() {
            return null;
        }
    };
}
