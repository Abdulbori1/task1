package com.company.service;

import com.company.dto.AddressDTO;
import com.company.dto.CompanyDTO;
import com.company.entity.Address;
import com.company.entity.CompanyEntity;
import com.company.repository.AddressRepository;
import com.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    AddressService addressService;

    public CompanyDTO create(CompanyDTO dto) {
        Address address = addressService.get(dto.getAddress());
        if (address == null) {
            return null;
        }

        CompanyEntity entity = new CompanyEntity();
        entity.setAddress(address);
        entity.setCorpName(dto.getCorpName());
        entity.setDirectorName(dto.getDirectorName());

        companyRepository.save(entity);

        return toDTO(entity, address);
    }

    public CompanyDTO update(Integer id, CompanyDTO dto) {
        Address address = addressService.get(dto.getAddress());
        if (address == null) {
            return null;
        }

        CompanyEntity entity = companyRepository.getById(id);
        entity.setDirectorName(dto.getDirectorName());
        entity.setAddress(address);
        entity.setCorpName(dto.getCorpName());

        companyRepository.save(entity);

        return toDTO(entity, address);
    }

    public boolean delete(Integer id) {
        CompanyEntity entity = companyRepository.getById(id);

        companyRepository.delete(entity);
        return true;
    }

    public CompanyDTO getById(Integer id) {
        CompanyEntity entity = companyRepository.getById(id);
        Address address = entity.getAddress();

        return toDTO(entity, address);
    }

    public CompanyEntity get(Integer id) {
        return companyRepository.findById(id).orElse(null);
    }

    public List<CompanyDTO> getCompany() {
        List<CompanyEntity> entityList = companyRepository.findAll();
        List<CompanyDTO> companyDTOS = new LinkedList<>();

        for (CompanyEntity entity : entityList) {
            Address address = entity.getAddress();
            companyDTOS.add(toDTO(entity, address));
        }

        return companyDTOS;
    }

    public CompanyDTO toDTO(CompanyEntity entity, Address address) {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(entity.getId());
        dto.setAddress(address.getId());
        dto.setCorpName(entity.getCorpName());
        dto.setDirectorName(entity.getDirectorName());

        return dto;
    }
}
