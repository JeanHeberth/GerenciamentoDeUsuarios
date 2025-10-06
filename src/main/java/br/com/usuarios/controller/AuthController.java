package br.com.usuarios.controller;

import br.com.usuarios.config.JwtUtil;
import br.com.usuarios.dto.UsuarioRequestDTO;
import br.com.usuarios.entity.Usuario;
import br.com.usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder bCrypt;


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(usuarioRequestDTO.email());

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOptional.get();

        if (!bCrypt.matches(usuarioRequestDTO.senha(), usuario.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        String token = jwtUtil.gerarToken(usuario.getEmail());

        // Monta a resposta JSON
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("email", usuario.getEmail());
        response.put("nome", usuario.getNome());
        response.put("role", usuario.getRoles());
        return ResponseEntity.ok(response);
    }
}
