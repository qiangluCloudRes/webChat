package com.lynch.dao.model;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.uid
     *
     * @mbggenerated
     */
    private Long uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.pass_word
     *
     * @mbggenerated
     */
    private String passWord;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.wechat
     *
     * @mbggenerated
     */
    private String wechat;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.telephone
     *
     * @mbggenerated
     */
    private Long telephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.state
     *
     * @mbggenerated
     */
    private Boolean state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.uid
     *
     * @return the value of user.uid
     *
     * @mbggenerated
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.uid
     *
     * @param uid the value for user.uid
     *
     * @mbggenerated
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_name
     *
     * @return the value of user.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_name
     *
     * @param userName the value for user.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.pass_word
     *
     * @return the value of user.pass_word
     *
     * @mbggenerated
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.pass_word
     *
     * @param passWord the value for user.pass_word
     *
     * @mbggenerated
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.wechat
     *
     * @return the value of user.wechat
     *
     * @mbggenerated
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.wechat
     *
     * @param wechat the value for user.wechat
     *
     * @mbggenerated
     */
    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.telephone
     *
     * @return the value of user.telephone
     *
     * @mbggenerated
     */
    public Long getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.telephone
     *
     * @param telephone the value for user.telephone
     *
     * @mbggenerated
     */
    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.state
     *
     * @return the value of user.state
     *
     * @mbggenerated
     */
    public Boolean getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.state
     *
     * @param state the value for user.state
     *
     * @mbggenerated
     */
    public void setState(Boolean state) {
        this.state = state;
    }
}