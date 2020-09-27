package com.hotel.Service.Impl;

import com.hotel.DAO.ApartmentsDAO;
import com.hotel.Entity.Apartments;
import com.hotel.Service.ApartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ApartmentsServiceImpl implements ApartmentsService {

    @Autowired
    private ApartmentsDAO apartmentsDAO;

    @Override
    @Transactional
    public void saveApartments(Apartments apartments) {
        apartmentsDAO.saveApartments(apartments);
    }
}
