package com.example.resourcesmanagement.security.payload.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Data
@Getter
@Setter
public class LoginRequest {
    @NotBlank

    private String email;
    @NotBlank
    private  String password;
}
