package br.com.fiap.voluta.validation;

import br.com.fiap.voluta.exception.NaoEncontradoException;
import br.com.fiap.voluta.model.Ong;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidarOngExistente {

    private ValidarOngExistente() {
    }

    public static void validar(Optional<Ong> ongOpt) {
        if (ongOpt.isEmpty()) {
            throw new NaoEncontradoException("Ong não encontrada!");
        }
    }
}
