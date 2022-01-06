package com.hrms.hrms.entity.dtos.candidateDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class CandidateReq {

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
    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotNull
    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotNull
    @NotBlank(message = "ID is required.")
    @Size(min = 11, max = 11, message = "Identity number must be 11 characters.")
    private String identityNumber;

    @Min(value = 1900, message = "Birth date is required.")
    private int birthYear;


}
