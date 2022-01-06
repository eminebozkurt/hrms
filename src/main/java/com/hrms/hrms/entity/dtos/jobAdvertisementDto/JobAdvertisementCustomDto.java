package com.hrms.hrms.entity.dtos.jobAdvertisementDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class JobAdvertisementCustomDto {

    private String companyName;
    private String positionName;
    private int openPositionNumber;
    private LocalDate createdDate;
    private LocalDate deadline;

}
