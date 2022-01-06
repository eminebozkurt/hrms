package com.hrms.hrms.business.VerificationService;

import com.hrms.hrms.core.exceptions.VerificationNotFoundException;
import com.hrms.hrms.dataAccess.VerificationRepository.VerificationCandidateRepository;
import com.hrms.hrms.entity.verification.VerificationCandidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VerificationCandidateService {

    private final VerificationCandidateRepository verificationCandidateRepository;


    public void saveVerificationCandidate(VerificationCandidate verificationCandidate) {
        verificationCandidateRepository.save(verificationCandidate);
    }

    public List<VerificationCandidate> findAllByCandidateId(Long id) {
        return verificationCandidateRepository.findAllByCandidateId(id)
                .orElseThrow(() -> new VerificationNotFoundException("Any verification not found for this candidate id"));
    }
}
