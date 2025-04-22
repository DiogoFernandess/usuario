package com.agendador.business;

import com.agendador.business.converter.UsuarioConverter;
import com.agendador.business.dtos.UsuarioDTO;
import com.agendador.infrastructure.entity.Usuario;
import com.agendador.infrastructure.exceptions.ConflictException;
import com.agendador.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;


    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));

    }

}

