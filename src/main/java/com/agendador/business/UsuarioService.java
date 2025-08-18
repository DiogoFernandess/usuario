package com.agendador.business;


import com.agendador.business.converter.UsuarioConverter;
import com.agendador.business.dto.UsuarioDTO;
import com.agendador.infrastucture.entity.Usuario;
import com.agendador.infrastucture.exceptions.ConflictException;
import com.agendador.infrastucture.exceptions.ResourceNotFoundException;
import com.agendador.infrastucture.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        emailExiste(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }



    public void emailExiste(String email){
        try {
            boolean exite = verificaEmailExistente(email);
            if (exite) {
                throw new ConflictException("Email já cadastrado" + email);
            }
        } catch (ConflictException e){
            throw new ConflictException("Email já cadastrado" + e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscaUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não encontrado" +email));
    }

    public void deletaUsuarioPorEmail(String email){ usuarioRepository.deleteByEmail(email);}

}
