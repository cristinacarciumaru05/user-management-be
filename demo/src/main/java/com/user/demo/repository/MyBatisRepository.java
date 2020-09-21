package com.user.demo.repository;

import com.user.demo.bean.Tbgroups;
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

    @Update("Insert into tbugr001(email,name) values(#{email}, #{name}) ")
    public int addUserToGroup(String email, String name);

    @Select("select * from tbugr001")
    public List<Tbugr001> getGroupsWithUser();

    @Insert("INSERT INTO Tbgroups(name) " +
            " VALUES (#{name})")
    public int addGroup(String name);

    @Delete("DELETE FROM tbgroups WHERE name = #{name} ")
    public int deleteGroup(String name);

    @Select("SELECT * FROM tbu4001 where email =#{email} AND password=#{password}")
    public String checkPassword(String email, String password);

    @Select("SELECT * FROM Tbgroups")
    public List<Tbgroups> getGroups();

    @Select("SELECT * FROM Tbgroups where name =#{name}")
    public Tbgroups findGroup(String name);

    @Select("SELECT * FROM tbugr001 where name =#{name}")
    public Tbugr001 findUserGroup(String name);

    @Select("SELECT * FROM tbugr001 where email =#{email}")
    public List<Tbugr001> findGroupByUser(String email);

    @Delete("DELETE FROM tbugr001 where name =#{name}")
    public void deleteUserGroup(String name);

    @Select("SELECT * FROM tbugr001 where name =#{name}")
    public List<Tbugr001> findUserByGroup(String name);

    @Delete("DELETE FROM tbugr001 where email =#{email} and name=#{name}")
    public void deleteUserFromGroup(String email,String name);
}