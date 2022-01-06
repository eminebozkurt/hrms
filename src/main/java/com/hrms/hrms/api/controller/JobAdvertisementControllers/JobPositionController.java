package com.hrms.hrms.api.controller.JobAdvertisementControllers;

import com.hrms.hrms.business.JobAdvertisementService.JobPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@RestController
@RequestMapping("jobpositions")
@Validated
public class JobPositionController {

    private final JobPositionService jobPositionService;
    private final String NOT_BLANK_MESSAGE = "Position name is required!";



    @PostMapping("addjobposition")
    public ResponseEntity<?> addJobPosition(@RequestParam
                                            @NotBlank(message = NOT_BLANK_MESSAGE)
                                            @NotNull(message = NOT_BLANK_MESSAGE) String positionName){
        return new ResponseEntity<>(jobPositionService.saveJobPosition(positionName), HttpStatus.CREATED);
    }

    @GetMapping("findalljobpositions")
    public ResponseEntity<?> findAllJobPositions(){
        return ResponseEntity.ok(jobPositionService.findAllJobPositions());
    }

}
