package br.com.usuarios.repository;

import br.com.usuarios.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByNome(String nome);
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByTelefone(String telefone);
    Optional<Usuario> findByCep(String cep);
    Optional<Usuario> findByCidade(String cidade);
    Optional<Usuario> findByEstado(String estado);

}
