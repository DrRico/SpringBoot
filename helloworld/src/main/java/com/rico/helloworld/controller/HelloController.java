package com.rico.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rico_dds
 * @date 2020/7/22 16:17
 */

@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello(){
        //调用业务，接收前段参数
        return "hello world!";

    }


}
