package com.sanshao.redis.service;

import com.sanshao.redis.pojo.User;
import com.sanshao.redis.repositroy.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheService {

    @Autowired
    UserRepository userRepository;

    //    value可以理解成缓存区域，为一级名称
    //    key支持SPEL表达式，如果不设置，会使用全局配置文件中的keyGenerator

    @Cacheable(value = "user", key = "#id")
    public User getUser(long id) {
        log.info("getUser -- access to mysql");
        return userRepository.findById(id).get();
    }


    public void addUser(User user) {
        userRepository.save(user);
    }

    @CacheEvict(value = "user", key = "#user.id")
    public void updateUser(User user) {
        User dbUser = userRepository.findById(user.getId()).get();
        dbUser.setAge(user.getAge());
        dbUser.setName(user.getName());
        userRepository.save(dbUser);
    }

    @CacheEvict(value = "user", key = "#id")
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @CacheEvict(value = "user", allEntries = true)
    public void clearUsers() {
        userRepository.deleteAll();
    }


}
