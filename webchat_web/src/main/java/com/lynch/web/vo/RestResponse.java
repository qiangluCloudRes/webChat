package com.lynch.web.vo;

/**
 * Created by LuQiang on 2017/7/2.
 */
public class RestResponse<T> {
    private String      reason;
    private int         result;
    private Integer     errorCode;
    private     T       data;

    public RestResponse(String reason,Integer result,Integer errorCode){
        this.reason = reason;
        this.errorCode = errorCode;
        this.result = result;
    }

    public RestResponse(String reason,Integer result,T data){
        this.reason = reason;
        this.result = result;
        this.data = data;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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
}
