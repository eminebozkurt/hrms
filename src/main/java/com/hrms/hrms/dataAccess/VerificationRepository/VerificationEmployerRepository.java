package com.hrms.hrms.dataAccess.VerificationRepository;

import com.hrms.hrms.entity.verification.VerificationEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerificationEmployerRepository extends JpaRepository<VerificationEmployer,Long> {
    Optional<List<VerificationEmployer>> findAllByEmployerId(Long id);
}
