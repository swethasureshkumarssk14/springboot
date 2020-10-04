package com.example.expensetracker.ExpenseTracker.controller;

import com.example.expensetracker.ExpenseTracker.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.example.expensetracker.ExpenseTracker.model.User;
@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @GetMapping("/registerUser")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailId=user.getEmailId();
        if("".equals(tempEmailId)){
           User userObj = service.fetchUserByEmailId(tempEmailId);
            if(userObj!=null){
                throw new Exception("user with "+tempEmailId+" exists");
            }
        }
        User userObj=null;
        userObj=service.saveUser(user);
        return userObj;
    }

    @PostMapping("login")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempEmailId= user.getEmailId();
        String tempPass=user.getPassword();
        User userObj= null;
        if(tempEmailId!=null && tempPass!=null){
            userObj=service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
        }
if(userObj==null){
    throw new Exception("BAD CREDENTIALS");
}
return userObj;
    }
}
