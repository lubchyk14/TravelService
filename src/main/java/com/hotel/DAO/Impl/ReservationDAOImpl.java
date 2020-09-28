package com.hotel.DAO.Impl;

import com.hotel.DAO.ReservationDAO;
import com.hotel.Entity.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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

//    @Autowired
//    private SessionFactory sessionFactory;
}
