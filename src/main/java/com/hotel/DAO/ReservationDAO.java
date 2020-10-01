package com.hotel.DAO;

import com.hotel.Entity.Reservation;

import java.util.List;

public interface ReservationDAO {
    public void saveReservation(Reservation reservation);

    public List<Reservation> getAllReservations();
}
