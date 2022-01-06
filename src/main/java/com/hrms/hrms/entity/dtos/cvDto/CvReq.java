package com.hrms.hrms.entity.dtos.cvDto;

import com.hrms.hrms.entity.dtos.ForeignLanguageDto.ForeignLanguageReq;
import com.hrms.hrms.entity.dtos.educationDto.EducationReq;
import com.hrms.hrms.entity.dtos.jobExperienceDto.JobExperienceReq;
import com.hrms.hrms.entity.dtos.skillDto.SkillReq;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import java.util.List;

@Data
@AllArgsConstructor
public class CvReq {

    @Min(value = 1,message = "Candidate Id is required!")
    private Long candidateId;

    private String photo;
    private String coverLetter;
    private String gitHub;
    private String linkedIn;


    private List<EducationReq> educationReqs;
    private List<JobExperienceReq> jobExperienceReqs;
    private List<ForeignLanguageReq> foreignLanguageReqs;
    private List<SkillReq> skillReqs;

}
