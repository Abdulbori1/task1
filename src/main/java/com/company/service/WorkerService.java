package com.company.service;

import com.company.dto.DepartmentDTO;
import com.company.dto.WorkerDTO;
import com.company.entity.Address;
import com.company.entity.CompanyEntity;
import com.company.entity.DepartmentEntity;
import com.company.entity.WorkerEntity;
import com.company.repository.DepartmentRepository;
import com.company.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    AddressService addressService;
    @Autowired
    DepartmentService departmentService;

    public WorkerDTO create(WorkerDTO dto) {
        Address address = addressService.get(dto.getAddress());
        DepartmentEntity department = departmentService.get(dto.getAddress());

        WorkerEntity entity = new WorkerEntity();
        entity.setName(dto.getName());
        entity.setAddress(address);
        entity.setDepartment(department);
        entity.setPhoneNumber(dto.getPhoneNumber());

        workerRepository.save(entity);

        return toDTO(entity);
    }

    public WorkerDTO update(Integer id, WorkerDTO dto) {
        Address address = addressService.get(dto.getAddress());
        DepartmentEntity department = departmentService.get(dto.getAddress());

        WorkerEntity entity = workerRepository.getById(id);
        entity.setName(entity.getName());
        entity.setPhoneNumber(entity.getPhoneNumber());
        entity.setDepartment(department);
        entity.setAddress(address);

        workerRepository.save(entity);

        return toDTO(entity);
    }

    public boolean delete(Integer id) {
        WorkerEntity entity = workerRepository.getById(id);

        workerRepository.delete(entity);
        return true;
    }

    public WorkerDTO getById(Integer id) {
        WorkerEntity entity = workerRepository.getById(id);

        return toDTO(entity);
    }

    public List<WorkerDTO> getDepartment() {
        List<WorkerEntity> entityList = workerRepository.findAll();
        List<WorkerDTO> companyDTOS = new LinkedList<>();

        for (WorkerEntity entity : entityList) {
            companyDTOS.add(toDTO(entity));
        }

        return companyDTOS;
    }

    public WorkerDTO toDTO(WorkerEntity entity) {
        WorkerDTO dto = new WorkerDTO();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddress().getId());
        dto.setName(entity.getName());
        dto.setPhoneNumber(dto.getPhoneNumber());
        dto.setDepartment(entity.getDepartment().getId());

        return dto;
    }
}
