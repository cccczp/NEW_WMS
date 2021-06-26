package com.zorax.http.result;

/**
 * @创作者 czp
 * @创作时间 2021/6/10 19:46
 * @描述
 */
public class Result<T> implements IResult<T> {

    public final static int CODE_404 = 404;
    public final static int CODE_504 = 504;
    public final static int CODE_604 = 604;
    private final static int CODE_200 = 200;
    private T data;
    public static int code;
    private boolean success;

    public static IResult fail(int code) {
        Result result = new Result();
        result.code = code;
        result.success = false;
        return result;
    }

    public static IResult success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = CODE_200;
        result.success = true;
        return result;
    }

    @Override
    public boolean isSucess() {
        return success;
    }

    @Override
    public T data() {
        return data;
    }
}
