package com.zorax.task;

/**
 * @创作者 czp
 * @创作时间 2021/6/10 13:34
 * @描述
 */
public class TaskHelper {

    public static void submitTask(ITaskBackground iTaskBackground,ITaskCallBack iTaskCallBack)
    {
        AsyncTaskInstance instance = AsyncTaskInstance.getInstance(iTaskBackground,iTaskCallBack);
        //构建线程管理器
        TaskScheduler.getInstance().submit(instance);
    }
}
