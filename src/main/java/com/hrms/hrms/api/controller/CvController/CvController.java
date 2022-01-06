package com.hrms.hrms.api.controller.CvController;

import com.hrms.hrms.business.CvService.CvService;
import com.hrms.hrms.business.CvService.EducationService;
import com.hrms.hrms.business.CvService.ForeignLanguageService;
import com.hrms.hrms.business.CvService.JobExperienceService;
import com.hrms.hrms.entity.dtos.ForeignLanguageDto.ForeignLanguageReq;
import com.hrms.hrms.entity.dtos.cvDto.CvReq;
import com.hrms.hrms.entity.dtos.educationDto.EducationReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequiredArgsConstructor
@RequestMapping("cvs")
@Validated
public class CvController {

    private final CvService cvService;
    private final EducationService educationService;
    private final ForeignLanguageService foreignLanguageService;
    private final JobExperienceService jobExperienceService;
    private final String NOT_VALID_ID = "ID should be greater than 0!";

    @PostMapping("savecv")
    public ResponseEntity<?> saveCv(@Valid @RequestBody CvReq cvReq){
        return new ResponseEntity<>(cvService.saveCv(cvReq), HttpStatus.CREATED);
    }

    @PostMapping("addeducation")
    public ResponseEntity<?> addEducation(@Valid @RequestBody EducationReq educationReq,
                                          @RequestParam @Min(value = 1,message = NOT_VALID_ID) Long cvId){
        return new ResponseEntity<>(educationService.saveEducation(educationReq, cvId), HttpStatus.CREATED);
    }

    @PostMapping("addforeignlanguage")
    public ResponseEntity<?> addForeignLanguage(@Valid @RequestBody ForeignLanguageReq foreignLanguageReq,
                                                @RequestParam @Min(value = 1,message = NOT_VALID_ID) Long cvId){
        return new ResponseEntity<>(foreignLanguageService.saveForeignLanguage(foreignLanguageReq, cvId), HttpStatus.CREATED);
    }

    @GetMapping("cvsbycandidateid")
    public ResponseEntity<?> findAllCvsByCandidateId(@RequestParam @Min(value = 1,message = NOT_VALID_ID)  Long candidateId){
        return ResponseEntity.ok(cvService.findAllCvsByCandidateId(candidateId));
    }



}
