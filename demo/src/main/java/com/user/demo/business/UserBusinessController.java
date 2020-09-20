package com.user.demo.business;

import com.user.demo.MessageHandler;
import com.user.demo.auth.CustomAuthenticationProvider;
import com.user.demo.bean.Tbgroups;
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

    public MessageHandler addUser(Tbu4001 user){
        if(userDataController.findByEmail(user.getEmail()) == null) {
            userDataController.addUser(user);
            messageHandler.setLevel("INFO");
            messageHandler.setMessage("OK");
        } else {
            messageHandler.setLevel("ERROR");
            messageHandler.setMessage("This email is already used! Please try again");
        }
        return messageHandler;
    }

    public void updateUser(Tbu4001 user){
        userDataController.updateUser(user);
    }

    public MessageHandler deleteUser(String email) {
        if(userDataController.findByEmail(email) != null){

            if(!isAdmin(email)){
                if(!getCurrentUser().getEmail().equals(email)){
                    userDataController.deleteUser(email);
                    messageHandler.setLevel("INFO");
                    messageHandler.setMessage("OK");
                } else {
                    messageHandler.setLevel("ERROR");
                    messageHandler.setMessage("You cannot delete yourself! Please try again");
                }
            } else {
                if(email.equals(getCurrentUser().getEmail())) {
                    messageHandler.setLevel("ERROR");
                    messageHandler.setMessage("You cannot delete yourself! Please try again");
                } else {
                    messageHandler.setLevel("ERROR");
                    messageHandler.setMessage("You cannot delete admin user ! Please try again");
                }
            }
        } else {
            messageHandler.setLevel("ERROR");
            messageHandler.setMessage("This email does not exists! Please try again");
        }
        return messageHandler;

    }

    public void addUsersToGroup(String email, String name){
            userDataController.addUsersToGroup(email,name);
    }

    public List<Tbugr001> getGroupsWithUser() {
        return userDataController.getGroupsWithUser();
    }

    public List<Tbgroups> getGroups() {
        return userDataController.getGroups();
    }

    public void addGroup( String name){
        userDataController.addGroup(name);
    }

    public void deleteGroup( String name) {
        if(userDataController.findUserGroup(name) != null) {
            userDataController.deleteUserGroup(name);
        }
        userDataController.deleteGroup(name);
    }

    public void deleteUserFromGroup(String email, String name) {
            userDataController.deleteUserFromGroup(email,name);
    }

    public boolean isAdmin(String email) {
        if(email== "admin"){
            return true;
        }
        return false;
    }

    public Tbgroups findGroup(String name){
       return userDataController.findGroup(name);
    }
}
