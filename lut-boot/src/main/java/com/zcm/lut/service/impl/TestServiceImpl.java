package com.zcm.lut.service.impl;

import com.zcm.lut.dao.TestDao;
import com.zcm.lut.pojo.Test;
import com.zcm.lut.pojo.TestQuery;
import com.zcm.lut.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZCM
 * @package com.zcm.lut.service.impl
 * @class TestServiceImpl
 * @date 2019/08/04
 **/
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Test getTestByID(Integer id) {
        return testDao.selectByPrimaryKey(id);
    }

    @Override
    public int addTest(Test test) {

        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
//        Set a = new HashSet();
//        a.add("a");
//        a.add("b");
//        a.add("c");
//        Set b = new HashSet();
//        b.add("b");
//        b.add("c");
//        b.add("d");
//        Set c = new HashSet();
//        c.add("c");
//        c.add("d");
//        c.add("e");
//        redisTemplate.opsForSet().add("set_a",a);
//        redisTemplate.opsForSet().add("set_b",b);
//        redisTemplate.opsForSet().add("set_c",c);
//        List keys = new ArrayList();
//        keys.add("set_b");
//        keys.add("set_c");
//        redisTemplate.opsForSet().differenceAndStore("set_a","set_b","different_set_a_b");
//        redisTemplate.opsForSet().differenceAndStore("set_a",keys,"different_set_a_b_c");
//        redisTemplate.opsForSet().intersectAndStore("set_a",keys,"same_set_a_b_c");
//        redisTemplate.opsForSet().unionAndStore("set_a",keys,"all_set_a_b_c");

        Long pid = redisTemplate.opsForValue().increment("testPID",5);
        test.setId(pid.intValue());
        return testDao.insert(test);
    }

    @Override
    public List<Test> getAllTest(TestQuery testQuery) {
        return testDao.selectByExample(testQuery);
    }

    @Override
    public Set getRedisSet(String key) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        Set result = redisTemplate.opsForSet().members(key);
        return result;
    }
}
