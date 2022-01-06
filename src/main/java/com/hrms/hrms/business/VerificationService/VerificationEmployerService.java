package com.hrms.hrms.business.VerificationService;

import com.hrms.hrms.core.exceptions.VerificationNotFoundException;
import com.hrms.hrms.dataAccess.VerificationRepository.VerificationEmployerRepository;
import com.hrms.hrms.entity.verification.VerificationEmployer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VerificationEmployerService {

    private final VerificationEmployerRepository verificationEmployerRepository;


    public void saveVerificationEmployer(VerificationEmployer verificationEmployer) {
        verificationEmployerRepository.save(verificationEmployer);
    }

    public List<VerificationEmployer> findAllByEmployerService(Long id) {
        return verificationEmployerRepository.findAllByEmployerId(id)
                .orElseThrow(() -> new VerificationNotFoundException("Any verification not found for this employer id"));
    }
}
