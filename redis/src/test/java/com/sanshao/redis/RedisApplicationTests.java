package com.sanshao.redis;

import com.sanshao.redis.config.RedisUtil;
import com.sanshao.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {


    }




}
