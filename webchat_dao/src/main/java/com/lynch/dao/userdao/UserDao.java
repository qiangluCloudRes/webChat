package com.lynch.dao.userdao;

import com.lynch.dao.model.User;

/**
 * Created by LuQiang on 2017/7/2.
 */
public interface UserDao {

    boolean saveUser(User user);

    User  getUser(Long uid);
}
