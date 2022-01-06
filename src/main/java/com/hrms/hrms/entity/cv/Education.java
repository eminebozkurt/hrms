package com.hrms.hrms.entity.cv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrms.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "educations")
@NoArgsConstructor
public class Education extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "cv_id")
    @JsonIgnore
    private Cv cv;

    private String schoolName;
    private String department;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdDate;

    public Education(Cv cv, String schoolName, String department, LocalDate startDate, LocalDate endDate, LocalDateTime createdDate) {
        this.cv = cv;
        this.schoolName = schoolName;
        this.department = department;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdDate = createdDate;
    }
}
