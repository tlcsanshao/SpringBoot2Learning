package com.sanshao.redis.controller;

import com.sanshao.redis.pojo.User;
import com.sanshao.redis.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CacheController {
    @Autowired
    CacheService cacheService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id) {
        return cacheService.getUser(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        cacheService.addUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        cacheService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        cacheService.deleteUser(id);
    }

    @DeleteMapping
    public void deleteAllUsers(){
        cacheService.clearUsers();
    }
}
