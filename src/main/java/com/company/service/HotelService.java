package com.company.service;

import com.company.dto.HotelDTO;
import com.company.entity.HotelEntity;
import com.company.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public HotelDTO created(HotelDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setName(dto.getName());

        hotelRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public List<HotelEntity> hotelEntityList() {
        return hotelRepository.findAll();
    }

    public HotelEntity getById(Integer id) {
        return hotelRepository.getById(id);
    }

    public HotelDTO update(Integer id, HotelDTO dto) {
        HotelEntity entity = getById(id);
        entity.setName(dto.getName());

        hotelRepository.save(entity);

        return dto;
    }

    public boolean delete(Integer id) {
        HotelEntity entity = getById(id);
        if (entity == null) {
            return false;
        }
        hotelRepository.delete(entity);
        return true;
    }
}
