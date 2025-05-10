package br.com.fiap.voluta.dto;

import br.com.fiap.voluta.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioSaidaDTO(@NotNull(message = "ID não preenchido!") Long id,
                              @NotBlank(message = "Apelido não preenchido!") String apelido
) {
    public UsuarioSaidaDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getApelido());
    }
}
