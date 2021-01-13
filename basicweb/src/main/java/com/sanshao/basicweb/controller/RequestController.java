package com.sanshao.basicweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {
    // 这个demo主要演示了请求域的传值和获取

    @GetMapping("/goto")
    public String gotoForward(HttpServletRequest request) {
        // Map<String,Object> map,  Model model, HttpServletRequest request 都是可以给request域中放数据，
        // 可以通过 request.getAttribute(); 查看
        request.setAttribute("msg","hello world");
        request.setAttribute("code",200);

        //转发到/success请求
        return "forward:/success";
    }

    // @RestController = @Controller+@ResponseBody
    // @ResponseBody 表示返回字符串，如果不加此主键，表示转到某个页面

    @ResponseBody
    @GetMapping("/success")
    public Map<String,Object> success(@RequestAttribute("msg") String msg,
                                      @RequestAttribute("code") int code,
                                      HttpServletRequest request){
        String msg1 = request.getAttribute("msg").toString();
        Map<String,Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("msg1",msg1);
        map.put("code",code);
        return map;
    }

    // 此方法演示转到resource/templates/abc.html文件
    // 必须要在pom文件中，加入thymeleaf-starter
    @GetMapping("/abc")
    public String hello(){
        return "abc";
    }
}
