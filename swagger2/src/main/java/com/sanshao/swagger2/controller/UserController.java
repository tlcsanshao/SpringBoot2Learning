package com.sanshao.swagger2.controller;


import com.sanshao.swagger2.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "用户管理模块", tags = "用户管理API")
public class UserController {

    @GetMapping("/findAllUserList")
    @ApiOperation(value = "分页查询所有用户列表")
    public ArrayList<User> findUserList(@ApiParam(value = "当前页", example = "1") @RequestParam(required = true, defaultValue = "1") Integer current,
                                        @ApiParam(value = "每页条数", example = "2") @RequestParam(required = true, defaultValue = "7") Integer size) {
        log.info("get all users");
        ArrayList<User> list = new ArrayList<>();
        User user = new User();
        user.setId(1000l);
        user.setUsername("zhangsan");
        list.add(user);
        return list;
    }

}

