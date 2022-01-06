package com.hrms.hrms.dataAccess.VerificationRepository;

import com.hrms.hrms.entity.verification.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface VerificationRepository extends JpaRepository<Verification,Long> {
    Optional<Verification> findByCode(String code);

    @Transactional
    @Modifying
    @Query("update Verification v set v.isVerified = true, v.verifiedDate=:now where v.code=:code")
    void updateVerification(String code, LocalDateTime now);


}
