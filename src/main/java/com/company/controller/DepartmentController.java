package com.company.controller;

import com.company.dto.DepartmentDTO;
import com.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DepartmentDTO dto) {
        return ResponseEntity.ok(departmentService.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody DepartmentDTO dto) {
        return ResponseEntity.ok(departmentService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(departmentService.delete(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @GetMapping("/getList")
    public ResponseEntity<?> getAllAddress() {
        return ResponseEntity.ok(departmentService.getDepartment());
    }
}
