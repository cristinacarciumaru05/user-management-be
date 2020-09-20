package com.user.demo.bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Tbugr001")
public class Tbugr001 {

    private int id;
    private String name;
    private String email;
}
