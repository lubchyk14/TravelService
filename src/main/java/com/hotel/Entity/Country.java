package com.hotel.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class    Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER,
            mappedBy = "country")
    private List<Hotel> hotels;

    public Country() {
    }

    public Country(String countryName) {
        this.countryName = countryName;
    }
    public Country(String countryName, List<Hotel> hotels) {
        this.countryName = countryName;
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", hotels=" + hotels +
                '}';
    }

    public void addHotel(Hotel hotel){
        if(hotels==null){
            hotels=new ArrayList<>();
        }
        hotel.setCountry(this);
        hotels.add(hotel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
