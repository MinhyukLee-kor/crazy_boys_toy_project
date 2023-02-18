package com.example.crazyProject.sign.service;

import com.example.crazyProject.mapper.sign.UserMapper;
import com.example.crazyProject.sign.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * 회원가입, 로그인, 로그아웃
 * @author minhyuk
 * */
@Service
@Transactional
public class SignServiceImpl implements SignService{

    @Autowired
    UserMapper userMapper;

    /** 아이디 중복 체크*/
    @Override
    public int idCheck(String userId) {
        int result = 1;
        HashMap<String,Object> resMap = userMapper.idCheck(userId);
        // db기준 number은 바로 int로 캐스트가 안됨
        result = Integer.parseInt(String.valueOf(resMap.get("chk")));
        return result;
    }

    /** 회원가입 */
    @Transactional
    @Override
    public int signUp(User user) {
        int result = 0;
        result = userMapper.signUp(user);
        return result;
    }

    /** 로그인 */
    @Override
    public int signIn(String userId, String password) {
        int result = 0;
        HashMap<String, Object> resMap = userMapper.signIn(userId);
        String realPw = (String)resMap.get("password");
        if(realPw.equals(password)){
            result = 1;
        }
        return result;
    }

    /** 로그아웃 */
    @Override
    public void logout() {

    }

}
