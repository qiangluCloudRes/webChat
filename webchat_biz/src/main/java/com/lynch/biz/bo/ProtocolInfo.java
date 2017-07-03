package com.lynch.biz.bo;

/**
 * Created by LuQiang on 2017/7/2.
 */
public class ProtocolInfo {
    private int         type;
    private UserInfo    userInfo;
    private String      message;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
