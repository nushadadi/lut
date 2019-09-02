package com.zcm.lut.service.impl;

import com.zcm.lut.dao.UserDao;
import com.zcm.lut.pojo.User;
import com.zcm.lut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZCM
 * @package com.zcm.lut.service.impl
 * @class UserServiceImpl
 * @date 2019/08/04
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByID(Long id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int addUser(User user) {
        return 0;
    }
}
