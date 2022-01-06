package com.hrms.hrms.entity.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrms.entity.verification.VerificationCandidate;
import com.hrms.hrms.entity.verification.VerificationEmployer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="candidates")
@NoArgsConstructor
public class Candidate extends User{

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 11, unique = true)
    private String identityNumber;

    private int birthYear;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<VerificationCandidate> verificationCandidates;


    public Candidate(String email, String password, LocalDateTime createdTime, String firstName, String lastName, String identityNumber, int birthYear) {
        super(email, password, createdTime);
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.birthYear = birthYear;
    }
}
