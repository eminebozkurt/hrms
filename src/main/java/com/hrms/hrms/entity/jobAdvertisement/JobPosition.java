package com.hrms.hrms.entity.jobAdvertisement;

import com.hrms.hrms.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="job_positions")
public class JobPosition extends BaseEntity {

    @Column(nullable = false)
    private String positionName;


    public JobPosition(String positionName) {
        this.positionName = positionName;
    }
}
