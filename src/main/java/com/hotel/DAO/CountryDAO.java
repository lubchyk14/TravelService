package com.hotel.DAO;

import com.hotel.Entity.Country;
import org.hibernate.SessionFactory;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.List;

public interface CountryDAO {

    public void saveCountry(Country country);
//    public void saveCountry(String countryToSave);
    public List<Country> getCountries();

    public Country getCountryById(int country);
}
