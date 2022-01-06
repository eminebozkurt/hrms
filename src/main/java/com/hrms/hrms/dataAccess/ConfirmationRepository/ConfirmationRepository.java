package com.hrms.hrms.dataAccess.ConfirmationRepository;

import com.hrms.hrms.entity.confirmation.Confirmation;
import com.hrms.hrms.entity.users.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation,Long> {

    @Transactional
    @Modifying
    @Query("update Confirmation c set c.isConfirmed=true, c.confirmedDate=:now, c.employee=:employee where c.id=:confirmationId")
    void updateConfirmation(LocalDateTime now, Employee employee, Long confirmationId);
}
