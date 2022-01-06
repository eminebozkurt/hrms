package com.hrms.hrms.entity.cv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrms.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "foreignlanguages")
@NoArgsConstructor
public class ForeignLanguage extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "cv_id")
    @JsonIgnore
    private Cv cv;

    private String language;
    private int level;
    private LocalDateTime createdDate;

    public ForeignLanguage(Cv cv, String language, int level, LocalDateTime createdDate) {
        this.cv = cv;
        this.language = language;
        this.level = level;
        this.createdDate = createdDate;
    }
}
