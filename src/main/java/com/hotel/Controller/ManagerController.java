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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String addApartmentsToHotel( @ModelAttribute @Valid Apartments apartments,
                                        BindingResult bindingResult,
                                        @RequestParam String hotelId,
                                       Model model ){
        List<Hotel> hotels = hotelService.getAllHotels();
        model.addAttribute("hotels",hotels);
        if(bindingResult.hasErrors()){
            return "add-apartments-form";
        }
        try {
            Integer id = Integer.valueOf(hotelId);
            Hotel hotelObj = hotelService.findHotelById(id);
            apartments.setHotel(hotelObj);
            apartmentsService.saveApartments(apartments);
            String successMessage = apartments.getRoomClass()+" apartments successfully added to "
                    +hotelObj.getHotelName()+" in "+hotelObj.getCountry().getCountryName();
            model.addAttribute("success",successMessage);
        } catch (NumberFormatException e) {
            model.addAttribute("numberError","Count of rooms must be a number");
            return "add-apartments-form";
        }catch (NullPointerException exception){
            model.addAttribute("hotelError","Specified wrong hotel name");
            return "add-apartments-form";
        }
        return "success";
    }

    @GetMapping("/getAllReservations")
    public String getAllReservations(Model model){
        Map<String, List<Reservation>> reservations =
                reservationService.getAllUsersWithReservations();
        model.addAttribute("reservationsMap", reservations);
        return "find-user-reservations";
    }
}
