package com.company.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkerDTO {
    private Integer id;
    private String name;
    private String phoneNumber;
    private Integer address;
    private Integer department;
}
