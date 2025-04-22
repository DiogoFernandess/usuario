package com.agendador.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
@Builder
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rua")
    private String rua;
    @Column (name = "numero")
    private String nuumero;
    @Column (name = "complemento", length = 10)
    private String complemento;
    @Column (name = "cidade", length = 150)
    private String cidade;
    @Column (name = "estado", length = 2)
    private String estado;
    @Column (name = "cep" , length = 9)
    private String cep;
}
