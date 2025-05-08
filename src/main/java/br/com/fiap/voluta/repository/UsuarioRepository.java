package br.com.fiap.voluta.repository;

import br.com.fiap.voluta.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
