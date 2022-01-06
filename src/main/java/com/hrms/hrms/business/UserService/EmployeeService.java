package com.hrms.hrms.business.UserService;

import com.hrms.hrms.core.exceptions.EmployeeNotFoundException;
import com.hrms.hrms.dataAccess.UserRepository.EmployeeRepository;
import com.hrms.hrms.entity.dtos.employeeDto.EmployeeDtoConv;
import com.hrms.hrms.entity.dtos.employeeDto.EmployeeReq;
import com.hrms.hrms.entity.dtos.employeeDto.EmployeeResponse;
import com.hrms.hrms.entity.users.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDtoConv employeeDtoConv;
    private final UserService userService;

    public Employee findEmployeeById(Long employeeId){
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee does not exist."));
    }

    public EmployeeResponse saveEmployee(EmployeeReq employeeReq) {
        userService.validateUserEmailAndPassword(
                employeeReq.getPassword(),
                employeeReq.getPasswordRepeat(),
                employeeReq.getEmail()
        );

        Employee employeeWillSaveDb = employeeDtoConv.convertToEmployee(employeeReq);
        Employee employeeSaved = employeeRepository.save(employeeWillSaveDb);

        return employeeDtoConv.convertToEmployeeResp(employeeSaved);
    }

    public List<EmployeeResponse> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeDtoConv.convertToListEmployeeResponse(employees);
    }
}
