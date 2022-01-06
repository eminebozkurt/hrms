package com.hrms.hrms.dataAccess.UserRepository;

import com.hrms.hrms.entity.users.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Optional<Candidate> findByIdentityNumber(String identityNumber);


    Optional<Candidate> findByEmail(String email);



}
