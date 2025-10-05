package br.com.usuarios.dto;

import org.springframework.http.ResponseEntity;

public record UsuarioResponseDTO (

        String id,
        String nome,
        String email,
        String endereco,
        String telefone,
        String cep,
        String cidade,
        String estado,
        String complemento,
        String bairro,
        String numero,
        String pais
) {}
