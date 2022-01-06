package com.hrms.hrms.entity.dtos.jobAdvertisementDto;

import com.hrms.hrms.entity.jobAdvertisement.City;
import com.hrms.hrms.entity.jobAdvertisement.JobAdvertisement;
import com.hrms.hrms.entity.jobAdvertisement.JobPosition;
import com.hrms.hrms.entity.users.Employer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobAdvertisementDtoConv {

    public JobAdvertisement convertToJobAdvertisement(JobAdvertisementReq jobAdvertisementReq,
                                                      JobPosition jobPosition,
                                                      City city,
                                                      Employer employer){
        return new JobAdvertisement(
                jobPosition,
                jobAdvertisementReq.getJobDescription(),
                city,
                jobAdvertisementReq.getMinSalary(),
                jobAdvertisementReq.getMaxSalary(),
                jobAdvertisementReq.getOpenPositionNumber(),
                jobAdvertisementReq.getDeadLine(),
                true,
                LocalDate.now(),
                employer
        );
    }

    public JobAdvertisementResponse convertToJobAdvertisementResponse(JobAdvertisement jobAdvertisement){
        return new JobAdvertisementResponse(
                jobAdvertisement.getId(),
                jobAdvertisement.getJobPosition().getPositionName(),
                jobAdvertisement.getJobDescription(),
                jobAdvertisement.getCity().getCityName(),
                jobAdvertisement.getMinSalary(),
                jobAdvertisement.getMaxSalary(),
                jobAdvertisement.getOpenPositionNumber(),
                jobAdvertisement.getDeadline(),
                jobAdvertisement.getCreatedDate(),
                jobAdvertisement.getEmployer().getCompanyName(),
                jobAdvertisement.getEmployer().getWebAddress(),
                jobAdvertisement.getEmployer().getEmail(),
                jobAdvertisement.getEmployer().getPhoneNumber()
        );
    }

    public List<JobAdvertisementResponse> convertToListJobAdvertisementResponse(List<JobAdvertisement> jobAdvertisements){
        List<JobAdvertisementResponse> jobAdvertisementResponses = new ArrayList<>();

        jobAdvertisements.forEach(jobAdvertisement -> jobAdvertisementResponses
                .add(convertToJobAdvertisementResponse(jobAdvertisement)));

        return jobAdvertisementResponses;
    }





}
