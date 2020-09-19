package com.user.demo.bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Tbu4001")
public class Tbu4001 {

    private int id;
    private String l_name;
    private String f_name;
    private String email;
    private String password;
    private String group;

}
