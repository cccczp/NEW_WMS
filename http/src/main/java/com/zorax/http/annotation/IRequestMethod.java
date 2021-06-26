package com.zorax.http.annotation;

import androidx.annotation.IntDef;

import static com.zorax.http.annotation.IRequestMethod.GET;
import static com.zorax.http.annotation.IRequestMethod.POST;

/**
 * @创作者 czp
 * @创作时间 2021/6/7 20:30
 * @描述
 */
@IntDef({GET,POST})
public @interface IRequestMethod {
    int GET = 1;
    int POST = 2;
}
