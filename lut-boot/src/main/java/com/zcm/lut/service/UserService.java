package com.zcm.lut.service;

import com.zcm.lut.pojo.User;

/**
 * @author ZCM
 * @package com.zcm.lut.service
 * @class UserService
 * @date 2019/08/04
 **/
public interface UserService {
    User getUserByID(Long id);
    int addUser(User user);
}
