package com.company.controller;

import com.company.dto.DepartmentDTO;
import com.company.dto.WorkerDTO;
import com.company.service.DepartmentService;
import com.company.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody WorkerDTO dto) {
        return ResponseEntity.ok(workerService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody WorkerDTO dto) {
        return ResponseEntity.ok(workerService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(workerService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(workerService.getById(id));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllAddress() {
        return ResponseEntity.ok(workerService.getDepartment());
    }
}
