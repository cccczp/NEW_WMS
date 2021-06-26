package com.zorax.task.tool;

import android.os.Handler;
import android.os.Looper;

/**
 * @创作者 czp
 * @创作时间 2021/6/8 21:47
 * @描述
 */
public class ThreadUtil {
    //主线程的Handler
    private static Handler MAIN = new Handler(Looper.getMainLooper());

    //当前设备的CPU数量
    public static int CPU_NUM = Runtime.getRuntime().availableProcessors();

    public static void postMainThread(final Runnable runnable)
    {
        MAIN.post(new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });
    }
}
