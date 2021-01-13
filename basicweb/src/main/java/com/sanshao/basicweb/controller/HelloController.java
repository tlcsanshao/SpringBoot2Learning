package com.sanshao.basicweb.controller;

import com.sanshao.basicweb.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class HelloController {

    // @RestController 表示以JSON字符串的格式返回。
    // 方法的返回值无论是String，Map，Object等，都会转成JSON字符串。


    // 1. @PathVariable
    // url中?号前面的一段
    // 可以直接通过参数名称映射过来，也可以通过一个map将所有的参数都获取。
    // 2. @RequestHeader
    // 获取请求头参数，用法跟@PathVariable类似
    // 3. @ReqeustParam
    // url中?号后面的一段
    // 4. @CooikeValue


    @GetMapping("/class/{classid}/student/{studentid}")
    public Map<String, Object> getStudent(@PathVariable("classid") long classid,
                                          @PathVariable("studentid") long studentid,
                                          @PathVariable Map<String, String> pm,
                                          @RequestHeader("User-Agent") String userAgent,
                                          @RequestHeader Map<String, String> header,
                                          @RequestParam("age") Integer age,
                                          @RequestParam("inters") List<String> inters,
                                          @RequestParam Map<String, String> params,
                                          @CookieValue("JSESSIONID") String cookie,
                                          @CookieValue("JSESSIONID") Cookie cookies) {
        Map<String, Object> map = new HashMap<>();
        // 1. 测试PathVariable
        //        map.put("classid", classid);
        //        map.put("stdentid", studentid);
        //        System.out.println("pathvariable classid,"+pm.get("classid"));
        //        map.put("pm",pm);

        // 2. 测试RequestHeader
        //        map.put("User-Agent", userAgent);
        //        map.put("header", header);

        // 3. 测试RequestParam
        //        map.put("age", age);
        //        map.put("inters", inters);
        //        map.put("params", params);

        // 4. 测试cookie
        map.put("cookie",cookie);
        map.put("cookies",cookies);

        return map;
    }

    // @RequestBody的用法
    // postman    raw json
    //    {
    //        "classid":1,
    //        "studentid":3,
    //        "age":10,
    //        "inters":["游泳","击剑"]
    //    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        log.info(student.toString());
        // do some thing to addStudent
        return student;
    }


}
