package com.example.vacationmanager2.Controller;

import antlr.StringUtils;
import com.example.vacationmanager2.dao.UserRepository;
import com.example.vacationmanager2.exception.RecordNotFoundException;
import com.example.vacationmanager2.model.User;
import com.example.vacationmanager2.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class userController {
    @Autowired
    UserRepository userRepo;
    @Autowired
    userService service;
    User loggedUser;

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/loginPage")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/registerPage")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user, Model model) {
        userRepo.save(user);
        return "index";
    }
    @GetMapping("/ceoPage")
    public String ceoPage(Model model) {
        model.addAttribute("getLoggedUser", loggedUser);
        return "ceo";
    }
    @RequestMapping(value = "/usersInfo")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "allUsers";
    }

    @GetMapping(value="/login")
    public String getUserByUsernameAndPassword(@ModelAttribute User user, Model model) {
        User loggedUser = userRepo.findByNicknameAndPassword(user.getNickname(), user.getPassword());
        model.addAttribute("getLoggedUser", loggedUser);

        if(loggedUser.getRole().contains("CEO")) {
            return "ceo";
        }
        else if(loggedUser.getRole().contains("Developer")) {
            return "developer";
        }
        return "view";
    }
}
