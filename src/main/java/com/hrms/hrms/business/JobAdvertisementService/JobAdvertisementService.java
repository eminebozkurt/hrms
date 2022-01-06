package com.hrms.hrms.business.JobAdvertisementService;

import com.hrms.hrms.business.UserService.EmployeeService;
import com.hrms.hrms.business.UserService.EmployerService;
import com.hrms.hrms.dataAccess.jobAdvertisementRepository.JobAdvertisementRepository;
import com.hrms.hrms.entity.dtos.jobAdvertisementDto.JobAdvertisementCustomDto;
import com.hrms.hrms.entity.dtos.jobAdvertisementDto.JobAdvertisementDtoConv;
import com.hrms.hrms.entity.dtos.jobAdvertisementDto.JobAdvertisementReq;
import com.hrms.hrms.entity.dtos.jobAdvertisementDto.JobAdvertisementResponse;
import com.hrms.hrms.entity.jobAdvertisement.City;
import com.hrms.hrms.entity.jobAdvertisement.JobAdvertisement;
import com.hrms.hrms.entity.jobAdvertisement.JobPosition;
import com.hrms.hrms.entity.users.Employer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobAdvertisementService {

    private final JobAdvertisementRepository jobAdvertisementRepository;
    private final JobAdvertisementDtoConv jobAdvertisementDtoConv;
    private final JobPositionService jobPositionService;
    private final EmployerService employerService;
    private final CityService cityService;


    public JobAdvertisementResponse saveJobAdvertisement(JobAdvertisementReq jobAdvertisementReq) {
        JobPosition jobPosition = jobPositionService.findJobpositionById(jobAdvertisementReq.getJobPositionId());
        Employer employer = employerService.findEmployerById(jobAdvertisementReq.getEmployerId());
        City city = cityService.findCityById(jobAdvertisementReq.getCityId());

        JobAdvertisement jobAdvertisementWillSaveDb = jobAdvertisementDtoConv.convertToJobAdvertisement(jobAdvertisementReq,jobPosition,city,employer);

        JobAdvertisement jobAdvertisementSaved = jobAdvertisementRepository.save(jobAdvertisementWillSaveDb);

        return jobAdvertisementDtoConv.convertToJobAdvertisementResponse(jobAdvertisementSaved);

    }

    public JobAdvertisement findJobAdvertisementById(Long id){
        return jobAdvertisementRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Job advertisement not found"));
    }

    public void closeJobAdvertisement(Long jobAdvertisementId, Long employerId) {
        JobAdvertisement jobAdvertisement = findJobAdvertisementById(jobAdvertisementId);
        Employer employer = employerService.findEmployerById(employerId);

        if(!jobAdvertisement.isActive()){
            throw  new IllegalStateException("The job advertisememt has already been closed.");
        }

        jobAdvertisementRepository.closeJobAdvertisementById(jobAdvertisementId);

    }

    public List<JobAdvertisementCustomDto> findAllActiveJobAdvertisements() {
        return jobAdvertisementRepository.findAllActiveJobAdvertisements();
    }

    public List<JobAdvertisementCustomDto> findAllActiveJobAdvertisementsOrderByDate() {
        return jobAdvertisementRepository.findAllActiveJobAdvertisementsOrderByDate();
    }

    public List<JobAdvertisementCustomDto> findAllActiveJobAdvertisementsByCompany(String companyName){
        return jobAdvertisementRepository.findAllActiveJobAdvertisementsByCompany(companyName);
    }

}
