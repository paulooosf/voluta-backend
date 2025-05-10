package br.com.fiap.voluta.repository;

import br.com.fiap.voluta.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findAll(Pageable pageable);

    Optional<Usuario> findById(Long id);

    UserDetails findByApelido(String apelido);

    Optional<Usuario> findByEmail(String email);

    boolean existsByApelido(String apelido);

    boolean existsByEmail(String email);
}
