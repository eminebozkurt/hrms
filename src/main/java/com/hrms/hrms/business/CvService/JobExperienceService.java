package com.hrms.hrms.business.CvService;

import com.hrms.hrms.business.JobAdvertisementService.JobPositionService;
import com.hrms.hrms.dataAccess.CvRepository.JobExperienceRepository;
import com.hrms.hrms.entity.cv.Cv;
import com.hrms.hrms.entity.cv.Education;
import com.hrms.hrms.entity.cv.JobExperience;
import com.hrms.hrms.entity.dtos.jobExperienceDto.JobExperienceDtoConv;
import com.hrms.hrms.entity.dtos.jobExperienceDto.JobExperienceReq;
import com.hrms.hrms.entity.dtos.jobExperienceDto.JobExperienceResponse;
import com.hrms.hrms.entity.jobAdvertisement.JobPosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobExperienceService {

    private final JobExperienceRepository jobExperienceRepository;
    private final JobExperienceDtoConv jobExperienceDtoConv;
    private final CvService cvService;
    private final JobPositionService jobPositionService;


    public JobExperienceResponse saveJobExperience(JobExperienceReq jobExperienceReq, Long cvId){
        Cv cv = cvService.findByCvId(cvId);
        JobPosition jobPosition = jobPositionService.findJobpositionById(jobExperienceReq.getJobPositionId());
        JobExperience jobExperienceWillSaveDb = jobExperienceDtoConv.convertToJobExperience(jobExperienceReq, cv, jobPosition);

        JobExperience jobExperience = jobExperienceRepository.save(jobExperienceWillSaveDb);

        return jobExperienceDtoConv.convertToJobExperienceResponse(jobExperience);
    }






}
