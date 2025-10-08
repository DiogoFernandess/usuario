package com.agendador.business;


import com.agendador.infrastucture.Client.ViaCepClient;
import com.agendador.infrastucture.Client.ViaCepDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ViaCepResponse {

    private ViaCepClient client;

    public ViaCepDTO buscarDadosEndereco(String cep)  {
        return client.buscaDadosEndereco(processarCep(cep));
    }

    private String processarCep (String cep) {
        String cepFormatado = cep.replace(" ", "")
                .replace("-", "");

        if (!cepFormatado.matches("\\d+") || !Objects.equals(cepFormatado.length(),8)){
            try {
                throw new IllegalAccessException("O CEP contêm caracteres inválidos");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return cepFormatado;
    }
}
