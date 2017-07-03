package com.lynch.biz.bo;

/**
 * Created by LuQiang on 2017/7/2.
 */
public class BizResult<T> {
    private String      reason;
    private Integer     errorCode;
    private boolean     result = false;
    private T           data;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
