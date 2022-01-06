package com.hrms.hrms.dataAccess.jobAdvertisementRepository;

import com.hrms.hrms.entity.jobAdvertisement.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition,Long> {
    Optional<JobPosition> findByPositionName(String positionName);
}
