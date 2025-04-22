package com.agendador.business.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private String email;
    private String senha;
    private String nome;
    private List<EnderecoDTO> enderecos;
    private List<TelefoneDTO> telefone;
}
