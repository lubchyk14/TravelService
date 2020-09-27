package com.hotel.DAO.Impl;

import com.hotel.DAO.ApartmentsDAO;
import com.hotel.Entity.Apartments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApartmentsDAOImpl implements ApartmentsDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveApartments(Apartments apartments) {
        Session session = sessionFactory.getCurrentSession();
        session.save(apartments);
    }

//    @Autowired
//    private SessionFactory sessionFactory;
}
