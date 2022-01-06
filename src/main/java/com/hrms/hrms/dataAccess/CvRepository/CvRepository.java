package com.hrms.hrms.dataAccess.CvRepository;

import com.hrms.hrms.entity.cv.Cv;
import com.hrms.hrms.entity.dtos.cvDto.CvResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvRepository extends JpaRepository<Cv, Long> {

    List<Cv> findByCandidateId(Long candidateId);

}
