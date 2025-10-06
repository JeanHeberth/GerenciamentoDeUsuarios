package br.com.usuarios.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record UsuarioRequestDTO(


        @Schema(description = "Nome completo do usuário", example = "Jessica Jasmine")
        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
        String nome,

        @Schema(description = "Email do usuário (único e válido)", example = "jessica@email.com")
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email deve ser válido")
        String email,

        @Schema(description = "Senha do usuário (mínimo 8 caracteres)", example = "senha1234")
        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 8, max = 20, message = "Senha deve ter entre 8 e 20 caracteres")
        String senha,

        @Schema(description = "Telefone no formato DDD + número", example = "61999999999")
        @NotBlank(message = "Telefone é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "Telefone deve ter 11 dígitos (DDD + número)")
        String telefone,

        @Schema(description = "Endereço completo", example = "Rua das Flores, 123")
        @Size(max = 200, message = "Endereço não pode ultrapassar 200 caracteres")
        @NotBlank(message = "Endereço é obrigatório")
        String endereco,

        @Schema(description = "CEP do usuário (apenas números)", example = "70000000")
        @Pattern(regexp = "\\d{8}", message = "CEP deve ter 8 dígitos numéricos")
        @NotBlank(message = "CEP é obrigatório")
        String cep,

        @Schema(description = "Cidade de residência do usuário", example = "Brasília")
        @NotBlank(message = "Cidade é obrigatória")
        String cidade,

        @Schema(description = "Estado de residência do usuário", example = "DF")
        @NotBlank(message = "Estado é obrigatório")
        String estado,

        @Schema(description = "Complemento do endereço", example = "Bloco A, Apt 202")
        String complemento,

        @Schema(description = "Bairro do usuário", example = "Centro")
        @NotBlank(message = "Bairro é obrigatório")
        String bairro,

        @Schema(description = "Número da residência", example = "123")
        @NotBlank(message = "Número é obrigatório")
        String numero,

        @Schema(description = "País do usuário", example = "Brasil")

        String pais
) {
}
