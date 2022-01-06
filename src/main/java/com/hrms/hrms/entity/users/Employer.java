package com.hrms.hrms.entity.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrms.entity.confirmation.ConfirmationEmployer;
import com.hrms.hrms.entity.verification.VerificationEmployer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "employers")
@NoArgsConstructor
public class Employer extends User{

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String webAddress;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<VerificationEmployer> verificationEmployers;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private ConfirmationEmployer confirmationEmployer;

    public Employer(String email, String password, LocalDateTime createdTime, String companyName, String webAddress, String phoneNumber) {
        super(email, password, createdTime);
        this.companyName = companyName;
        this.webAddress = webAddress;
        this.phoneNumber = phoneNumber;
    }
}
