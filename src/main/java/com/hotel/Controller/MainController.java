package com.hotel.Controller;

import com.hotel.DAO.CountryDAO;
import com.hotel.DAO.Impl.CountryDAOImpl;
import com.hotel.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private CountryService countryDAO;

    @GetMapping("/home")
    public String home(Model model){
//        countryDAO.saveCountry("Canada");
        return "home";
    }

    @GetMapping("/loginPage")
    public String login(){
        return "login";
    }
}
