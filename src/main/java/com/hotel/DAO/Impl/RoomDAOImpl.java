package com.hotel.DAO.Impl;

import com.hotel.DAO.RoomDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    private SessionFactory sessionFactory;
}
