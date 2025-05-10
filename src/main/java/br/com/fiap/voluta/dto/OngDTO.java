package br.com.fiap.voluta.dto;

import br.com.fiap.voluta.model.Ong;
import jakarta.validation.constraints.NotBlank;

public record OngDTO(
        @NotBlank(message = "Preencha o nome!") String nome,
        @NotBlank(message = "Preencha a descrição!") String descricao,
        @NotBlank(message = "Preencha o cnpj!") String cnpj,
        @NotBlank(message = "Preencha o email!") String email,
        @NotBlank(message = "Preencha o endereço!") String endereco
) {
    public OngDTO(Ong ong) {
        this(ong.getNome(), ong.getDescricao(), ong.getCnpj(), ong.getEmail(), ong.getEndereco());
    }

    public Ong converter () {
        return new Ong(this);
    }
}
