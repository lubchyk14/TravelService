package com.hotel.Service;

import com.hotel.Entity.Apartments;
import com.hotel.Entity.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ReservationService {

    public  Set<Integer> getInvalidIdsOfApartments(List<Apartments> apartmentsList, LocalDate startDate, LocalDate endDate);


    public void saveReservation(Reservation reservation);
}
