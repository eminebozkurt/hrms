package com.hrms.hrms.api.controller.UserController;

import com.hrms.hrms.business.UserService.EmployerService;
import com.hrms.hrms.business.UserService.UserService;
import com.hrms.hrms.core.emailSender.EmailSender;
import com.hrms.hrms.core.emailSender.EmailService;
import com.hrms.hrms.entity.dtos.employerDto.EmployerReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("employers")
public class EmployerController {

    private final EmployerService employerService;
    private final UserService userService;

    @PostMapping("saveemployer")
    public ResponseEntity<?> saveEmployer(@Valid @RequestBody EmployerReq employerReq){
        return new ResponseEntity<>(employerService.saveEmployer(employerReq), HttpStatus.CREATED);
    }

    @GetMapping("findallemployers")
    public ResponseEntity<?> findAllEmployers(){
        return ResponseEntity.ok(employerService.findAllEmployers());
    }


}
