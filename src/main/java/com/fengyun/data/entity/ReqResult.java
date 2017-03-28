package com.fengyun.data.entity;

/**
 * Created by Administrator on 2017/3/28.
 */
public class ReqResult<T> {

    private T data;
    private boolean success;

    public static <W> ReqResult<W> success(W data) {
        ReqResult<W> reqResult = new ReqResult<W>();
        reqResult.setSuccess(true);
        reqResult.setData(data);
        return reqResult;
    }

    public static <W> ReqResult<W> failure(W data) {
        ReqResult<W> reqResult = new ReqResult<W>();
        reqResult.setSuccess(false);
        reqResult.setData(data);
        return reqResult;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
