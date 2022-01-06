package com.hrms.hrms.business.UserService;

import com.hrms.hrms.business.VerificationService.VerificationCandidateService;
import com.hrms.hrms.core.emailSender.EmailBuilder;
import com.hrms.hrms.core.emailSender.EmailSender;
import com.hrms.hrms.core.exceptions.AlreadyVerifiedException;
import com.hrms.hrms.core.exceptions.EmailNotFoundException;
import com.hrms.hrms.core.exceptions.IdentityNumberAlreadyInUseException;
import com.hrms.hrms.dataAccess.UserRepository.CandidateRepository;
import com.hrms.hrms.entity.dtos.candidateDto.CandidateDtoConv;
import com.hrms.hrms.entity.dtos.candidateDto.CandidateReq;
import com.hrms.hrms.entity.dtos.candidateDto.CandidateResponse;
import com.hrms.hrms.entity.users.Candidate;
import com.hrms.hrms.entity.verification.VerificationCandidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateDtoConv candidateDtoConv;
    private final VerificationCandidateService verificationCandidateService;
    private final EmailSender emailSender;
    private final EmailBuilder emailBuilder;
    private final UserService userService;
    private String code;

    protected VerificationCandidate createVerificationCandidate(Candidate candidateWillSaveDb){
        code = UUID.randomUUID().toString();
        return new VerificationCandidate(
                code,
                false,
                LocalDateTime.now().plusMinutes(15),
                candidateWillSaveDb
        );
    }

    protected void sendEmail(String email, String firstName){
        String verificationLink = "http://localhost:8080/verification/verify?code="+code;
        emailSender.send(email, emailBuilder.buildEmail(firstName,verificationLink));
    }


    public CandidateResponse saveCandidate(CandidateReq candidateReq){
        userService.validateUserEmailAndPassword(
                candidateReq.getPassword(),
                candidateReq.getPasswordRepeat(),
                candidateReq.getEmail()
        );
        if(candidateRepository.findByIdentityNumber(candidateReq.getIdentityNumber()).isPresent()){
            throw new IdentityNumberAlreadyInUseException("This identity number is already taken!");
        }

        //save methodları entity return eder.
        Candidate candidateWillSaveDb = candidateDtoConv.convertToCandidate(candidateReq);

        VerificationCandidate verificationCandidate = createVerificationCandidate(candidateWillSaveDb);
        candidateWillSaveDb.setVerificationCandidates(Arrays.asList(verificationCandidate));

        Candidate candidateDb = candidateRepository.save(candidateWillSaveDb);

        sendEmail(candidateWillSaveDb.getEmail(), candidateWillSaveDb.getFirstName());

        return candidateDtoConv.convertToResponse(candidateDb);
    }

    public Optional<Candidate> findCandidateByIdentityNumber(String identityNumber){
        return candidateRepository.findByIdentityNumber(identityNumber);
    }

    protected Candidate findByEmail(String email){
        return candidateRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Email doesn't exist."));
    }


    public void reProduceVerificationCandidate(String email) {
        Candidate candidate = findByEmail(email);

        List<VerificationCandidate> vlist = verificationCandidateService.findAllByCandidateId(candidate.getId());

        for(VerificationCandidate v: vlist){
            if(v.isVerified()){
                throw new AlreadyVerifiedException("This email has already been verified.");
            }
        }

        VerificationCandidate verificationCandidate = createVerificationCandidate(candidate);

        verificationCandidateService.saveVerificationCandidate(verificationCandidate);
        sendEmail(candidate.getEmail(), candidate.getFirstName());

    }

    public List<CandidateResponse> findAllCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();
        return candidateDtoConv.convertToListCandidateResponse(candidates);
    }


    public Candidate findCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId)
                .orElseThrow(() -> new IllegalStateException("Candidate not found!"));
    }
}
