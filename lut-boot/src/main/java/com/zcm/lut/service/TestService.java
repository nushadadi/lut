package com.zcm.lut.service;

import com.zcm.lut.pojo.Test;
import com.zcm.lut.pojo.TestQuery;

import java.util.List;
import java.util.Set;

/**
 * @author ZCM
 * @package com.zcm.lut.service
 * @class TestService
 * @date 2019/08/04
 **/
public interface TestService {
    Test getTestByID(Integer id);
    int addTest(Test test);
    List<Test> getAllTest(TestQuery testQuery);
    Set getRedisSet(String key);
}
