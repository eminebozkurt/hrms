package com.hrms.hrms.entity.dtos.jobExperienceDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class JobExperienceResponse {

    private Long id;
    private String positionName;
    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;

}
