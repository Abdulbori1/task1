package com.company.service;

import com.company.dto.DepartmentDTO;
import com.company.entity.CompanyEntity;
import com.company.entity.DepartmentEntity;
import com.company.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CompanyService companyService;

    public DepartmentDTO create(DepartmentDTO dto) {
        CompanyEntity company = companyService.get(dto.getCompany());

        DepartmentEntity entity = new DepartmentEntity();
        entity.setName(dto.getName());
        entity.setCompany(company);

        departmentRepository.save(entity);

        return toDTO(entity, company);
    }

    public DepartmentDTO update(Integer id, DepartmentDTO dto) {
        CompanyEntity company = companyService.get(dto.getCompany());

        DepartmentEntity entity = departmentRepository.getById(id);
        entity.setCompany(company);
        entity.setName(entity.getName());

        departmentRepository.save(entity);

        return toDTO(entity, company);
    }

    public boolean delete(Integer id) {
        DepartmentEntity entity = departmentRepository.getById(id);

        departmentRepository.delete(entity);
        return true;
    }

    public DepartmentDTO getById(Integer id) {
        DepartmentEntity entity = departmentRepository.getById(id);
        CompanyEntity company = entity.getCompany();

        return toDTO(entity, company);
    }

    public List<DepartmentDTO> getDepartment() {
        List<DepartmentEntity> entityList = departmentRepository.findAll();
        List<DepartmentDTO> companyDTOS = new LinkedList<>();

        for (DepartmentEntity entity : entityList) {
            CompanyEntity company = entity.getCompany();
            companyDTOS.add(toDTO(entity, company));
        }

        return companyDTOS;
    }

    public DepartmentDTO toDTO(DepartmentEntity entity, CompanyEntity company) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(entity.getId());
        dto.setCompany(company.getId());
        dto.setName(entity.getName());

        return dto;
    }

    public DepartmentEntity get(Integer address) {
        return departmentRepository.getById(address);
    }
}
