package com.agendador.business.dtos;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EnderecoDTO {

    private String rua;
    private String nuumero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
}
