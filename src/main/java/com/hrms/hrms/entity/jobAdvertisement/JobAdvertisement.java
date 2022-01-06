package com.hrms.hrms.entity.jobAdvertisement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrms.entity.BaseEntity;
import com.hrms.hrms.entity.users.Employee;
import com.hrms.hrms.entity.users.Employer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name="job_advertisements")
public class JobAdvertisement extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="job_position")
    private JobPosition jobPosition;

    @Column(nullable = false)
    private String jobDescription;

    @ManyToOne
    @JoinColumn(name="city_name")
    private City city;

    private int minSalary;

    private int maxSalary;

    @Column(nullable = false)
    private int openPositionNumber;

    private LocalDate deadline;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name="employer_id")
    private Employer employer;

    public JobAdvertisement(JobPosition jobPosition, String jobDescription, City city, int minSalary, int maxSalary, int openPositionNumber, LocalDate deadline, boolean isActive, LocalDate createdDate, Employer employer) {
        this.jobPosition = jobPosition;
        this.jobDescription = jobDescription;
        this.city = city;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.openPositionNumber = openPositionNumber;
        this.deadline = deadline;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.employer = employer;
    }
}
