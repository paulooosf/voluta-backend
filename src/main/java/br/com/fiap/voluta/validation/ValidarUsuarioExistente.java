package br.com.fiap.voluta.validation;

import br.com.fiap.voluta.exception.NaoEncontradoException;
import br.com.fiap.voluta.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidarUsuarioExistente {

    private ValidarUsuarioExistente() {
    }

    public static void validar(Optional<Usuario> usuarioOpt) {
        if (usuarioOpt.isEmpty()) {
            throw new NaoEncontradoException("Usuário não encontrado!");
        }
    }
}