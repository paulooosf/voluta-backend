package br.com.fiap.voluta.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("admin"),
    USUARIO("usuario");

    private String role;
}
