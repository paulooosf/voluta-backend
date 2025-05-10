package br.com.fiap.voluta.repository;

import br.com.fiap.voluta.model.Ong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OngRepository extends JpaRepository<Ong, Long> {

    Page<Ong> findAll(Pageable pageable);

    Optional<Ong> findById(Long id);

    Optional<Ong> findByCnpj(String cnpj);

    boolean existsByCnpj(String cnpj);
}
