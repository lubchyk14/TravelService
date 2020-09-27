package com.hotel.Service;

import com.hotel.Entity.Country;

import java.util.List;

public interface CountryService {

    public List<Country> getAllCountries();
    public void saveCountry(Country country);
    public Country getCountryById(int country);
}
