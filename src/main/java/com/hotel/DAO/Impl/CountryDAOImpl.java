package com.hotel.DAO.Impl;

import com.hotel.DAO.CountryDAO;
import com.hotel.Entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class CountryDAOImpl implements CountryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveCountry(String countryToSave){
        Country country = new Country(countryToSave);
        Session session = sessionFactory.getCurrentSession();
        session.save(country);
    }



    public CountryDAOImpl() {
    }
}
