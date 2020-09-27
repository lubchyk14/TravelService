package com.hotel.DAO.Impl;

import com.hotel.DAO.CountryDAO;
import com.hotel.Entity.Country;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CountryDAOImpl implements CountryDAO {

//    @Autowired
//    @Qualifier("sessionFactoryBean")
//    private LocalSessionFactoryBean sessionFactoryBean;

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public void saveCountry(Country country){
        Session session= sessionFactory.getCurrentSession();
        session.save(country);
    }

    public List<Country> getCountries() {
        Session session = sessionFactory.getCurrentSession();
        List<Country> countryList = session.createQuery("from Country").getResultList();
        return countryList;
    }

    @Override
    public Country getCountryById(int countryId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Country.class,countryId);
    }

}
