package com.hrms.hrms.api.controller.JobAdvertisementControllers;

import com.hrms.hrms.business.JobAdvertisementService.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@RestController
@RequestMapping("cities")
@Validated
public class CityController {

    private final CityService cityService;
    private final String NOT_BLANK_MESSAGE = "City name is required!";


    @PostMapping("addcity")
    public ResponseEntity<?> addCity(@RequestParam
                                     @NotBlank(message = NOT_BLANK_MESSAGE)
                                     @NotNull(message = NOT_BLANK_MESSAGE) String cityName){
        return new ResponseEntity<>(cityService.saveCity(cityName), HttpStatus.CREATED);
    }

    @GetMapping("findallcities")
    public ResponseEntity<?> findAllCities(){
        return ResponseEntity.ok(cityService.findAllCities());
    }


}
