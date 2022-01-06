package com.hrms.hrms.business.ConfirmationService;

import com.hrms.hrms.business.UserService.EmployeeService;
import com.hrms.hrms.core.exceptions.ConfirmationAlreadyConfirmedException;
import com.hrms.hrms.core.exceptions.ConfirmationNotFoundException;
import com.hrms.hrms.dataAccess.ConfirmationRepository.ConfirmationRepository;
import com.hrms.hrms.entity.confirmation.Confirmation;
import com.hrms.hrms.entity.users.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConfirmationService {

    private final ConfirmationRepository confirmationRepository;
    private final EmployeeService employeeService;

    protected Confirmation findConfirmById(Long confirmationId){
        return confirmationRepository.findById(confirmationId)
                .orElseThrow(() -> new ConfirmationNotFoundException("Confirmation not found."));
    }



    public void confirmById(Long confirmationId, Long employeeId) {
        Confirmation confirmation = findConfirmById(confirmationId);

        if (confirmation.isConfirmed() || confirmation.getConfirmedDate() != null) {
            throw new ConfirmationAlreadyConfirmedException("Confirmation has been already done.");
        }

        Employee employee = employeeService.findEmployeeById(employeeId);

        confirmationRepository.updateConfirmation(LocalDateTime.now(), employee, confirmationId);


    }
}
