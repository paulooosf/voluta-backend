package br.com.fiap.voluta.Enum;

public enum Role {
    ADMIN("admin"),
    USUARIO("usuario");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
