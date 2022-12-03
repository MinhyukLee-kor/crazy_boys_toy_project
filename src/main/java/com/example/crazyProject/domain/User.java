package com.example.crazyProject.domain;

public class User {
    private Integer id;
    private String user_id;
    private String user_name;

    public Integer getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
