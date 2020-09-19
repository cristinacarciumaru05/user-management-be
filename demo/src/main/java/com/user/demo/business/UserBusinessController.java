package com.user.demo.business;

import com.user.demo.MessageHandler;
import com.user.demo.auth.CustomAuthenticationProvider;
import com.user.demo.bean.Tbu4001;
import com.user.demo.bean.Tbugr001;
import com.user.demo.data.UserDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusinessController {

    @Autowired
    private UserDataController userDataController;

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Autowired
    private MessageHandler messageHandler;

    public Tbu4001 getCurrentUser(){
        return userDataController.getCurrentUser();
    }

    public MessageHandler setCurrentUser(Tbu4001 user){
        if ( userDataController.findByEmail(user.getEmail())!=null &&
           userDataController.checkPassword(user.getEmail(), user.getPassword()) ) {

            authenticationProvider.setUser(userDataController.findByEmail(user.getEmail()));
            messageHandler.setLevel("INFO");
            messageHandler.setMessage("Login");
        } else {
            messageHandler.setLevel("ERROR");
            messageHandler.setMessage("Wrong Email or password ! Please try again");
        }
        return messageHandler;
    }

    public void logoutUser() {
        authenticationProvider.setUser(null);
    }
    public List<Tbu4001> getUsers() {
        return userDataController.getUsers();
    }


    public List<Tbu4001> findByFName(String fName) {
        return userDataController.findByFName(fName);
    }


    public Tbu4001 findByEmail(String email) {
        return userDataController.findByEmail(email);
    }


    public void addUser(Tbu4001 user){
        userDataController.addUser(user);
    }


    public void updateUser(Tbu4001 user){
        userDataController.updateUser(user);
    }


    public void deleteUser(String email) {
        userDataController.deleteUser(email);
    }


    public void addUsersToGroup(List<Tbu4001> users){
        for (Tbu4001 user :users) {
            userDataController.addUsersToGroup(user);
        }
    }

    public List<Tbugr001> getGroups() {
        return userDataController.getGroups();
    }


    public void addGroup( String name){
        userDataController.addGroup(name);
    }


    public void deleteGroup( String name) {
        userDataController.deleteGroup(name);
    }
}
