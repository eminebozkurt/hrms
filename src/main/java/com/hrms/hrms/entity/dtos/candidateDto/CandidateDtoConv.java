package com.hrms.hrms.entity.dtos.candidateDto;

import com.hrms.hrms.entity.users.Candidate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CandidateDtoConv {

    public Candidate convertToCandidate(CandidateReq candidateReq){
        return new Candidate(
                candidateReq.getEmail(),
                candidateReq.getPassword(),
                LocalDateTime.now(),
                candidateReq.getFirstName(),
                candidateReq.getLastName(),
                candidateReq.getIdentityNumber(),
                candidateReq.getBirthYear());
    }

    public CandidateResponse convertToResponse(Candidate candidate){
        return new CandidateResponse(
                candidate.getId(),
                candidate.getFirstName(),
                candidate.getLastName(),
                candidate.getCreatedTime());
    }

    public List<CandidateResponse> convertToListCandidateResponse(List<Candidate> candidates){
        List<CandidateResponse> candidateResponses = new ArrayList<>();

        for (Candidate c : candidates){
            candidateResponses.add(convertToResponse(c));
        }

        return candidateResponses;
    }


}
