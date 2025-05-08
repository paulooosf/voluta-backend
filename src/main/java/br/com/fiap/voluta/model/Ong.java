package br.com.fiap.voluta.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ongs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ONGS")
    @SequenceGenerator(name = "SEQ_ONGS", sequenceName = "SEQ_ONGS", allocationSize = 1)
    @Column(name = "ong_id")
    private Long id;

    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private String endereco;

    @Column(name = "data_fundacao")
    private LocalDate dataFundacao;

    @OneToMany(mappedBy = "ong")
    private List<Usuario> voluntarios;
}
