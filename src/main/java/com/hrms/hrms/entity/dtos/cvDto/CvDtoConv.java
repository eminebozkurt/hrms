package com.hrms.hrms.entity.dtos.cvDto;

import com.hrms.hrms.entity.cv.Cv;
import com.hrms.hrms.entity.dtos.ForeignLanguageDto.ForeignLanguageDtoConv;
import com.hrms.hrms.entity.dtos.educationDto.EducationDtoConv;
import com.hrms.hrms.entity.dtos.jobExperienceDto.JobExperienceDtoConv;
import com.hrms.hrms.entity.dtos.skillDto.SkillDtoConv;
import com.hrms.hrms.entity.users.Candidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CvDtoConv {

    private final EducationDtoConv educationDtoConv;
    private final JobExperienceDtoConv jobExperienceDtoConv;
    private final ForeignLanguageDtoConv foreignLanguageDtoConv;
    private final SkillDtoConv skillDtoConv;

    public Cv convertToCv(CvReq cvReq, Candidate candidate){
        return new Cv(
                candidate,
                cvReq.getPhoto(),
                cvReq.getCoverLetter(),
                cvReq.getGitHub(),
                cvReq.getLinkedIn(),
                LocalDateTime.now()
        );
    }

    public CvResponse convertToResponse(Cv cv){
        CvResponse cvResponse = new CvResponse(
                cv.getId(),
                cv.getCandidate().getFirstName(),
                cv.getCandidate().getLastName(),
                cv.getPhoto(),
                cv.getCoverLetter(),
                cv.getGitHub(),
                cv.getLinkedin(),
                cv.getCreatedDate(),
                cv.getUpdatedDate()
        );
        if(cv.getEducations() != null){
            cvResponse.setEducationResponses(educationDtoConv.convertToListEducationResponse(cv.getEducations()));
        }
        if(cv.getJobExperiences() != null){
            cvResponse.setJobExperienceResponses(jobExperienceDtoConv.convertToListJobExperienceResponse(cv.getJobExperiences()));
        }
        if(cv.getForeignLanguages() != null){
            cvResponse.setForeignLanguageResponses(foreignLanguageDtoConv.convertToListForeignLanguageResponse(cv.getForeignLanguages()));
        }
        if(cv.getSkills() != null){
            cvResponse.setSkillResponses(skillDtoConv.convertToListSkillResponse(cv.getSkills()));
        }

        return cvResponse;
    }

    public List<CvResponse> convertToListCvResponse(List<Cv> cvs){
        List<CvResponse> cvResponses = new ArrayList<>();
        cvs.forEach(cv -> cvResponses.add(convertToResponse(cv)));

        return cvResponses;
    }
}
