package com.user.demo.rest;

import com.user.demo.bean.Tbu4001;
import com.user.demo.bean.Tbugr001;
import com.user.demo.repository.MyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RestController
public class UserRestController {

    @Autowired
    private MyBatisRepository myBatisRepository;

    @GetMapping("/get-users")
    public List<Tbu4001> getUsers() {
        return myBatisRepository.findAll();
    }

    @GetMapping("/get-by-fname")
    public List<Tbu4001> findByFName(@RequestParam String fName) {
        return myBatisRepository.findByFName(fName);
    }

    @GetMapping("/get-by-email")
    public Tbu4001 findByEmail(@RequestParam String email) {
        return myBatisRepository.findByEmail(email);
    }

    @PostMapping("/add-user")
    public void addUser(@RequestBody Tbu4001 user){
        myBatisRepository.insert(user);
    }

    @PostMapping("/update-user")
    public void updateUser(@RequestBody Tbu4001 user){
        myBatisRepository.update(user);
    }

    @PutMapping("/delete-user")
    public void deleteUser(@RequestParam String email) {
        myBatisRepository.deleteById(email);
    }

    @PostMapping("/add-to-group")
    public void addUsersToGroup(@RequestBody List<Tbu4001> users){
        for (Tbu4001 user :users) {
            myBatisRepository.addUserToGroup(user);
        }
    }
    @GetMapping("/get-groups")
    public List<Tbugr001> getGroups() {
        return myBatisRepository.getGroups();
    }

    @PostMapping("/add-group")
    public void addGroup(@RequestParam String name){
        myBatisRepository.addGroup(name);
    }

    @PutMapping("/delete-group")
    public void deleteGroup(@RequestParam String name) {
        myBatisRepository.deleteGroup(name);
    }

}
