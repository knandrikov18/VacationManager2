package com.example.vacationmanager2.service;
import com.example.vacationmanager2.dao.UserRepository;
import com.example.vacationmanager2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userService {
    @Autowired
    private UserRepository repository;
}
