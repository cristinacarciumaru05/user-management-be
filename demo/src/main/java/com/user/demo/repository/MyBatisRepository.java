package com.user.demo.repository;

import com.user.demo.bean.Tbu4001;
import com.user.demo.bean.Tbugr001;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MyBatisRepository {

    @Select("select * from tbu4001")
    public List<Tbu4001> findAll();

    @Select("SELECT * FROM tbu4001 WHERE f_name = #{f_name}")
    public List<Tbu4001> findByFName(String f_name);

    @Select("SELECT * FROM tbu4001 WHERE email = #{email}")
    public Tbu4001 findByEmail(String email);

    @Delete("DELETE FROM tbu4001 WHERE email = #{email} ")
    public int deleteById(String emaill);

    @Insert("INSERT INTO tbu4001(f_name, l_name, email, password) " +
            " VALUES (#{f_name}, #{l_name}, #{email}, #{password})")
    public int insert(Tbu4001 user);

    @Update("Update tbu4001 set f_name=#{f_name}, " +
            " l_name=#{l_name} where email=#{email}")
    public int update(Tbu4001 user);

    @Update("Update tbu4001 set group=#{group}, " +
            " where email=#{email}")
    public int addUserToGroup(Tbu4001 user);

    @Select("select * from tbugr001")
    public List<Tbugr001> getGroups();

    @Insert("INSERT INTO tbugr001(name) " +
            " VALUES (#{name})")
    public int addGroup(String name);

    @Delete("DELETE FROM tbugr001 WHERE email = #{name} ")
    public int deleteGroup(String name);

    @Select("SELECT * FROM tbu4001 where email =#{email} AND password=#{password}")
    public boolean checkPassword(String email, String password);

}