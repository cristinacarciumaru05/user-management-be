package com.user.demo.data;

import com.user.demo.auth.CustomAuthenticationProvider;
import com.user.demo.bean.Tbgroups;
import com.user.demo.bean.Tbu4001;
import com.user.demo.bean.Tbugr001;
import com.user.demo.repository.MyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataController {

    @Autowired
    private MyBatisRepository myBatisRepository;

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;


    public Tbu4001 getCurrentUser(){
        return authenticationProvider.getUser();
    }

    public void setCurrentUser(Tbu4001 user){
        authenticationProvider.setUser(user);
    }

    
    public List<Tbu4001> getUsers() {
        return myBatisRepository.findAll();
    }


    public List<Tbu4001> findByFName(String fName) {
        return myBatisRepository.findByFName(fName);
    }


    public Tbu4001 findByEmail(String email) {
        return myBatisRepository.findByEmail(email);
    }

 
    public void addUser(Tbu4001 user){
        myBatisRepository.insert(user);
    }

  
    public void updateUser(Tbu4001 user){
        myBatisRepository.update(user);
    }

 
    public void deleteUser(String email) {
        myBatisRepository.deleteById(email);
    }


    public void addUsersToGroup(String email, String name){
            myBatisRepository.addUserToGroup(email,name);
    }
   
    public List<Tbugr001> getGroupsWithUser() {
        return myBatisRepository.getGroupsWithUser();
    }
    public List<Tbgroups> getGroups() {
        return myBatisRepository.getGroups();
    }
    
    public void addGroup( String name){
        myBatisRepository.addGroup(name);
    }

  
    public void deleteGroup( String name) {
        myBatisRepository.deleteGroup(name);
    }

    public List<Tbugr001> findUserGroup(String name) {
        return myBatisRepository.findUserGroup(name);
    }
    public Tbgroups findGroup( String name) {
        return myBatisRepository.findGroup(name);
    }
    public String checkPassword(String email, String password){
        return myBatisRepository.checkPassword(email,password);
    }

    public void deleteUserGroup(String name) {
        myBatisRepository.deleteUserGroup(name);
    }
    public List<Tbugr001> findGroupByUser(String email) {
        return myBatisRepository.findGroupByUser(email);
    }

    public List<Tbugr001> findUserByGroup(String name) {
        return myBatisRepository.findUserByGroup(name);
    }

    public void deleteUserFromGroup(String email,String name) {
        myBatisRepository.deleteUserFromGroup(email,name);
    }
}


