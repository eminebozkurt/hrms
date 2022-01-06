package com.hrms.hrms.dataAccess.ConfirmationRepository;

import com.hrms.hrms.entity.confirmation.ConfirmationEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationEmployerRepository extends JpaRepository<ConfirmationEmployer,Long> {
}
