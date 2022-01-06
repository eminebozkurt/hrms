package com.hrms.hrms.entity.dtos.skillDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SkillResponse {

    private Long id;
    private String skill;
    private int skillLevel;

}
