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
