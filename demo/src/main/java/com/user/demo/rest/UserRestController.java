package com.user.demo.rest;

import com.user.demo.MessageHandler;
import com.user.demo.auth.CustomAuthenticationProvider;
import com.user.demo.bean.Tbu4001;
import com.user.demo.bean.Tbugr001;
import com.user.demo.business.UserBusinessController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RestController
public class UserRestController {

    @Autowired
    private UserBusinessController businessController;

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @GetMapping("/get-logged-user")
    public Tbu4001 getCurrentUser(){
        return authenticationProvider.getUser();
    }

    @PostMapping("/login")
    public MessageHandler setCurrentUser(@RequestBody Tbu4001 user){
        return businessController.setCurrentUser(user);
    }
    @PutMapping("/logout")
    public void logoutUser(){
        businessController.logoutUser();
    }
    @GetMapping("/get-users")
    public List<Tbu4001> getUsers() {
        return businessController.getUsers();
    }

    @GetMapping("/get-by-fname")
    public List<Tbu4001> findByFName(@RequestParam String fName) {
        return businessController.findByFName(fName);
    }

    @GetMapping("/get-by-email")
    public Tbu4001 findByEmail(@RequestParam String email) {
        return businessController.findByEmail(email);
    }

    @PostMapping("/add-user")
    public void addUser(@RequestBody Tbu4001 user){
        businessController.addUser(user);
    }

    @PostMapping("/update-user")
    public void updateUser(@RequestBody Tbu4001 user){
        businessController.updateUser(user);
    }

    @PutMapping("/delete-user")
    public void deleteUser(@RequestParam String email) {
        businessController.deleteUser(email);
    }

    @PostMapping("/add-to-group")
    public void addUsersToGroup(@RequestBody List<Tbu4001> users){
            businessController.addUsersToGroup(users);
    }
    @GetMapping("/get-groups")
    public List<Tbugr001> getGroups() {
        return businessController.getGroups();
    }

    @PostMapping("/add-group")
    public void addGroup(@RequestParam String name){
        businessController.addGroup(name);
    }

    @PutMapping("/delete-group")
    public void deleteGroup(@RequestParam String name) {
        businessController.deleteGroup(name);
    }

}
