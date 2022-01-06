package com.hrms.hrms.dataAccess.VerificationRepository;

import com.hrms.hrms.entity.verification.VerificationCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VerificationCandidateRepository extends JpaRepository<VerificationCandidate,Long> {


    Optional<List<VerificationCandidate>> findAllByCandidateId(Long id);
}
