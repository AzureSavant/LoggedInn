package com.azure.LoggedInn.dto;

import com.azure.LoggedInn.shared.ValidationConstraints;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Setter
@Getter
public class EmailDTO {

    @NotNull
    @Email(regexp = ValidationConstraints.EMAIL_REGEX)
    private String oldEmail;

    @NotNull
    @Email(regexp = ValidationConstraints.EMAIL_REGEX)
    private String newEmail;
}
