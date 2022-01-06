package com.hrms.hrms.business.VerificationService;

import com.hrms.hrms.core.exceptions.AlreadyVerifiedException;
import com.hrms.hrms.core.exceptions.VerificationExpiredException;
import com.hrms.hrms.core.exceptions.VerificationNotFoundException;
import com.hrms.hrms.dataAccess.VerificationRepository.VerificationRepository;
import com.hrms.hrms.entity.verification.Verification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VerificationService {
    private final VerificationRepository verificationRepository;

    protected Verification findVerificationByCode(String code){
        return verificationRepository.findByCode(code)
                .orElseThrow(() -> new VerificationNotFoundException("Verification not found"));
    }


    public void verifyCode(String code) {
        Verification verification = findVerificationByCode(code);
        if(verification.isVerified() || verification.getVerifiedDate()!=null){
            throw new AlreadyVerifiedException("This verification code has already been verified.");
        }
        if(verification.getExpirationDate().isBefore(LocalDateTime.now())){
            throw  new VerificationExpiredException("This verification code has expired.");
        }

        verificationRepository.updateVerification(code, LocalDateTime.now());


    }
}
