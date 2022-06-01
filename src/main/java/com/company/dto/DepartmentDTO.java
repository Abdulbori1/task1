package com.company.dto;

import com.company.entity.CompanyEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentDTO {
    private Integer id;
    private String name;
    private Integer company;
}
