package com.company.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class AddressDTO {
    private Integer id;

    @NotNull
    private String street;

    @NotNull
    private Integer homeNumber;
}
