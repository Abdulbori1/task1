package com.company.controller;

import com.company.dto.HotelDTO;
import com.company.entity.HotelEntity;
import com.company.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<HotelDTO> create(@RequestBody HotelDTO dto) {
        return ResponseEntity.ok(hotelService.created(dto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<HotelEntity>> list() {
        return ResponseEntity.ok(hotelService.hotelEntityList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelEntity> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(hotelService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDTO> update(@PathVariable("id") Integer id, @RequestBody HotelDTO dto) {
        return ResponseEntity.ok(hotelService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(hotelService.delete(id));
    }
}
