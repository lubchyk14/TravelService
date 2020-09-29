package com.hotel.DAO.Impl;

import com.hotel.DAO.ReservationDAO;
import com.hotel.Entity.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationDAOImpl implements ReservationDAO {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void saveReservation(Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        Session session = sessionFactory.getCurrentSession();
        List <Reservation> reservationList=session.createQuery("from Reservation ").getResultList();
        return reservationList;
    }

//    @Autowired
//    private SessionFactory sessionFactory;
}
