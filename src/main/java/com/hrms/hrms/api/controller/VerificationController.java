package com.hrms.hrms.api.controller;

import com.hrms.hrms.business.UserService.CandidateService;
import com.hrms.hrms.business.UserService.EmployerService;
import com.hrms.hrms.business.VerificationService.VerificationService;
import com.hrms.hrms.dataAccess.VerificationRepository.VerificationCandidateRepository;
import com.hrms.hrms.entity.verification.VerificationCandidate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

@RestController
@RequiredArgsConstructor
@RequestMapping("verification")
@Validated
public class VerificationController {

    private final CandidateService candidateService;
    private final EmployerService employerService;
    private final VerificationService verificationService;
    private final String EMAIL_MESSAGE = "Verification email has been sent.";
    private final String EMAIL_NOT_VALID = "Email should be correct format!";

    @GetMapping("verify")// "localhost:8080/verify?code="+code
    public ResponseEntity<?> verifyUser(@RequestParam String code){
        verificationService.verifyCode(code);
        return ResponseEntity.ok("Verification islemleri tamamlandı...");
    }

    @GetMapping("resendverificationcandidate")
    public ResponseEntity<?> reProduceVerificationCandidate(@RequestParam @Email(message = EMAIL_NOT_VALID) String email){
        candidateService.reProduceVerificationCandidate(email);
        return ResponseEntity.ok(EMAIL_MESSAGE);
    }

    @GetMapping("resendverificationemployer")
    public ResponseEntity<?> reProduceVerificationEmployer(@RequestParam @Email(message = EMAIL_NOT_VALID) String email){
        employerService.reProduceVerificationEmployer(email);
        return ResponseEntity.ok(EMAIL_MESSAGE);
    }



}
