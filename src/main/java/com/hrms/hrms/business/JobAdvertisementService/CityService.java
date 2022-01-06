package com.hrms.hrms.business.JobAdvertisementService;

import com.hrms.hrms.dataAccess.jobAdvertisementRepository.CityRepository;
import com.hrms.hrms.entity.dtos.cityDto.CityDtoConv;
import com.hrms.hrms.entity.dtos.cityDto.CityResponse;
import com.hrms.hrms.entity.jobAdvertisement.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityDtoConv cityDtoConv;


    public CityResponse saveCity(String cityName) {
        if(cityRepository.findByCityName(cityName.toUpperCase()).isPresent()){
            throw new IllegalStateException("This city is already exist.");
        }

        City city = cityRepository.save(new City(cityName.toUpperCase()));
        return cityDtoConv.convertToCityResponse(city);
    }


    public List<CityResponse> findAllCities() {
        List<City> cList = cityRepository.findAll();
        return cityDtoConv.convertToListCityResponse(cList);
    }

    public City findCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new IllegalStateException("City not found"));
    }
}
