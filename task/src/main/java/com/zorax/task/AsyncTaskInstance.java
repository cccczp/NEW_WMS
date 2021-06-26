package com.zorax.task;

import com.zorax.task.tool.ThreadUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/**
 * @创作者 czp
 * @创作时间 2021/6/8 21:38
 * @描述
 */
public class AsyncTaskInstance<Result> extends FutureTask<Result> {

    private final ITaskBackground mBackground;
    private final ITaskCallBack mBack;

    public AsyncTaskInstance(final ITaskBackground<Result> iTaskBackground, ITaskCallBack<Result> iTaskCallBack) {
        super(new Callable<Result>() {
            @Override
            public Result call() throws Exception {
                return iTaskBackground.onBackground();
            }
        });
        this.mBackground = iTaskBackground;
        this.mBack = iTaskCallBack;
    }

    @Override
    protected void done() {
        if (mBack != null) {
            onComplete();
        }
    }

    private void onComplete() {
        try {
            final Object object = get();
            if (object != null) {
                ThreadUtil.postMainThread(new Runnable() {
                    @Override
                    public void run() {
                        mBack.onComplete(object);
                    }
                });
            }
        } catch (Exception e) {
            mBack.onException(new Throwable());
            e.printStackTrace();
        }
    }

    @Override
    protected void setException(final Throwable t) {
        super.setException(t);
        if (mBack != null) {
            ThreadUtil.postMainThread(new Runnable() {
                @Override
                public void run() {
                    mBack.onException(t);
                }
            });
        }
    }

    public static AsyncTaskInstance getInstance(ITaskBackground iTaskBackground, ITaskCallBack iTaskCallBack) {
        return new AsyncTaskInstance(iTaskBackground, iTaskCallBack);
    }
}
