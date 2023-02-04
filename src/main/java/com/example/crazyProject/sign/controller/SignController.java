package com.example.crazyProject.sign.controller;

import com.example.crazyProject.sign.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sign/")
public class SignController {

    @Autowired
    SignService signService;

    /**
     * @author minhyuk
     * @return int (0:가입가능,1:가입불가능)*/
    @RequestMapping(value = "idCheck", method = RequestMethod.POST)
    public int idCheck(@RequestBody String userId) {
        return signService.idCheck(userId);
    }
}
