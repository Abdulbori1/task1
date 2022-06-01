package com.company.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CompanyDTO {
    private Integer id;

    @NotNull
    private String corpName;
    @NotNull
    private String directorName;

    private Integer address;
}
