package com.azure.LoggedInn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Setter
@Getter
public class PasswordDTO {

    @NotNull
    private String oldPassword;

    @NotNull
    private String newPassword;
}
