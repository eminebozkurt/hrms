package com.hrms.hrms.entity.dtos.ForeignLanguageDto;

import com.hrms.hrms.entity.cv.Cv;
import com.hrms.hrms.entity.cv.ForeignLanguage;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ForeignLanguageDtoConv {

    public ForeignLanguage convertToForeignLanguage(ForeignLanguageReq foreignLanguageReq, Cv cv){
        return new ForeignLanguage(
                cv,
                foreignLanguageReq.getLanguage(),
                foreignLanguageReq.getLevel(),
                LocalDateTime.now()
        );
    }

    public List<ForeignLanguage> convertToListForeignLanguage(List<ForeignLanguageReq> foreignLanguageReqs, Cv cv){
        List<ForeignLanguage> foreignLanguages = new ArrayList<>();
        foreignLanguageReqs.forEach(foreignLanguageReq -> foreignLanguages.add(convertToForeignLanguage(foreignLanguageReq,cv)));

        return foreignLanguages;
    }

    public ForeignLanguageResponse convertToForeignLanguageResponse(ForeignLanguage foreignLanguage){
        return new ForeignLanguageResponse(
                foreignLanguage.getId(),
                foreignLanguage.getLanguage(),
                foreignLanguage.getLevel()
        );
    }


    public List<ForeignLanguageResponse> convertToListForeignLanguageResponse(List<ForeignLanguage> foreignLanguages){
        List<ForeignLanguageResponse> foreignLanguageResponses = new ArrayList<>();
        foreignLanguages.forEach(foreignLanguage -> foreignLanguageResponses.add(convertToForeignLanguageResponse(foreignLanguage)));

        return foreignLanguageResponses;
    }




}
