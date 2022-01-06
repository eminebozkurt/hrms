package com.hrms.hrms.entity.dtos.jobAdvertisementDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class JobAdvertisementResponse {

    private Long id;
    private String jobPositionName;
    private String jobDescription;
    private String cityName;
    private int minSalary;
    private int maxSalary;
    private int openPositionNumber;
    private LocalDate deadLine;
    private LocalDate createdDate;

    private String companyName;
    private String webAddress;
    private String companyEmail;
    private String phoneNumber;

}
