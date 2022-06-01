package com.company.service;

import com.company.dto.AddressDTO;
import com.company.entity.Address;
import com.company.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public AddressDTO create(AddressDTO dto) {
        boolean existsByHomeNumber = addressRepository.existsByHomeNumber(dto.getHomeNumber());
        if (existsByHomeNumber) {
            return null;
        }

        Address address = new Address();
        address.setHomeNumber(dto.getHomeNumber());
        address.setStreet(dto.getStreet());

        addressRepository.save(address);

        return toDTO(address);
    }

    public AddressDTO update(Integer id, AddressDTO dto) {
        boolean existsByHomeNumber = addressRepository.existsByHomeNumber(dto.getHomeNumber());
        if (existsByHomeNumber) {
            return null;
        }

        Address address = addressRepository.getById(id);
        address.setHomeNumber(dto.getHomeNumber());
        address.setStreet(dto.getStreet());

        addressRepository.save(address);

        return toDTO(address);
    }

    public boolean delete(Integer id) {
        Address address = addressRepository.getById(id);

        addressRepository.delete(address);
        return true;
    }

    public AddressDTO getById(Integer id) {
        Address address = addressRepository.getById(id);
        return toDTO(address);
    }

    public Address get(Integer id) {
        return addressRepository.getById(id);
    }

    public List<AddressDTO> getAddress() {
        List<Address> address = addressRepository.findAll();
        List<AddressDTO> addressDTOS = new LinkedList<>();

        for (Address entity : address) {
            addressDTOS.add(toDTO(entity));
        }

        return addressDTOS;
    }

    public AddressDTO toDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setHomeNumber(address.getHomeNumber());

        return dto;
    }
}
