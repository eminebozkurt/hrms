package com.hrms.hrms.dataAccess.CvRepository;

import com.hrms.hrms.entity.cv.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education,Long> {
}
