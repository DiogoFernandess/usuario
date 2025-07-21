package com.agendador.infrastucture.entity;

import  jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "telefone")

public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero" , length = 10)
    private String numero;
    @Column(name = "ddd" , length = 3)
    private String ddd;
}