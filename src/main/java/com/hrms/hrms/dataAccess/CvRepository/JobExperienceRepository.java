package com.hrms.hrms.dataAccess.CvRepository;

import com.hrms.hrms.entity.cv.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobExperienceRepository extends JpaRepository<JobExperience,Long> {
}
