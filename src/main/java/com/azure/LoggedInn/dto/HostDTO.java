package com.azure.LoggedInn.dto;

import com.azure.LoggedInn.shared.ValidationConstraints;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
public class HostDTO {

    protected String name;

    protected String surname;

    protected String password;

    @NotNull
    @Email(regexp = ValidationConstraints.EMAIL_REGEX)
    protected String email;

    protected String phoneNumber;

}
