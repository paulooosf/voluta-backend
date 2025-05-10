package br.com.fiap.voluta.model;

import br.com.fiap.voluta.dto.OngDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ongs")
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ONGS")
    @SequenceGenerator(name = "SEQ_ONGS", sequenceName = "SEQ_ONGS", allocationSize = 1)
    @Column(name = "ong_id")
    private Long id;

    private String nome;
    private String descricao;
    private String cnpj;
    private String email;
    private String endereco;

    @OneToMany(mappedBy = "ong")
    private List<Usuario> voluntarios;

    public Ong() {
    }

    public Ong(List<Usuario> voluntarios, String endereco, String email, String cnpj, String descricao, String nome, Long id) {
        this.voluntarios = voluntarios;
        this.endereco = endereco;
        this.email = email;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.nome = nome;
        this.id = id;
    }

    public Ong(OngDTO ong) {
        this.nome = ong.nome();
        this.descricao = ong.descricao();
        this.cnpj = ong.cnpj();
        this.email = ong.email();
        this.endereco = ong.endereco();
    }

    public List<Usuario> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(List<Usuario> voluntarios) {
        this.voluntarios = voluntarios;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
