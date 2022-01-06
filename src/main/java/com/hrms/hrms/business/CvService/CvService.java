package com.hrms.hrms.business.CvService;

import com.hrms.hrms.business.JobAdvertisementService.JobPositionService;
import com.hrms.hrms.business.UserService.CandidateService;
import com.hrms.hrms.dataAccess.CvRepository.CvRepository;
import com.hrms.hrms.entity.cv.*;
import com.hrms.hrms.entity.dtos.ForeignLanguageDto.ForeignLanguageDtoConv;
import com.hrms.hrms.entity.dtos.cvDto.CvDtoConv;
import com.hrms.hrms.entity.dtos.cvDto.CvReq;
import com.hrms.hrms.entity.dtos.cvDto.CvResponse;
import com.hrms.hrms.entity.dtos.educationDto.EducationDtoConv;
import com.hrms.hrms.entity.dtos.jobExperienceDto.JobExperienceDtoConv;
import com.hrms.hrms.entity.dtos.jobExperienceDto.JobExperienceReq;
import com.hrms.hrms.entity.dtos.skillDto.SkillDtoConv;
import com.hrms.hrms.entity.jobAdvertisement.JobPosition;
import com.hrms.hrms.entity.users.Candidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CvService {

    private final CvRepository cvRepository;
    private final CandidateService candidateService;
    private final CvDtoConv cvDtoConv;
    private  final EducationDtoConv educationDtoConv;
    private final JobPositionService jobPositionService;
    private final JobExperienceDtoConv jobExperienceDtoConv;
    private final ForeignLanguageDtoConv foreignLanguageDtoConv;
    private final SkillDtoConv skillDtoConv;


    public CvResponse saveCv(CvReq cvReq) {
        Candidate candidate = candidateService.findCandidateById(cvReq.getCandidateId());

        Cv cvWillSaveDb = cvDtoConv.convertToCv(cvReq, candidate);

        if(cvReq.getEducationReqs() != null){
            List<Education> educations = educationDtoConv.convertToListEducation(cvReq.getEducationReqs(),cvWillSaveDb);
            cvWillSaveDb.setEducations(educations);
        }

        if(cvReq.getJobExperienceReqs() != null){
            List<JobExperience> jobExperiences = new ArrayList<>();
            List<JobExperienceReq> jobExperienceReqs = cvReq.getJobExperienceReqs();

            jobExperienceReqs.forEach(jobExperienceReq -> {
                JobPosition jobPosition = jobPositionService.findJobpositionById(jobExperienceReq.getJobPositionId());
                jobExperiences.add(jobExperienceDtoConv.convertToJobExperience(jobExperienceReq,cvWillSaveDb,jobPosition));
            });

            cvWillSaveDb.setJobExperiences(jobExperiences);
        }
        if(cvReq.getForeignLanguageReqs() != null){
            List<ForeignLanguage> foreignLanguages = foreignLanguageDtoConv.convertToListForeignLanguage(cvReq.getForeignLanguageReqs(),cvWillSaveDb);
            cvWillSaveDb.setForeignLanguages(foreignLanguages);
        }
        if(cvReq.getSkillReqs() != null){
            List<Skill> skills = skillDtoConv.convertToListSkill(cvReq.getSkillReqs(),cvWillSaveDb);
            cvWillSaveDb.setSkills(skills);
        }
        Cv savedCv = cvRepository.save(cvWillSaveDb);
        return  cvDtoConv.convertToResponse(savedCv);
    }


    public Cv findByCvId(Long cvId) {
        return cvRepository.findById(cvId)
                .orElseThrow(() -> new IllegalStateException("Cv not found"));
    }

    public List<CvResponse> findAllCvsByCandidateId(Long candidateId) {
        List<Cv> cvs = cvRepository.findByCandidateId(candidateId);

        return cvDtoConv.convertToListCvResponse(cvs);
    }
}
