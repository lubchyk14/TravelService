package com.hotel.DAO.Impl;

import com.hotel.DAO.ReservationDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ReservationDAOImpl implements ReservationDAO {

    @Autowired
    private SessionFactory sessionFactory;
}
