package com.lynch.biz.bo;

/**
 * Created by LuQiang on 2017/7/2.
 */
public class UserInfo {
    private Long     uid;
    private String   passWord;
    private int      login;
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }
}
