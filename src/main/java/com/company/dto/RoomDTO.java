package com.company.dto;

import com.company.entity.HotelEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO {
    private Integer id;
    private Integer number;
    private Integer floor;
    private Integer size;
    private Integer hotel;
}
