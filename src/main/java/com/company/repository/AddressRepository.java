package com.company.repository;

import com.company.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    boolean existsByHomeNumber(Integer homeNumber);
}
