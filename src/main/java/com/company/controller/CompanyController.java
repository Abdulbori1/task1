package com.company.controller;

import com.company.dto.AddressDTO;
import com.company.dto.CompanyDTO;
import com.company.service.AddressService;
import com.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody CompanyDTO dto) {
        return ResponseEntity.ok(companyService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CompanyDTO dto) {
        return ResponseEntity.ok(companyService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(companyService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(companyService.getById(id));
    }

    @GetMapping("")
    public ResponseEntity<?> getAllAddress() {
        return ResponseEntity.ok(companyService.getCompany());
    }
}
