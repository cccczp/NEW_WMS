package com.zorax.task;

/**
 * @创作者 czp
 * @创作时间 2021/6/8 21:19
 * @描述
 */
interface ITaskBackground<Result> {
    Result onBackground();
}
