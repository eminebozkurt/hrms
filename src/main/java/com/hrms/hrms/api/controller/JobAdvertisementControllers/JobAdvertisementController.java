package com.hrms.hrms.api.controller.JobAdvertisementControllers;

import com.hrms.hrms.business.JobAdvertisementService.JobAdvertisementService;
import com.hrms.hrms.entity.dtos.jobAdvertisementDto.JobAdvertisementReq;
import com.hrms.hrms.entity.jobAdvertisement.JobAdvertisement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RequiredArgsConstructor
@RestController
@RequestMapping("jobadvertisements")
@Validated
public class JobAdvertisementController {

    private final JobAdvertisementService jobAdvertisementService;
    private final String NOT_VALID_ID = "Id should be greater than 0";

    @PostMapping("savejobadvertisement")
    public ResponseEntity<?> saveJobAdvertisement(@Valid @RequestBody JobAdvertisementReq jobAdvertisementReq){
        return new ResponseEntity<>(jobAdvertisementService.saveJobAdvertisement(jobAdvertisementReq), HttpStatus.CREATED);
    }

    @GetMapping("closejobadvertisement")
    public ResponseEntity<?> closeJobAdvertisement(@RequestParam @Min(value = 1, message = NOT_VALID_ID) Long jobAdvertisementId,
                                                   @RequestParam @Min(value = 1, message = NOT_VALID_ID) Long employerId){
        jobAdvertisementService.closeJobAdvertisement(jobAdvertisementId, employerId);
        return ResponseEntity.ok("The advertisement was closed.");
    }

    @GetMapping("findallactivejobadvertisements")
    public ResponseEntity<?> findAllActiveJobAdvertisements(){
        return  ResponseEntity.ok(jobAdvertisementService.findAllActiveJobAdvertisements());
    }

    @GetMapping("findallactivejobadvertisementsorderbydate")
    public ResponseEntity<?> findAllActiveJobAdvertisementsOrderByDate(){
        return  ResponseEntity.ok(jobAdvertisementService.findAllActiveJobAdvertisementsOrderByDate());
    }

    @GetMapping("findallactivejobadvertisementsorderbycompanyname")
    public ResponseEntity<?> findAllActiveJobAdvertisementsByCompany(@RequestParam String companyName){
        return ResponseEntity.ok(jobAdvertisementService.findAllActiveJobAdvertisementsByCompany(companyName));
    }


}
