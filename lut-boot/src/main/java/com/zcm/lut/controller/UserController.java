package com.zcm.lut.controller;

import com.zcm.lut.pojo.User;
import com.zcm.lut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZCM
 * @package com.zcm.lut.controller
 * @class UserController
 * @date 2019/08/04
 **/
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user/getUser")
    public User getUser(Long id){
        return userService.getUserByID(id);
    }
}
