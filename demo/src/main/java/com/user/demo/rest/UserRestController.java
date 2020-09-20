package com.user.demo.rest;

import com.user.demo.MessageHandler;
import com.user.demo.auth.CustomAuthenticationProvider;
import com.user.demo.bean.Tbgroups;
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
    public MessageHandler addUser(@RequestBody Tbu4001 user){
        return businessController.addUser(user);
    }

    @PostMapping("/update-user")
    public void updateUser(@RequestBody Tbu4001 user){
        businessController.updateUser(user);
    }

    @PutMapping("/delete-user")
    public MessageHandler deleteUser(@RequestParam String email) {
        return businessController.deleteUser(email);
    }

    @PostMapping("/add-to-group")
    public void addUsersToGroup(@RequestParam String email,
                                @RequestParam String name) {
            businessController.addUsersToGroup(email,name);
    }

    @GetMapping("/get-groups-user")
    public List<Tbugr001> getGroupsWithUser() {
        return businessController.getGroupsWithUser();
    }

    @GetMapping("/find-group")
    public Tbgroups findGroup(@RequestParam String name) {
        return businessController.findGroup(name);
    }

    @PostMapping("/add-group")
    public void addGroup(@RequestParam String name){
        businessController.addGroup(name);
    }

    @PutMapping("/delete-group")
    public void deleteGroup(@RequestParam String name) {
        businessController.deleteGroup(name);
    }

    @PutMapping("/delete-user-from-group")
    public void deleteUserFromGroup(@RequestParam String email,
                                    @RequestParam String name) {
        businessController.deleteUserFromGroup(email,name);
    }

    @GetMapping("/get-group-by-user")
    public List<Tbugr001> findGroupByUser(@RequestParam String email) {
        return businessController.findGroupByUser(email);
    }

    @GetMapping("/get-user-by-group")
    public List<Tbugr001> findUserByGroup(@RequestParam String name) {
        return businessController.findUserByGroup(name);
    }

    @GetMapping("/get-groups")
    public List<Tbgroups> getGroups() {
        return businessController.getGroups();
    }
}
