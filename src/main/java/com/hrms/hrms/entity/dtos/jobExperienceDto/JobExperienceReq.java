package com.hrms.hrms.entity.dtos.jobExperienceDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class JobExperienceReq {

    @Min(value = 1,message = "Job position is required!")
    private Long jobPositionId;

    @NotBlank(message = "Company name is required!")
    @NotNull
    private String companyName;

    @NotBlank(message = "Start date is required!")
    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;



}
