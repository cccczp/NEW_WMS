package com.zorax.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.zorax.task.tool.ThreadUtil;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @创作者 czp
 * @创作时间 2021/6/10 13:44
 * @描述
 */
public class TaskScheduler {

    private final PriorityThreadPoolExecutor executor;

    interface ITaskScheduler
    {
        int SUBMIT_TASK = 0;
    }

    private static TaskScheduler instance;
    private final Handler handler;
    private int COREPOOLSIZE = ThreadUtil.CPU_NUM + 1;
    private int MAXIMUMPOOLSIZE = COREPOOLSIZE;
    private int KEEPALIVETIME = 1;

    public TaskScheduler(){
        //用于消息调度的线程
        HandlerThread thread = new HandlerThread("task-thread");
        thread.start();
        this.handler = new Handler(thread.getLooper(), new Handler.Callback() {
            //HandlerThread handleMessage 运行在子线程
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what)
                {
                    case ITaskScheduler.SUBMIT_TASK:
                        doSubmitTask((AsyncTaskInstance) msg.obj);
                }
                return false;
            }
        });
        //创建一个线程池
        BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>();   //无大小限制的队列
        executor = new PriorityThreadPoolExecutor(COREPOOLSIZE,MAXIMUMPOOLSIZE,KEEPALIVETIME, TimeUnit.MINUTES,blockingDeque,new TaskThreadFactory());
    }

    private void doSubmitTask(AsyncTaskInstance obj)
    {
        executor.submit(obj);
    }

    public static TaskScheduler getInstance()
    {
        if (instance == null)
        {
            instance = new TaskScheduler();
        }
        return instance;
    }

    public void submit(AsyncTaskInstance instance) {
        handler.sendMessage(handler.obtainMessage(ITaskScheduler.SUBMIT_TASK,instance));
    }
}
