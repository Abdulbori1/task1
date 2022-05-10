package com.company.controller;

import com.company.dto.RoomDTO;
import com.company.entity.RoomEntity;
import com.company.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<RoomDTO> create(@RequestBody RoomDTO dto) {
        return ResponseEntity.ok(roomService.created(dto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<RoomEntity>> list() {
        return ResponseEntity.ok(roomService.hotelEntityList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomEntity> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(roomService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDTO> update(@PathVariable("id") Integer id, @RequestBody RoomDTO dto) {
        return ResponseEntity.ok(roomService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(roomService.delete(id));
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<RoomEntity>> list(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(roomService.get(id));
    }
}
