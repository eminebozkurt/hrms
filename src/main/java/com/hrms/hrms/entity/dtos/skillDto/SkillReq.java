package com.hrms.hrms.entity.dtos.skillDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class SkillReq {

    @NotBlank(message = "Skill name is required!")
    @NotNull
    private String skill;

    @Min(value = 1,message = "Skill level is required!")
    private int skillLevel;

}
