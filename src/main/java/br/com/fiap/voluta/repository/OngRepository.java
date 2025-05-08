package br.com.fiap.voluta.repository;

import br.com.fiap.voluta.model.Ong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository extends JpaRepository<Ong, Long> {
}
