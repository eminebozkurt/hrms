package com.hrms.hrms.dataAccess.UserRepository;

import com.hrms.hrms.entity.users.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Long> {
    Optional<Employer> findByEmail(String email);
}
