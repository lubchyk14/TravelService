package com.hotel.DAO;

import com.hotel.Entity.Apartments;
import com.hotel.Entity.Hotel;

import java.util.List;

public interface ApartmentsDAO {

    public void saveApartments(Apartments apartments);

    public List<Apartments> getApartmentsByHotelId(Hotel hotel);

    public Apartments getApartmentsById(int apartmentsId);
}
