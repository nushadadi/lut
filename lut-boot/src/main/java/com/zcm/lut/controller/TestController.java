package com.zcm.lut.controller;

import com.zcm.lut.pojo.Test;
import com.zcm.lut.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author ZCM
 * @package com.zcm.lut.controller
 * @class TestController
 * @date 2019/08/04
 **/

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping(value = "/test/getTestID")
    public Test getTestByID(Integer id){
        Test test = testService.getTestByID(id);
        return test;
    }

    @RequestMapping(value = "test/toAddTestPage")
    public String toAddPage(){
        return "test/add";
    }

    @PostMapping(value = "test/addTest")
    public String addTest(Test test){
        testService.addTest(test);
        return "redirect:getAll";
    }

    @RequestMapping(value = "test/getAll")
    public String getAllTest(Model model){
        List<Test> list = testService.getAllTest(null);
        model.addAttribute("list",list);
        return "test/getAllTest";
    }

    @RequestMapping(value = "test/getRedisSet")
    public String getRedisSet(String key, Model model){
//        key = "all_set_a_b_c";
        Set redisSet = testService.getRedisSet(key);
        System.out.println(redisSet.size());
        model.addAttribute("set",redisSet);
        return "test/getRedisSet";
    }
}
