package com.hotel.Controller;

import com.hotel.Entity.Apartments;
import com.hotel.Entity.Country;
import com.hotel.Entity.Hotel;
import com.hotel.Entity.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Component()
public class SessionSupplier {


    private final SessionFactory sessionFactory =
            new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Hotel.class)
                    .addAnnotatedClass(Country.class)
                    .addAnnotatedClass(Apartments.class)
                    .addAnnotatedClass(Reservation.class)
                    .buildSessionFactory();
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }



    public void addHotel(String name ){
        try {
            Hotel hotel = new Hotel(name);
            Session session = getSession();
            //start transaction

            session.beginTransaction();
            //add hotel to DB table
            session.save(hotel);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
    /*
    method for retrieving hotel objects from DB
    return null if no such object was found
     */
//    public Hotel getHotelById(int id){
//        Hotel curr;
//        try {
//            Session session = sessionFactory.getCurrentSession();
//
//            session.beginTransaction();
//            curr = session.get(Hotel.class,id);
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }
//        return curr;
//    }
//    public List<Hotel>  getAllHotels(){
//        List<Hotel> list;
//        try {
//            Session session = getSession();
//            session.beginTransaction();
//            list = session//Hotel and hotelName - are from Java source class(not from DB)
//                    .createQuery("from Hotel where hotelName='Marina' and hotelName like '%rina'" )//HQL script
//                    .getResultList();
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }
//        return list;
//    }
//    /*
//    update hotel name by specified name
//     */
//    public void updateHotelByName(String name,String newName){
//        try {
//            Session session = getSession();
//            session.beginTransaction();
//            List <Hotel> list = session
//                    .createQuery("from Hotel where hotelName= ?1")//<----new query parameters style
//                    .setParameter(1,name)
//                    .getResultList();
//            list.get(0).setHotelName(newName);
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }
//
//    }
//    /*
//    better method for updating hotel's name  by its specified id
//     */
//    public void update(int id,String updated ){
//        try {
//            Session session = getSession();
//            session.beginTransaction();
//            session.createQuery("update Hotel set hotelName=?2 where id=?1")
//                    .setParameter(1,id)
//                    .setParameter(2,updated)
//                    .executeUpdate();
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }
//
//    }
//    /*
//    standard approach for deleting object by specified id
//    using session's delete method
//     */
//    public void deleteHotel(int id){
//        try {
//            Session session = getSession();
//            session.beginTransaction();
//    return null if record with specified id is found
//            Hotel hotel = session.get(Hotel.class,id);
//            session.delete(hotel);
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }
//
//    }
////IN QUERY SPECIFY TABLE NAME AND FIELD FROM JAVA CLASS(NOT FROM DATABASE)<-------------------------
//    /*
//    better deleting method where can specify some deleting conditions
//     */
//    public void deleteByName(String name){
//        try {
//            Session session = getSession();
//            session.beginTransaction();
//            session.createQuery("delete from Hotel where hotelName=?1")
//                    .setParameter(1,name)
//                    .executeUpdate();
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }
//
//
//    }

    public void deleteHotelByName(String hotelName,String countryName){
        Session session = getSession();
        try{

            session.beginTransaction();
            Country country = (Country)session.createQuery("from Country where countryName=?1")
                    .setParameter(1,countryName)
                    .getSingleResult();
            Hotel hotel = (Hotel)session
                    .createQuery("from Hotel where hotelName=?1 and country=?2")
                    .setParameter(1,hotelName)
                    .setParameter(2,country)
                    .getSingleResult();
            //remove the associated link reference
            //break bi-directional link
            hotel.getCountry().getHotels().remove(hotel);

            session.delete(hotel);
            session.getTransaction().commit();
        }catch (NoResultException exception) {
            System.out.println("No such country or hotel found");
        }finally {
            //need to close the session to prevent connection leak!!!!!!!!!!!!!!!!!!!!!!!!!
            session.close();
            sessionFactory.close();
        }
    }
    public void addHotel(){

        try {
            Session session = getSession();
            session.beginTransaction();
//            Country country = new Country("Germany");
            Hotel hotel = new Hotel("Spain hotel");
//            Country country = session.get(Country.class,3);
            Country country = new Country("Spain");
            country.addHotel(hotel);
//            hotel.setCountry(country);
            session.save(country);
//            session.save(hotel);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
    public Country getCountryById(int id){
        Country country=null;
        try {
            Session session = getSession();
            session.beginTransaction();
            country = session.get(Country.class,id);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
        return country;
    }

    public static void main(String[] args) {
//        Country c = new SessionSupplier().getCountryById(3);
//        if(c!=null){
//            System.out.println(c);
//        }
//        new SessionSupplier().deleteHotelByName("fadf","Germany");
//            new SessionSupplier().addHotel();
//        new SessionSupplier().deleteHotel(1);
//        new SessionSupplier().addHotel("Olga");
//        new SessionSupplier().addHotel("Dana");
//        new SessionSupplier().update(2,"Hotel updated");
//        new SessionSupplier().updateHotelByName("Marina","Marina - 2");
//        System.out.println(new SessionSupplier().getAllHotels().isEmpty()?"Empty list":"Non-empty list");
    }

}
