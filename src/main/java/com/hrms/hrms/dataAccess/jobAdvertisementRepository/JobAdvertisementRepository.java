package com.hrms.hrms.dataAccess.jobAdvertisementRepository;

import com.hrms.hrms.entity.dtos.jobAdvertisementDto.JobAdvertisementCustomDto;
import com.hrms.hrms.entity.jobAdvertisement.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement,Long> {

    @Transactional
    @Modifying
    @Query("update JobAdvertisement set isActive = false where id=:jobAdvertisementId")
    void closeJobAdvertisementById(Long jobAdvertisementId);


    @Query("select new com.hrms.hrms.entity.dtos.jobAdvertisementDto.JobAdvertisementCustomDto(" +
            "j.employer.companyName," +
            "j.jobPosition.positionName," +
            "j.openPositionNumber," +
            "j.createdDate," +
            "j.deadline)" +
            " from JobAdvertisement j where j.isActive=true")
    List<JobAdvertisementCustomDto> findAllActiveJobAdvertisements();

    @Query("select new com.hrms.hrms.entity.dtos.jobAdvertisementDto.JobAdvertisementCustomDto(" +
            "j.employer.companyName," +
            "j.jobPosition.positionName," +
            "j.openPositionNumber," +
            "j.createdDate," +
            "j.deadline)" +
            " from JobAdvertisement j where j.isActive=true" +
            " order by j.createdDate")
    List<JobAdvertisementCustomDto> findAllActiveJobAdvertisementsOrderByDate();

    @Query("select new com.hrms.hrms.entity.dtos.jobAdvertisementDto.JobAdvertisementCustomDto(" +
            "j.employer.companyName," +
            "j.jobPosition.positionName," +
            "j.openPositionNumber," +
            "j.createdDate," +
            "j.deadline)" +
            " from JobAdvertisement j where j.isActive=true and j.employer.companyName=:companyName")
    List<JobAdvertisementCustomDto> findAllActiveJobAdvertisementsByCompany(String companyName);

}
