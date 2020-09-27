package com.hotel.DAO.Impl;

import com.hotel.DAO.HotelDAO;
import com.hotel.Entity.Apartments;
import com.hotel.Entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("HotelDAOImpl")
public class HotelDAOImpl implements HotelDAO {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Hotel findHotelByName(String hotelsName) {
        Session session = sessionFactory.getCurrentSession();

        try {
            Hotel hotel =(Hotel) session.createQuery("from Hotel where hotelName=?1")
                    .setParameter(1,hotelsName)
                    .getSingleResult();
            return hotel;
        } catch (Exception e) {
            return null;
        }

    }



    @Override
    public List<Hotel> getAllHotels() {
        Session session = sessionFactory.getCurrentSession();
        List<Hotel> hotels = session.createQuery("from Hotel")
                .getResultList();
        return hotels;
    }

    @Override
    public void saveHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.save(hotel);
    }

    @Override
    public Hotel findHotelById(int hotel) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotelObj = session.get(Hotel.class,hotel);
        return hotelObj;
    }
}















