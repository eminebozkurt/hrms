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
@Table(name="cities")
public class City extends BaseEntity {

    @Column(nullable = false)
    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }
}
