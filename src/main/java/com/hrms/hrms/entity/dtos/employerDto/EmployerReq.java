package com.hrms.hrms.entity.dtos.employerDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class EmployerReq {
    //şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, şifre, şifre tekrarı

    @NotNull
    @NotBlank(message = "Company name is required.")
    private String companyName;

    @NotNull
    @NotBlank(message = "Website is required.")
    private String webAddress;

    @NotNull
    @NotBlank(message = "Email is required.")
    @Email(message = "Your email must be in an email format.")
    private String email;

    @NotNull
    @NotBlank(message = "Password is required.")
    @Size(min = 5, max = 12, message = "Your password must be between 5-12 characters.")
    private String password;

    @NotNull
    @NotBlank(message = "Password repeat is required.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordRepeat;

    @NotNull
    @NotBlank(message = "Phone number is required.")
    @Size(min = 12, max = 12, message = "Phone number must be 12 characters.")
    private String phoneNumber;



}
