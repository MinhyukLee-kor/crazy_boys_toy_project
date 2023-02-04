package com.example.crazyProject.mapper.sign;

import com.example.crazyProject.sign.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository
public interface UserMapper {

    public HashMap<String,Object> idCheck(String userId);

    public int signUp(User user);

}
