package com.lynch.biz.service;

import com.lynch.biz.bo.BizResult;

/**
 * Created by LuQiang on 2017/7/2.
 */
public interface UserService {
    BizResult  register(String userName,String passWord);

    BizResult  login(Long uid,String passWord);

    BizResult isLogin(Long uid);
}
