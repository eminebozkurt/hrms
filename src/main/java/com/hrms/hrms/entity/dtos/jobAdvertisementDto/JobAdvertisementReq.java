package com.hrms.hrms.entity.dtos.jobAdvertisementDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class JobAdvertisementReq {

    @Min(value = 1,message = "Position is required!")
    @NotNull(message = "Position is required!")
    private Long jobPositionId;

    @NotBlank(message = "Job description is required!")
    @NotNull
    private String jobDescription;

    @Min(value = 1,message = "City is required!")
    @NotNull(message = "City is required!")
    private Long cityId;

    private int minSalary;
    private int maxSalary;

    @Min(value = 1,message = "Open position number is required!")
    @NotNull(message = "Open position number is required!")
    private int openPositionNumber;

    private LocalDate deadLine;

    @Min(value = 1,message = "Employer is required!")
    @NotNull(message = "Employer is required!")
    private Long employerId;



}
