package com.hrms.hrms.entity.verification;

import com.hrms.hrms.entity.users.Candidate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="verification_candidate")
@NoArgsConstructor
public class VerificationCandidate extends Verification{

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public VerificationCandidate(String code, boolean isVerified, LocalDateTime expirationDate, Candidate candidate) {
        super(code, isVerified, expirationDate);
        this.candidate = candidate;
    }
}
