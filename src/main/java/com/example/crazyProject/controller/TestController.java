package com.example.crazyProject.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping(value="/api")
public class TestController {

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
    public String postHello(@RequestBody HashMap<String, Object> obj){
        System.out.println("obj = " + obj);
        return "포스트발!!!";
    }
}
