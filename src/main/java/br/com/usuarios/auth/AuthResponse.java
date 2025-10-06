package br.com.usuarios.auth;

public record AuthResponse(
        String accessToken,
        String tokenType
) {
}
