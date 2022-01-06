package com.hrms.hrms.entity.dtos.educationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EducationResponse {

    private Long id;
    private String schoolName;
    private String department;
    private LocalDate startDate;
    private LocalDate endDate;

}
