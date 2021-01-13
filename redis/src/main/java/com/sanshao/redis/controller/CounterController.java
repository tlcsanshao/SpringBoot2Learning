package com.sanshao.redis.controller;

import com.sanshao.redis.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/count")
    public String getCount(){
        redisUtil.incr("count",1);
        return redisUtil.get("count").toString();
    }


}
