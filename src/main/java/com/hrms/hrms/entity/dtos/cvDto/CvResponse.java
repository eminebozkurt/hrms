package com.hrms.hrms.entity.dtos.cvDto;

import com.hrms.hrms.entity.dtos.ForeignLanguageDto.ForeignLanguageResponse;
import com.hrms.hrms.entity.dtos.educationDto.EducationResponse;
import com.hrms.hrms.entity.dtos.jobExperienceDto.JobExperienceResponse;
import com.hrms.hrms.entity.dtos.skillDto.SkillResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class CvResponse {

    private Long id;
    private String candidateFirstName;
    private String candidateLastName;
    private String photo;
    private String coverLetter;
    private String gitHub;
    private String linkedIn;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private List<EducationResponse> educationResponses;
    private List<JobExperienceResponse> jobExperienceResponses;
    private List<ForeignLanguageResponse> foreignLanguageResponses;
    private List<SkillResponse> skillResponses;


    public CvResponse(Long id,
                      String candidateFirstName,
                      String candidateLastName,
                      String photo,
                      String coverLetter,
                      String gitHub,
                      String linkedIn,
                      LocalDateTime createdDate,
                      LocalDateTime updatedDate) {
        this.id = id;
        this.candidateFirstName = candidateFirstName;
        this.candidateLastName = candidateLastName;
        this.photo = photo;
        this.coverLetter = coverLetter;
        this.gitHub = gitHub;
        this.linkedIn = linkedIn;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
