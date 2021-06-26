package com.zorax.wms.base;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @创作者 czp
 * @创作时间 2021/5/29 16:25
 * @描述
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface ViewInject {
    int mainLayoutId() default -1;
}
