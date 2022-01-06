package com.hrms.hrms.entity.confirmation;

import com.hrms.hrms.entity.users.Employer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "confirmation_employer")
@NoArgsConstructor
public class ConfirmationEmployer extends Confirmation{

    @OneToOne(mappedBy = "confirmationEmployer")
    @JoinColumn(name="employer_id")
    private Employer employer;

    public ConfirmationEmployer(boolean isConfirmed, Employer employer) {
        super(isConfirmed);
        this.employer = employer;
    }
}
