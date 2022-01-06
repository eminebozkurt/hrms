package com.hrms.hrms.entity.dtos.jobExperienceDto;

import com.hrms.hrms.entity.cv.Cv;
import com.hrms.hrms.entity.cv.JobExperience;
import com.hrms.hrms.entity.jobAdvertisement.JobPosition;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobExperienceDtoConv {

    public JobExperience convertToJobExperience(JobExperienceReq jobExperienceReq, Cv cv, JobPosition jobPosition){
        return new JobExperience(
                cv,
                jobExperienceReq.getCompanyName(),
                jobPosition,
                jobExperienceReq.getStartDate(),
                jobExperienceReq.getEndDate(),
                LocalDateTime.now()
        );
    }

    public JobExperienceResponse convertToJobExperienceResponse(JobExperience jobExperience){
        return new JobExperienceResponse(
                jobExperience.getId(),
                jobExperience.getJobPosition().getPositionName(),
                jobExperience.getCompanyName(),
                jobExperience.getStartDate(),
                jobExperience.getEndDate()
        );
    }

    public List<JobExperienceResponse> convertToListJobExperienceResponse(List<JobExperience> jobExperiences){
        List<JobExperienceResponse> jobExperienceResponses = new ArrayList<>();
        jobExperiences.forEach(jobExperience -> jobExperienceResponses.add(convertToJobExperienceResponse(jobExperience)));

        return jobExperienceResponses;
    }

}
