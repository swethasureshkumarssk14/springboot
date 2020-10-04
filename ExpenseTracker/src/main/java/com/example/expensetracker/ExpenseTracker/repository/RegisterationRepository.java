package com.example.expensetracker.ExpenseTracker.repository;

import com.example.expensetracker.ExpenseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface RegisterationRepository extends JpaRepository<User, Integer> {
   public  User findByEmailId(String emailId);
   public  User findByEmailIdAndPassword(String email, String password);
}
