package com.hotel.Service.Impl;

import com.hotel.DAO.CountryDAO;
import com.hotel.Entity.Country;
import com.hotel.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Override
    @Transactional
    public List<Country> getAllCountries() {
        return countryDAO.getCountries();
    }

    @Override
    @Transactional
    public void saveCountry(Country country) {
        countryDAO.saveCountry(country);
    }

    @Override
    @Transactional
    public Country getCountryById(int country) {
        return countryDAO.getCountryById(country);
    }
}
