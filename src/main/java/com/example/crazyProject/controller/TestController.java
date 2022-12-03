package com.example.crazyProject.controller;

import com.example.crazyProject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping(value="/api")
public class TestController {
    @Autowired
    TestService testService;
    @GetMapping(value = "/test")
    public String test(){
        return "index.html";
    }

    @GetMapping(value = "/getHello")
    public String getHello(){
        System.out.println("123123123 = " + 123123123);
        return "야발 메세지 !!!!!";
    }

    @PostMapping(value = "/postHello")
    public String postHello(@RequestBody Object obj){
        System.out.println("obj = " + obj);
        return "포스트발!!!";
    }

    @PostMapping(value = "/postQuerry")
    public String postHello(@RequestBody String querry){
        String result = testService.selectQuerry(querry);
        System.out.println(result);
        return "조회성공";
    }
}
