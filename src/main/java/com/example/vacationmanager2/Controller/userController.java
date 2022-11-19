package com.example.vacationmanager2.Controller;

import com.example.vacationmanager2.dao.UserRepository;
import com.example.vacationmanager2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class userController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user, Model model) {

        User user_inserted = userRepo.save(user);
        model.addAttribute("message", user_inserted.getFirstName() + " " + user_inserted.getLastName());

        return "view";
    }
}
