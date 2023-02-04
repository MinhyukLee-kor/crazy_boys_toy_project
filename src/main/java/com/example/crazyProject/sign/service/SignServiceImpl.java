package com.example.crazyProject.sign.service;

import com.example.crazyProject.mapper.sign.UserMapper;
import com.example.crazyProject.sign.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 회원가입, 로그인, 로그아웃
 * @author minhyuk
 * */
@Service
public class SignServiceImpl implements SignService{

    @Autowired
    UserMapper userMapper;

    /** 아이디 중복 체크*/
    @Override
    public boolean idCheck(String userId) {
        boolean result = false;
        HashMap<String,Object> resMap = userMapper.idCheck(userId);
        result = resMap.get("user_id").equals("1");
        return result;
    }

    /** 회원가입 */
    @Override
    public int signUp(User user) {
        int result = 0;
        return result;
    }

    /** 로그인 */
    @Override
    public int login(String userId, String password) {
        int result = 0;

        return result;
    }

    /** 로그아웃 */
    @Override
    public void logout() {

    }

}
