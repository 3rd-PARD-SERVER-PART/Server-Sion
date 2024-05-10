package com.example.hw5.user.repo;
import com.example.hw5.user.entity.UserLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanRepo extends JpaRepository<UserLoan, Long>{ }
