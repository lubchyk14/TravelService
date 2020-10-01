package com.hotel.Service.Impl;

import com.hotel.DAO.HotelDAO;
import com.hotel.Entity.Apartments;
import com.hotel.Entity.Hotel;
import com.hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    @Qualifier("HotelDAOImpl")
    private HotelDAO hotelDAO;


    @Override
    @Transactional
    public Hotel findHotelByName(String hotelName) {
        return hotelDAO.findHotelByName(hotelName);
    }


    @Override
    @Transactional
    public List<Hotel> getAllHotels() {
        return hotelDAO.getAllHotels();
    }


    @Override
    @Transactional
    public void saveHotel(Hotel hotel) {
        hotelDAO.saveHotel(hotel);
    }

    @Override
    @Transactional
    public Hotel findHotelById(int hotel) {
        return hotelDAO.findHotelById(hotel);
    }
}
