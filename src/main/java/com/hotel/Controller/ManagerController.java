package com.hotel.Controller;

import com.hotel.Entity.Apartments;
import com.hotel.Entity.Country;
import com.hotel.Entity.Hotel;
import com.hotel.Entity.Reservation;
import com.hotel.Service.ApartmentsService;
import com.hotel.Service.CountryService;
import com.hotel.Service.HotelService;
import com.hotel.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private ApartmentsService apartmentsService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/addHotel")
    public String addHotel(Model model){
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries",countries);
        model.addAttribute("hotel",new Hotel());
        return "add-hotel-form";
    }
    @PostMapping("/addHotel")
    public String addHotel(@ModelAttribute Hotel hotel,
                           @RequestParam int country,
                           Model model){
        Country countryObj = countryService.getCountryById(country);
        hotel.setCountry(countryObj);
        hotelService.saveHotel(hotel);
        String successMessage = hotel.getHotelName()+" hotel was successfully added to " +countryObj.getCountryName();
        model.addAttribute("success",successMessage);
        return "success";
    }


    @GetMapping("/addApartments")
    public String addApartments(Model model){
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("apartments",new Apartments());
        model.addAttribute("hotels",hotels);
        return "add-apartments-form";
    }
    @PostMapping("/addApartments")
    public String addApartmentsToHotel(@ModelAttribute Apartments apartments,
                                       @RequestParam int hotel,
                                       Model model){
        Hotel hotelObj = hotelService.findHotelById(hotel);
        apartments.setHotel(hotelObj);
        apartmentsService.saveApartments(apartments);
        String successMessage = apartments.getRoomClass()+" apartments successfully added to "
                +hotelObj.getHotelName()+" in "+hotelObj.getCountry().getCountryName();
        model.addAttribute("success",successMessage);
        return "success";
    }

    @GetMapping("/getAllReservations")
    public String getAllReservations(Model model){
        Map<String, List<Reservation>> reservations =
                reservationService.getAllUsersWithReservations();
//        for (Map.Entry<String,List<Reservation>> e:map.entrySet()) {
//            System.out.println(e.getKey()+" "+e.getValue());
//        }
//        Map<String,String> map1 = new HashMap<>();
//        map1.put("key1","value1");
//        model.addAttribute("map",map);
//        model.addAttribute("set",map.keySet());
//        Map<String, String> countryList = new HashMap<String, String>();
//        countryList.put("United States", "Washington DC");
//        countryList.put("India", "Delhi");
//        countryList.put("Germany", "Berlin");
//        countryList.put("France", "Paris");
//        countryList.put("Italy", "Rome");
        model.addAttribute("reservationsList", reservations);
//        request.setAttribute("capitalList", countryList);
        return "find-user-reservations";
//        return "find-user-reservations";
    }
}
