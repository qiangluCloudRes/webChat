package com.lynch.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.lynch.biz.bo.BizResult;
import com.lynch.biz.bo.ErrorCode;
import com.lynch.biz.service.UserService;
import com.lynch.dao.model.User;
import com.lynch.dao.userdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by LuQiang on 2017/7/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao  userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    private String  USER_INDEX = "user:index";

    @Override
    public BizResult login(Long uid, String passWord) {
        BizResult bizResult = new BizResult();
        User user = userDao.getUser(uid);
        if (null == user){
            bizResult.setReason("用户不存在");
            bizResult.setErrorCode(ErrorCode.ILLEGAL_USER);
            return bizResult;
        }
        if (!user.getPassWord().equals(passWord)){
            bizResult.setReason("密码错误");
            bizResult.setErrorCode(ErrorCode.ILLEGAL_PASSWORD);
            return bizResult;
        }
        redisTemplate.opsForValue().set(uid.toString(),JSONObject.toJSONString(user));
        bizResult.setResult(true);
        return bizResult;
    }

    @Override
    public BizResult register(String userName, String passWord) {
        BizResult bizResult = new BizResult();
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        user.setUid(generateUserId());
        boolean isSuccess = userDao.saveUser(user);
        if (isSuccess){
            bizResult.setResult(true);
            bizResult.setData(user);
            redisTemplate.opsForValue().set(user.getUid().toString(), JSONObject.toJSONString(user));
        }
        return bizResult;
    }


    @Override
    public BizResult isLogin(Long uid) {
        BizResult bizResult = new BizResult();
        String userInfo = (String) redisTemplate.opsForValue().get(uid);
        if (!Strings.isNullOrEmpty(userInfo)){
            bizResult.setResult(true);
        }

        return bizResult;
    }

    private long generateUserId(){
        long index = redisTemplate.opsForValue().increment(USER_INDEX,1);
        return (100 << 10) + index;
    }
}
