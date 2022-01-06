package com.hrms.hrms.api.controller.UserController;

import com.hrms.hrms.business.UserService.CandidateService;
import com.hrms.hrms.business.UserService.UserService;
import com.hrms.hrms.core.emailSender.EmailSender;
import com.hrms.hrms.core.emailSender.EmailService;
import com.hrms.hrms.entity.dtos.candidateDto.CandidateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("candidates")
public class CandidateController {

    private final CandidateService candidateService;
    private final UserService userService;


    @PostMapping("savecandidate")
    public ResponseEntity<?> saveCandidate(@Valid @RequestBody CandidateReq candidateReq){
        return new ResponseEntity<>(candidateService.saveCandidate(candidateReq), HttpStatus.CREATED);
    }

    @GetMapping("findcandidates")
    public ResponseEntity<?> findAllCandidates(){
        return ResponseEntity.ok(candidateService.findAllCandidates());
    }


}
