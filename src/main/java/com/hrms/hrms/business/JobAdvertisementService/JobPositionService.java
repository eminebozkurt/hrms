package com.hrms.hrms.business.JobAdvertisementService;

import com.hrms.hrms.dataAccess.jobAdvertisementRepository.JobPositionRepository;
import com.hrms.hrms.entity.dtos.JobPositionDto.JobPositionDtoConv;
import com.hrms.hrms.entity.dtos.JobPositionDto.JobPositionResponse;
import com.hrms.hrms.entity.jobAdvertisement.JobPosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPositionService {

    private final JobPositionRepository jobPositionRepository;
    private final JobPositionDtoConv jobPositionDtoConv;

    public JobPositionResponse saveJobPosition(String positionName) {
        if(jobPositionRepository.findByPositionName(positionName.toUpperCase()).isPresent()){
            throw new IllegalStateException("Position name is already exist!");
        }
        JobPosition savedJobPosition = jobPositionRepository.save(new JobPosition(positionName.toUpperCase()));
        return jobPositionDtoConv.convertToJobPositionResponse(savedJobPosition);
    }


    public List<JobPositionResponse> findAllJobPositions() {
        List<JobPosition> jList = jobPositionRepository.findAll();
        return jobPositionDtoConv.convertToListJobPositionResponse(jList);
    }


    public JobPosition findJobpositionById(Long jobPositionId) {
        return jobPositionRepository.findById(jobPositionId)
                .orElseThrow(() -> new IllegalStateException("Job position not found!"));
    }
}
