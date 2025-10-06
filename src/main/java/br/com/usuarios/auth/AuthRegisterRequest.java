package br.com.usuarios.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthRegisterRequest(
        @NotBlank @Email
        String email,
        @NotBlank
        String senha
) {
}
