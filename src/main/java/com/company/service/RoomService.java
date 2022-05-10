package com.company.service;

import com.company.dto.RoomDTO;
import com.company.entity.HotelEntity;
import com.company.entity.RoomEntity;
import com.company.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelService hotelService;

    public RoomDTO created(RoomDTO dto) {
        HotelEntity hotelEntity = hotelService.getById(dto.getHotel());
        RoomEntity entity = new RoomEntity();
        entity.setFloor(dto.getFloor());
        entity.setHotel(hotelEntity);
        entity.setNumber(dto.getNumber());
        entity.setSize(dto.getSize());

        roomRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public List<RoomEntity> hotelEntityList() {
        return roomRepository.findAll();
    }

    public RoomEntity getById(Integer id) {
        return roomRepository.getById(id);
    }

    public RoomDTO update(Integer id, RoomDTO dto) {
        HotelEntity hotelEntity = hotelService.getById(dto.getHotel());
        RoomEntity entity = getById(id);
        entity.setFloor(dto.getFloor());
        entity.setHotel(hotelEntity);
        entity.setNumber(dto.getNumber());
        entity.setSize(dto.getSize());

        roomRepository.save(entity);

        return dto;
    }

    public boolean delete(Integer id) {
        RoomEntity entity = getById(id);
        if (entity == null) {
            return false;
        }
        roomRepository.delete(entity);
        return true;
    }

    public List<RoomEntity> get(Integer hotelId) {
        List<RoomEntity> roomEntity = roomRepository.findAll();
        List<RoomEntity> roomEntityList = new LinkedList<>();

        for (RoomEntity entity : roomEntity) {
            if (entity.getHotel().getId().equals(hotelId)) {
                roomEntityList.add(entity);
            }
        }
        return roomEntityList;
    }
}
