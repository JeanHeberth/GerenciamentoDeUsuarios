package br.com.usuarios.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@Builder
@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String telefone;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;
    private String bairro;
    private String numero;
    private String pais;
    private Set<String> roles;
}
