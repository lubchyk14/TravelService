package com.hotel.DAO.Impl;

import com.hotel.DAO.ApartmentsDAO;
import com.hotel.Entity.Apartments;
import com.hotel.Entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApartmentsDAOImpl implements ApartmentsDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveApartments(Apartments apartments) {
        Session session = sessionFactory.getCurrentSession();
        session.save(apartments);
    }

    @Override
    public List<Apartments> getApartmentsByHotelId(Hotel hotel) {

        Session session = sessionFactory.getCurrentSession();
        List <Apartments> apartmentsList = session.createQuery("from Apartments where hotel=?1")
                .setParameter(1,hotel)
                .getResultList();
        return apartmentsList;
    }

    @Override
    public Apartments getApartmentsById(int apartmentsId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Apartments.class,apartmentsId);

    }

//    @Autowired
//    private SessionFactory sessionFactory;
}
