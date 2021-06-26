package com.zorax.wms.base;

import com.zorax.http.result.IResult;
import com.zorax.http.result.IResultCallBack;
import com.zorax.http.result.Result;
import com.zorax.task.LfTask;

/**
 * @创作者 czp
 * @创作时间 2021/6/11 11:42
 * @描述
 */
public abstract class WMSTask<T> extends LfTask<IResult<T>> implements IResultCallBack<T> {

    @Override
    public void onComplete(IResult<T> iResult) {
        if (iResult != null) {
            if (iResult.isSucess()) {
                onSuccess(iResult);
            } else {
                onFailed(Result.fail(Result.CODE_404));    //1次失败
            }
        } else {
            onFailed(Result.fail(Result.CODE_404));        //2次失败
        }
    }


    @Override
    public void onException(Throwable throwable) {
        onFailed(Result.fail(Result.CODE_404));            //3次失败
    }
}
