package com.hrms.hrms.entity.dtos.candidateDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CandidateResponse {

    private Long Id;
    private String firstName;
    private String lastname;
    private LocalDateTime createdTime;


}
