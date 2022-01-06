package com.hrms.hrms.entity.dtos.employeeDto;

import com.hrms.hrms.entity.dtos.candidateDto.CandidateResponse;
import com.hrms.hrms.entity.users.Candidate;
import com.hrms.hrms.entity.users.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDtoConv {

    public Employee convertToEmployee(EmployeeReq employeeReq){
        return new Employee(
                employeeReq.getEmail(),
                employeeReq.getPassword(),
                LocalDateTime.now(),
                employeeReq.getFirstName(),
                employeeReq.getLastName()
        );

    }

    public EmployeeResponse convertToEmployeeResp(Employee employee){
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getCreatedTime()
        );
    }

    public List<EmployeeResponse> convertToListEmployeeResponse(List<Employee> employees){
        List<EmployeeResponse> employeeResponses = new ArrayList<>();

        for (Employee e : employees){
            employeeResponses.add(convertToEmployeeResp(e));
        }

        return employeeResponses;
    }

}
