package com.zorax.task;

import java.util.concurrent.ThreadFactory;

/**
 * @创作者 czp
 * @创作时间 2021/6/10 15:11
 * @描述
 */
public class TaskThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,"task_thread_pool");
    }
}
