package com.example.crazyProject.sign.service;

import com.example.crazyProject.sign.domain.User;


public interface SignService {

    public boolean idCheck(String userId);
    public int signUp(User user);

    public int login(String userId, String password);

    public void logout();

}
