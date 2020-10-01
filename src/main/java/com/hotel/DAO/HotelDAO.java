package com.hotel.DAO;

import com.hotel.Entity.Apartments;
import com.hotel.Entity.Hotel;

import java.util.List;

public interface HotelDAO {

    public Hotel findHotelByName(String hotelName);

    public List<Hotel> getAllHotels();

    public void saveHotel(Hotel hotel);

    public Hotel findHotelById(int hotel);
}
