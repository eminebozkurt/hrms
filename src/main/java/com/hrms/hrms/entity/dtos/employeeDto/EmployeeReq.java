package com.hrms.hrms.entity.dtos.employeeDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class EmployeeReq {

    @NotBlank(message = "Email is required!")
    @NotNull
    @Email(message = "Email should be correct format!")
    private String email;

    @NotBlank(message = "Password is required!")
    @NotNull
    @Size(min = 5,max = 25,message = "Password should be between 6 and 25 characters!")
    private String password;

    @NotBlank(message = "Password-repeat is required!")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordRepeat;

    @NotBlank(message = "First name is required!")
    @NotNull
    private String firstName;

    @NotBlank(message = "Last name is required!")
    @NotNull
    private String lastName;


}
