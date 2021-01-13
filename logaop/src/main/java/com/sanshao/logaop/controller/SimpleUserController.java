package com.sanshao.logaop.controller;

import com.sanshao.logaop.domain.SimpleUser;
import com.sanshao.logaop.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimpleUserController {

    @Autowired
    SimpleUserService simpleUserService;

    @PostMapping("/simpleuser")
    public SimpleUser addSimpleUser(@RequestBody SimpleUser simpleUser) {
        return simpleUserService.addUser(simpleUser);
    }

    @DeleteMapping("/simpleuser/{id}")
    public boolean deleteSimpleUser(@PathVariable(name = "id") Long id) {
        return simpleUserService.deleteUser(id);

    }

    @PutMapping("/simpleuser")
    public boolean updateSimpleUser(@RequestBody SimpleUser simpleUser) {
        return simpleUserService.updateUser(simpleUser);
    }


    @GetMapping("/simpleuser/{id}")
    public SimpleUser getSimpleUsers(@PathVariable(value = "id") long id) {
        return simpleUserService.getSimpleUser(id);
    }

    @GetMapping("/simpleuser")
    public List<SimpleUser> getSimpleUsers(@RequestParam(value = "name") String name, @RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {
        return simpleUserService.getSimpleUsers(name, page, size);
    }


}
