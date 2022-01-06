package com.hrms.hrms.api.controller.UserController;

import com.hrms.hrms.business.UserService.EmployeeService;
import com.hrms.hrms.entity.dtos.employeeDto.EmployeeReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("saveemployee")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeReq employeeReq){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeReq), HttpStatus.CREATED);
    }

    @GetMapping("findallemployees")
    public ResponseEntity<?> findAllEmployees(){
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }


}
