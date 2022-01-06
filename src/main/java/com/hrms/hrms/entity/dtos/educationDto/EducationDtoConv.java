package com.hrms.hrms.entity.dtos.educationDto;

import com.hrms.hrms.entity.cv.Cv;
import com.hrms.hrms.entity.cv.Education;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class EducationDtoConv {

    public Education convertToEducation(EducationReq educationReq, Cv cv){
        return new Education(
                cv,
                educationReq.getSchoolName(),
                educationReq.getDepartment(),
                educationReq.getStartDate(),
                educationReq.getEndDate(),
                LocalDateTime.now()
        );
    }


    public List<Education> convertToListEducation(List<EducationReq> educationReqs, Cv cv){
        List<Education> educations = new ArrayList<>();
        educationReqs.forEach(educationReq -> educations.add(convertToEducation(educationReq,cv)));

        return educations;
    }


    public EducationResponse convertToEducationResponse(Education education){
        return new EducationResponse(
                education.getId(),
                education.getSchoolName(),
                education.getDepartment(),
                education.getStartDate(),
                education.getEndDate()
        );
    }

    public List<EducationResponse> convertToListEducationResponse(List<Education> educations){
        List<EducationResponse> educationResponses = new ArrayList<>();
        educations.forEach(education -> educationResponses.add(convertToEducationResponse(education)));

        return educationResponses;
    }


}
