package com.company.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer number;
    @Column
    private Integer floor;
    @Column
    private Integer size;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;
}
