package com.hrms.hrms.entity.dtos.cityDto;

import com.hrms.hrms.entity.jobAdvertisement.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityDtoConv {

    public CityResponse convertToCityResponse(City city){
        return new CityResponse(
                city.getId(),
                city.getCityName()
        );
    }

    public List<CityResponse> convertToListCityResponse(List<City> cities){
        List<CityResponse> cityResponses = new ArrayList<>();
        cities.forEach(city -> cityResponses.add(convertToCityResponse(city)));

        return cityResponses;
    }

}
