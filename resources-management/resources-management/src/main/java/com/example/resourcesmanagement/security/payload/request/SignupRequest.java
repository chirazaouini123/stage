package com.example.resourcesmanagement.security.payload.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    //@NotBlank
    //@Size(min = 3, max = 20)
    //private String username;
    @NotBlank
    @Size(min = 3, max = 20)
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 20)
    private String lastName;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;




}
