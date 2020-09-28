package com.hotel.Service.Impl;

import com.hotel.DAO.ApartmentsDAO;
import com.hotel.DAO.ReservationDAO;
import com.hotel.Entity.Apartments;
import com.hotel.Entity.Hotel;
import com.hotel.Entity.Reservation;
import com.hotel.Service.ApartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApartmentsServiceImpl implements ApartmentsService {

    @Autowired
    private ApartmentsDAO apartmentsDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    @Transactional
    public void saveApartments(Apartments apartments) {
        apartmentsDAO.saveApartments(apartments);
    }

    @Override
    @Transactional
    public Set<Integer> findValidApartmentsFromHotelByDates(Date start, Date end, List<Apartments> apartmentsList) {
//        Set<Integer> listOfValidReservationIds = apartmentsList
//                .stream()
//                .flatMap(apartments -> apartments.getReservations().stream())
//                .map(Reservation::getId )
//                .collect(Collectors.toSet());
//        List<Reservation> list =
//                reservationDAO.findReservationsByDatesAndIds(start,end,listOfValidReservationIds);
//



        return null;
    }

    @Override
    @Transactional
    public List<Apartments> getApartmentsByHotelId(Hotel hotel) {
        return apartmentsDAO.getApartmentsByHotelId(hotel);
    }

    @Override
    @Transactional
    public Apartments getApartmentsById(int apartmentsId) {
        return apartmentsDAO.getApartmentsById(apartmentsId);

    }
}
