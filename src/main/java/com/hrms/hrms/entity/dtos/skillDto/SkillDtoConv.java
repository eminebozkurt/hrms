package com.hrms.hrms.entity.dtos.skillDto;

import com.hrms.hrms.entity.cv.Cv;
import com.hrms.hrms.entity.cv.Skill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SkillDtoConv {

    public Skill convertToSkill(SkillReq skillReq, Cv cv){
        return new Skill(
                cv,
                skillReq.getSkill(),
                skillReq.getSkillLevel()
        );
    }

    public List<Skill> convertToListSkill(List<SkillReq> skillReqs, Cv cv){
        List<Skill> skills = new ArrayList<>();
        skillReqs.forEach(skillReq -> skills.add(convertToSkill(skillReq,cv)));

        return skills;
    }

    public SkillResponse convertToSkillResponse(Skill skill){
        return new SkillResponse(
                skill.getId(),
                skill.getSkill(),
                skill.getSkillLevel()
        );
    }

    public List<SkillResponse> convertToListSkillResponse(List<Skill> skills){
        List<SkillResponse> skillResponses = new ArrayList<>();
        skills.forEach(skill -> skillResponses.add(convertToSkillResponse(skill)));

        return skillResponses;
    }

}
