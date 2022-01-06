package com.hrms.hrms.business.CvService;

import com.hrms.hrms.dataAccess.CvRepository.ForeignLanguageRepository;
import com.hrms.hrms.entity.cv.Cv;
import com.hrms.hrms.entity.cv.Education;
import com.hrms.hrms.entity.cv.ForeignLanguage;
import com.hrms.hrms.entity.dtos.ForeignLanguageDto.ForeignLanguageDtoConv;
import com.hrms.hrms.entity.dtos.ForeignLanguageDto.ForeignLanguageReq;
import com.hrms.hrms.entity.dtos.ForeignLanguageDto.ForeignLanguageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ForeignLanguageService {

    private final ForeignLanguageRepository foreignLanguageRepository;
    private final ForeignLanguageDtoConv foreignLanguageDtoConv;
    private final CvService cvService;

    public ForeignLanguageResponse saveForeignLanguage(ForeignLanguageReq foreignLanguageReq, Long cvId) {
        Cv cv = cvService.findByCvId(cvId);
        ForeignLanguage foreignLanguageWillSaveDb = foreignLanguageDtoConv.convertToForeignLanguage(foreignLanguageReq, cv);

        ForeignLanguage foreignLanguage = foreignLanguageRepository.save(foreignLanguageWillSaveDb);

        return foreignLanguageDtoConv.convertToForeignLanguageResponse(foreignLanguage);

    }

}
