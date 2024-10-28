package com.example.user_api.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "CPF is mandatory")
    private String cpf;
    private String adress;
    @NotBlank(message = "Email is mandatory")
    private String email;
    private String phone;
    private LocalDateTime signUpDate;
    
}
