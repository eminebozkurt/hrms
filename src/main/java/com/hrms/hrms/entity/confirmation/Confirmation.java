package com.hrms.hrms.entity.confirmation;

import com.hrms.hrms.entity.BaseEntity;
import com.hrms.hrms.entity.users.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="confirmation")
@Data
@NoArgsConstructor
public class Confirmation extends BaseEntity {

    @Column(nullable = false)
    private boolean isConfirmed;

    private LocalDateTime confirmedDate;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Confirmation(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
}
