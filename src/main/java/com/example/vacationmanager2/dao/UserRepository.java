package com.example.vacationmanager2.dao;

import com.example.vacationmanager2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByNicknameAndPassword(String username, String password);
}