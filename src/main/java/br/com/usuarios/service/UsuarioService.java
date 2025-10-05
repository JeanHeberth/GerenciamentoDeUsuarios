package br.com.usuarios.service;

import br.com.usuarios.dto.UsuarioRequestDTO;
import br.com.usuarios.dto.UsuarioResponseDTO;
import br.com.usuarios.entity.Usuario;
import br.com.usuarios.mapper.UsuarioMapper;
import br.com.usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = UsuarioMapper.toUsuario(usuarioRequestDTO);
        usuarioRepository.save(usuario);
        return UsuarioMapper.toUsuarioResponseDTO(usuario);
    }

    public List<UsuarioResponseDTO> listarTodosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toUsuarioResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioResponseDTO> buscarUsuarioPorId(String id) {
        return usuarioRepository.findById(id)
                .map(UsuarioMapper::toUsuarioResponseDTO);
    }

    public void deletarUsuarioPorId(String id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioResponseDTO atualizarUsuarioPorId(String id, UsuarioRequestDTO usuarioRequestDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuario nao encontrado");

        }
        Usuario usuario = usuarioOptional.get();
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
        usuarioRepository.save(usuario);
        return UsuarioMapper.toUsuarioResponseDTO(usuario);
    }

    public List<UsuarioResponseDTO> buscarUsuarioPorNome(String nome) {
        return usuarioRepository.findByNome(nome)
                .stream()
                .map(UsuarioMapper::toUsuarioResponseDTO)
                .collect(Collectors.toList());
    }

    public List<UsuarioResponseDTO> buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .stream()
                .map(UsuarioMapper::toUsuarioResponseDTO)
                .collect(Collectors.toList());
    }

    public List<UsuarioResponseDTO> buscarUsuarioPorTelefone(String telefone) {
        return usuarioRepository.findByTelefone(telefone)
                .stream()
                .map(UsuarioMapper::toUsuarioResponseDTO)
                .collect(Collectors.toList());
    }

    public List<UsuarioResponseDTO> buscarUsuarioPorCep(String cep) {
        return usuarioRepository.findByCep(cep)
                .stream()
                .map(UsuarioMapper::toUsuarioResponseDTO)
                .collect(Collectors.toList());
    }

    public List<UsuarioResponseDTO> buscarUsuarioPorCidade(String cidade) {
        return usuarioRepository.findByCidade(cidade)
                .stream()
                .map(UsuarioMapper::toUsuarioResponseDTO)
                .collect(Collectors.toList());
    }

    public List<UsuarioResponseDTO> buscarUsuarioPorEstado(String estado) {
        return usuarioRepository.findByEstado(estado)
                .stream()
                .map(UsuarioMapper::toUsuarioResponseDTO)
                .collect(Collectors.toList());
    }
}