package com.hrms.hrms.entity.cv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrms.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "skills")
@NoArgsConstructor
public class Skill extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "cv_id")
    @JsonIgnore
    private Cv cv;

    private String skill;
    private int skillLevel;

    public Skill(Cv cv, String skill, int skillLevel) {
        this.cv = cv;
        this.skill = skill;
        this.skillLevel = skillLevel;
    }


}
