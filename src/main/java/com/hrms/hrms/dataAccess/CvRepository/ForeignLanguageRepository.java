package com.hrms.hrms.dataAccess.CvRepository;

import com.hrms.hrms.entity.cv.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignLanguageRepository extends JpaRepository<ForeignLanguage,Long> {
}
