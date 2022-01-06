package com.hrms.hrms.entity.verification;

import com.hrms.hrms.entity.users.Candidate;
import com.hrms.hrms.entity.users.Employer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="verification_employer")
@NoArgsConstructor
public class VerificationEmployer extends Verification{


    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    public VerificationEmployer(String code, boolean isVerified, LocalDateTime expirationDate, Employer employer) {
        super(code, isVerified, expirationDate);
        this.employer = employer;
    }
}
