package br.com.usuarios.mapper;

import br.com.usuarios.dto.UsuarioRequestDTO;
import br.com.usuarios.dto.UsuarioResponseDTO;
import br.com.usuarios.entity.Usuario;

public class UsuarioMapper {


    public static Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.nome());
        usuario.setEmail(usuarioRequestDTO.email());
        usuario.setEndereco(usuarioRequestDTO.endereco());
        usuario.setTelefone(usuarioRequestDTO.telefone());
        usuario.setCep(usuarioRequestDTO.cep());
        usuario.setCidade(usuarioRequestDTO.cidade());
        usuario.setEstado(usuarioRequestDTO.estado());
        usuario.setComplemento(usuarioRequestDTO.complemento());
        usuario.setBairro(usuarioRequestDTO.bairro());
        usuario.setNumero(usuarioRequestDTO.numero());
        usuario.setPais(usuarioRequestDTO.pais());
        return usuario;
    }

    public static UsuarioResponseDTO toUsuarioResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getEndereco(),
                usuario.getTelefone(),
                usuario.getCep(),
                usuario.getCidade(),
                usuario.getEstado(),
                usuario.getComplemento(),
                usuario.getBairro(),
                usuario.getNumero(),
                usuario.getPais()
        );
    }
}
