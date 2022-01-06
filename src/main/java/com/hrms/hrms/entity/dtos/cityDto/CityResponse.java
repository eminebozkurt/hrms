package com.hrms.hrms.entity.dtos.cityDto;

import com.hrms.hrms.entity.jobAdvertisement.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CityResponse {


    private Long id;

    private String cityName;


}
