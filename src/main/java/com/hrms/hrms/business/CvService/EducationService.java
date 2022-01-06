package com.hrms.hrms.business.CvService;

import com.hrms.hrms.dataAccess.CvRepository.EducationRepository;
import com.hrms.hrms.entity.cv.Cv;
import com.hrms.hrms.entity.cv.Education;
import com.hrms.hrms.entity.dtos.educationDto.EducationDtoConv;
import com.hrms.hrms.entity.dtos.educationDto.EducationReq;
import com.hrms.hrms.entity.dtos.educationDto.EducationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;
    private final CvService cvService;
    private final EducationDtoConv educationDtoConv;

    public EducationResponse saveEducation(EducationReq educationReq, Long cvId) {
        Cv cv = cvService.findByCvId(cvId);
        Education educationWillSaveDb = educationDtoConv.convertToEducation(educationReq, cv);

        Education education = educationRepository.save(educationWillSaveDb);

        return educationDtoConv.convertToEducationResponse(education);

    }
}
