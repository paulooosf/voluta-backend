package br.com.fiap.voluta.model;

import br.com.fiap.voluta.Enum.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIOS")
    @SequenceGenerator(name = "SEQ_USUARIOS", sequenceName = "SEQ_USUARIOS", allocationSize = 1)
    @Column(name = "usuario_id")
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "ong_id")
    private Ong ong;
}
