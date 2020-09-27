package com.hotel.Controller;

import com.hotel.Entity.Hotel;
import com.hotel.Service.CountryService;
import com.hotel.Service.HotelService;
import com.hotel.Service.Impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/findHotel")
    public String findHotel(){
        return "find-hotel-form";
    }

    @PostMapping("/findHotel")
    public String findHotelInCountry(@RequestParam String hotelName ,Model model){
        Hotel hotel = hotelService.findHotelByName(hotelName);
        model.addAttribute("hotel",hotel);
        return "hotel-info";
    }

    @GetMapping("/findApartments/{hotelId}")
    public String findAvailableApartments(@PathVariable int hotelId){
        return null;
    }













//    @GetMapping("/getAllCountries")
//    public String getAllCountries(Model model){
//        model.addAttribute("countries",countryService.getAllCountries());
//        return "show-countries";
//    }
}
