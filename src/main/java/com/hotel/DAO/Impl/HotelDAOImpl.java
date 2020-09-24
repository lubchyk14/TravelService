package com.hotel.DAO.Impl;

import com.hotel.DAO.HotelDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HotelDAOImpl implements HotelDAO {

    @Autowired
    private SessionFactory sessionFactory;
}
