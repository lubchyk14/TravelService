package com.hotel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/loginPage")
    public String login(){
        return "login";
    }
}