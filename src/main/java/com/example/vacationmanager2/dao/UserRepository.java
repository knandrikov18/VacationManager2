package com.example.vacationmanager2.dao;

import com.example.vacationmanager2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>   {

    User findByNicknameAndPassword(String username, String password);

}