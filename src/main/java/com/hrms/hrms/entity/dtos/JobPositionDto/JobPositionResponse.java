package com.hrms.hrms.entity.dtos.JobPositionDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobPositionResponse {

    private Long id;
    private String positionName;
}
