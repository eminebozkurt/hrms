package com.hrms.hrms.entity.dtos.JobPositionDto;

import com.hrms.hrms.entity.jobAdvertisement.JobPosition;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobPositionDtoConv {

    public JobPositionResponse convertToJobPositionResponse(JobPosition jobPosition){
        return new JobPositionResponse(
                jobPosition.getId(),
                jobPosition.getPositionName()
        );
    }

    public List<JobPositionResponse> convertToListJobPositionResponse(List<JobPosition> jobPositions){
        List<JobPositionResponse> jobPositionResponses = new ArrayList<>();

        for (JobPosition j : jobPositions){
            jobPositionResponses.add(convertToJobPositionResponse(j));
        }

        return jobPositionResponses;
    }





}
