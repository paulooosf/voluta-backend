package br.com.fiap.voluta.service;

import br.com.fiap.voluta.dto.OngDTO;
import br.com.fiap.voluta.exception.OngJaExisteException;
import br.com.fiap.voluta.model.Ong;
import br.com.fiap.voluta.repository.OngRepository;
import br.com.fiap.voluta.validation.ValidarOngExistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OngService {

    private final OngRepository repository;

    @Autowired
    public OngService(OngRepository repository) {
        this.repository = repository;
    }

    public Page<OngDTO> listar(Pageable pageable) {
        Page<Ong> ongs = repository.findAll(pageable);
        return ongs.map(OngDTO::new);
    }

    public OngDTO buscar(Long id) {
        Optional<Ong> ongOpt = repository.findById(id);
        ValidarOngExistente.validar(ongOpt);
        return new OngDTO(ongOpt.get());
    }

    public OngDTO buscarPorCnpj(String cnpj) {
        Optional<Ong> ongOpt = repository.findByCnpj(cnpj);
        ValidarOngExistente.validar(ongOpt);
        return new OngDTO(ongOpt.get());
    }

    public OngDTO cadastrar(OngDTO ongDTO) {
        if (repository.existsByCnpj(ongDTO.cnpj())) {
            throw new OngJaExisteException("O CNPJ já foi utilizado!");
        }

        repository.save(ongDTO.converter());
        return ongDTO;
    }

    public OngDTO editar(Long id, Ong ong) {
        ValidarOngExistente.validar(repository.findById(id));
        ong.setId(id);
        return new OngDTO(repository.save(ong));
    }

    public void deletar(Long id) {
        ValidarOngExistente.validar(repository.findById(id));
        repository.deleteById(id);
    }
}
