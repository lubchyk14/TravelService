package com.hotel.Service;

import com.hotel.Entity.Apartments;
import com.hotel.Entity.Hotel;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public interface ApartmentsService {

    public void saveApartments(Apartments apartments);

    public List<Apartments> getApartmentsByHotelId(Hotel hotel);

    public Apartments getApartmentsById(int apartmentsId);
}
