package com.hotel.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hotel_name")
    private String hotelName;

    @ManyToOne(fetch = FetchType.EAGER,
                cascade = {CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH})
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "hotel",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Apartments> apartmentsList;

    public Hotel() {
    }

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
    }

    public Hotel(String hotelName, Country country) {
        this.hotelName = hotelName;
        this.country = country;
    }

    public void addApartments(Apartments apartments){
        if (apartmentsList==null){
            apartmentsList=new ArrayList<>();
        }
        apartments.setHotel(this);
        apartmentsList.add(apartments);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Apartments> getApartmentsList() {
        return apartmentsList;
    }

    public void setApartmentsList(List<Apartments> apartmentsList) {
        this.apartmentsList = apartmentsList;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }


}
