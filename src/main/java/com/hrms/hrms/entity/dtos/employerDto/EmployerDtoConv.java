package com.hrms.hrms.entity.dtos.employerDto;

import com.hrms.hrms.entity.dtos.candidateDto.CandidateReq;
import com.hrms.hrms.entity.dtos.candidateDto.CandidateResponse;
import com.hrms.hrms.entity.users.Candidate;
import com.hrms.hrms.entity.users.Employer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployerDtoConv {

    public Employer convertToEmployer(EmployerReq employerReq) {
        return new Employer(
                employerReq.getEmail(),
                employerReq.getPassword(),
                LocalDateTime.now(),
                employerReq.getCompanyName(),
                employerReq.getWebAddress(),
                employerReq.getPhoneNumber()
        );
    }

    public EmployerResponse convertToResponse(Employer employer) {
        return new EmployerResponse(
                employer.getId(),
                employer.getCompanyName(),
                employer.getWebAddress(),
                employer.getPhoneNumber(),
                employer.getCreatedTime()
        );
    }

    public List<EmployerResponse> convertToListEmployerResponse(List<Employer> employers){
        List<EmployerResponse> employerResponses = new ArrayList<>();

        for (Employer e : employers){
            employerResponses.add(convertToResponse(e));
        }

        return employerResponses;
    }



}
