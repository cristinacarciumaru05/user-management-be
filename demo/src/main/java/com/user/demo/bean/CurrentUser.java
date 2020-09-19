package com.user.demo.bean;

import lombok.Data;

@Data
public class CurrentUser {

    private int id;
    private String l_name;
    private String f_name;
    private String email;
    private String password;
    private String group;
}
