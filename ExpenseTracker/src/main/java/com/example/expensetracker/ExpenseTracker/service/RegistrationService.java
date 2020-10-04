package com.example.expensetracker.ExpenseTracker.service;

import com.example.expensetracker.ExpenseTracker.model.User;
import com.example.expensetracker.ExpenseTracker.repository.RegisterationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegisterationRepository repo;
    private String email;
    private User user;


    public User saveUser(User user) {

        return repo.save(user);
    }

    public User fetchUserByEmailId(String email) {

        return repo.findByEmailId(email);
    }


   public User fetchUserByEmailIdAndPassword(String tempEmailId, String tempPass) {
        return repo.findByEmailIdAndPassword(tempEmailId,tempPass);
    }
}
