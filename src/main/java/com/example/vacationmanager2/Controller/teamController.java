package com.example.vacationmanager2.Controller;

import com.example.vacationmanager2.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class teamController {
    @Autowired
    UserRepository userRepo;
    @RequestMapping(value = "/TeamInfo")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", userRepo.findAll());
        return "AllTeams";
    }
}
