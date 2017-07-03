package com.lynch.dao.userdao;

import com.lynch.dao.mapper.UserMapper;
import com.lynch.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LuQiang on 2017/7/2.
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper  userMapper;

    @Override
    public boolean saveUser(User user) {
        return userMapper.insertSelective(user) > 0;
    }

    @Override
    public User getUser(Long uid) {
        return userMapper.selectByPrimaryKey(uid);
    }
}
