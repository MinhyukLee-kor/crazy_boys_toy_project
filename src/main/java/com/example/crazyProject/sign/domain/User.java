package com.example.crazyProject.sign.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;
    private String user_id;
    private String user_name;
    private String password;
    private String mobile_number;
    private String birth;
    private String zipcode;
    private String address;
    private String address_detail;
    private String access_ip;
    private String use_yn;
    private String regist_date;
    private String modify_date;
}
