package com.hotel.Service.Impl;

import com.hotel.DAO.ReservationDAO;
import com.hotel.Entity.Apartments;
import com.hotel.Entity.Reservation;
import com.hotel.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    public Set<Integer> getInvalidIdsOfApartments(List<Apartments> apartmentsList, LocalDate startDate, LocalDate endDate) {
        Set<Integer> setOfInvalidApartmentsIds = new HashSet<>();
        apartmentsList.stream().
                flatMap(apartments -> apartments.getReservations().stream())
                .forEach(reservation ->
                {
                    LocalDate reservationStartDate  = reservation.getStartDate().toLocalDate();
                    LocalDate reservationEndDate = reservation.getEndDate().toLocalDate();
                    Integer id = reservation.getApartments().getId();
                    if((startDate.isAfter(reservationStartDate) && startDate.isBefore(reservationEndDate))
                            || (endDate.isAfter(reservationStartDate) && endDate.isBefore(reservationEndDate))){
                        setOfInvalidApartmentsIds.add(id);
                    }
                    if(startDate.isBefore(reservationStartDate) && endDate.isAfter(reservationEndDate) ){
                        setOfInvalidApartmentsIds.add(id);
                    }
                });

        return setOfInvalidApartmentsIds;
    }

    @Override
    @Transactional
    public void saveReservation(Reservation reservation) {
        reservationDAO.saveReservation(reservation);
    }

    @Override
    @Transactional
    public HashMap<String, List<Reservation>> getAllUsersWithReservations() {
        List<Reservation> reservationList =
                reservationDAO.getAllReservations();
        return (HashMap<String, List<Reservation>>) reservationList.stream().collect(Collectors.groupingBy(Reservation::getUserName));

    }


}
