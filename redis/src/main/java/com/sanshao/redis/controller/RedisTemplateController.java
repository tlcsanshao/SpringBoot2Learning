package com.sanshao.redis.controller;

import com.sanshao.redis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTemplateController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/redis")
    public void demo() {
        // redisTemplate 操作不同的数据类型，api和我们的指令是一样的
        // opsForValue 操作字符串 类似String
        // opsForList 操作List 类似List
        // opsForHash

        // 获取连接对象
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        //connection.flushDb();
        //connection.flushAll();
        redisTemplate.opsForValue().set("mykey", "我们");
        System.out.println(redisTemplate.opsForValue().get("mykey"));

        // 对象，序列化
        User user = new User(1, "张三", 12);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));

    }
}
