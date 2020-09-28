package com.hotel.Controller;

import com.hotel.Entity.Apartments;
import com.hotel.Entity.Hotel;
import com.hotel.Entity.Reservation;
import com.hotel.Service.ApartmentsService;
import com.hotel.Service.CountryService;
import com.hotel.Service.HotelService;
import com.hotel.Service.Impl.CountryServiceImpl;
import com.hotel.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ApartmentsService apartmentsService;

    @GetMapping("/findHotel")
    public String findHotel(){
        return "find-hotel-form";
    }

    @PostMapping("/findHotel")
    public String findHotelInCountry(@RequestParam String hotelName ,Model model){
        Hotel hotel = hotelService.findHotelByName(hotelName);
        if(hotel==null){
            model.addAttribute("hotelNotFound","Requested hotel name not registered in system");
            return "find-hotel-form";
        }
        model.addAttribute("hotel",hotel);
        return "hotel-info";
    }

    @PostMapping("/findApartments/{hotelId}")
    public String findAvailableApartments(@PathVariable int hotelId,
                                          @RequestParam String startDate,
                                          @RequestParam String endDate,
                                          @RequestParam String userName,
                                          @RequestParam String hotelName,
                                          Model model){

        Hotel hotel = hotelService.findHotelByName(hotelName);
        List <Apartments> apartmentsList =
                apartmentsService.getApartmentsByHotelId(hotel);
        System.out.println("HERE<_-------------------");
        Set<Integer> setOfInvalidApartments = reservationService.getInvalidIdsOfApartments(apartmentsList,
                LocalDate.parse(startDate),
                LocalDate.parse(endDate));
//        List<Apartments> apartmentsList = hotel.getApartmentsList();

        Date start = Date.valueOf(LocalDate.parse(startDate));
        Date end = Date.valueOf(LocalDate.parse(endDate));
        Reservation reservation = new Reservation(start,end,userName);
        model.addAttribute("reservation",reservation);
        System.out.println(reservation);
        model.addAttribute("invalid",setOfInvalidApartments);

//        Set<Integer> validReservationIds = apartmentsService.findValidApartmentsFromHotelByDates(start,end,apartmentsList);
        model.addAttribute("hotel",hotel);
        return "hotel-info";
    }

    @GetMapping("/bookApartments/{apartmentsId}")
    public String bookApartments(@PathVariable int apartmentsId,
                                 @ModelAttribute Reservation reservation )
    {


        System.out.println(reservation+ "After <------------");
        Apartments apartments = apartmentsService.getApartmentsById(apartmentsId);
        reservation.setApartments(apartments);
        reservationService.saveReservation(reservation);

        return "home";
    }




//    @GetMapping("/getAllCountries")
//    public String getAllCountries(Model model){
//        model.addAttribute("countries",countryService.getAllCountries());
//        return "show-countries";
//    }
}
