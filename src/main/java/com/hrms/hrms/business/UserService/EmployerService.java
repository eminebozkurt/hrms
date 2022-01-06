package com.hrms.hrms.business.UserService;

import com.hrms.hrms.business.VerificationService.VerificationEmployerService;
import com.hrms.hrms.core.emailSender.EmailBuilder;
import com.hrms.hrms.core.emailSender.EmailSender;
import com.hrms.hrms.core.exceptions.AlreadyVerifiedException;
import com.hrms.hrms.core.exceptions.EmailNotFoundException;
import com.hrms.hrms.core.exceptions.WebsiteAndEmailNotMatchingException;
import com.hrms.hrms.dataAccess.UserRepository.EmployerRepository;
import com.hrms.hrms.entity.confirmation.ConfirmationEmployer;
import com.hrms.hrms.entity.dtos.employerDto.EmployerDtoConv;
import com.hrms.hrms.entity.dtos.employerDto.EmployerReq;
import com.hrms.hrms.entity.dtos.employerDto.EmployerResponse;
import com.hrms.hrms.entity.users.Employer;
import com.hrms.hrms.entity.verification.VerificationEmployer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final EmployerDtoConv employerDtoConv;
    private final VerificationEmployerService verificationEmployerService;
    private final EmailSender emailSender;
    private final UserService userService;
    private final EmailBuilder emailBuilder;
    private String code;

    protected VerificationEmployer createVerificationEmployer(Employer employerWillSaveDb){
        code = UUID.randomUUID().toString();

        return new VerificationEmployer(
                code,
                false,
                LocalDateTime.now().plusMinutes(15),
                employerWillSaveDb
        );
    }

    protected ConfirmationEmployer createConfirmationEmployer(Employer employerWillSaveDb) {
        return new ConfirmationEmployer(
                false,
                employerWillSaveDb
        );
    }


    protected void sendEmail(String email, String firstName){
        String verificationLink = "http://localhost:8080/verification/verify?code="+code;
        emailSender.send(email, emailBuilder.buildEmail(firstName,verificationLink));
    }

    public EmployerResponse saveEmployer(EmployerReq employerReq){
        userService.validateUserEmailAndPassword(
                employerReq.getPassword(),
                employerReq.getPasswordRepeat(),
                employerReq.getEmail()
        );
        String[] emailSplit = employerReq.getEmail().split("@");
        String[] webSplit = employerReq.getWebAddress().split("www.");
        if(!emailSplit[1].equals(webSplit[1])){
            throw new WebsiteAndEmailNotMatchingException("The extension of the mail and web address is not the same!");
        }

        Employer employerWillSaveDb = employerDtoConv.convertToEmployer(employerReq);

        VerificationEmployer verificationEmployer = createVerificationEmployer(employerWillSaveDb);
        employerWillSaveDb.setVerificationEmployers(Arrays.asList(verificationEmployer));

        ConfirmationEmployer confirmationEmployer = createConfirmationEmployer(employerWillSaveDb);
        employerWillSaveDb.setConfirmationEmployer(confirmationEmployer);

        Employer employerDb = employerRepository.save(employerWillSaveDb);

        sendEmail(employerWillSaveDb.getEmail(), employerWillSaveDb.getCompanyName());
        
        return employerDtoConv.convertToResponse(employerDb);
    }

    protected Employer findByEmail(String email){
        return employerRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("Email doesn't exist."));
    }

    public void reProduceVerificationEmployer(String email) {
        Employer employer = findByEmail(email);

        List<VerificationEmployer> vlist = verificationEmployerService.findAllByEmployerService(employer.getId());

        for(VerificationEmployer v: vlist){
            if(v.isVerified()){
                throw new AlreadyVerifiedException("This email has already been verified.");
            }
        }

      VerificationEmployer verificationEmployer = createVerificationEmployer(employer);
        verificationEmployerService.saveVerificationEmployer(verificationEmployer);

        sendEmail(employer.getEmail(), employer.getCompanyName());

    }

    public List<EmployerResponse> findAllEmployers() {
        List<Employer> employers = employerRepository.findAll();
        return employerDtoConv.convertToListEmployerResponse(employers);
    }

    public Employer findEmployerById(Long employerId) {
        return employerRepository.findById(employerId)
                .orElseThrow(() -> new IllegalStateException("Employer not found!"));
    }
}
