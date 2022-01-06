package com.hrms.hrms.entity.dtos.educationDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EducationReq {

    @NotBlank(message = "School name is required!")
    @NotNull
    private String schoolName;

    @NotBlank(message = "Department is required!")
    @NotNull
    private String department;

    //@NotBlank(message = "Start date is required!")
    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

}
