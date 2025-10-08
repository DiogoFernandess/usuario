package com.agendador.business;


import com.agendador.business.converter.UsuarioConverter;
import com.agendador.business.dto.EnderecoDTO;
import com.agendador.business.dto.TelefoneDTO;
import com.agendador.business.dto.UsuarioDTO;
import com.agendador.infrastucture.Client.ViaCepDTO;
import com.agendador.infrastucture.entity.Endereco;
import com.agendador.infrastucture.entity.Telefone;
import com.agendador.infrastucture.entity.Usuario;
import com.agendador.infrastucture.exceptions.ConflictException;
import com.agendador.infrastucture.exceptions.ResourceNotFoundException;
import com.agendador.infrastucture.repository.EnderecoRepository;
import com.agendador.infrastucture.repository.TelefoneRepository;
import com.agendador.infrastucture.repository.UsuarioRepository;
import com.agendador.infrastucture.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final EnderecoRepository enderecoRepository;
    private final TelefoneRepository telefoneRepository;

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

    public UsuarioDTO buscaUsuarioPorEmail(String email) {
        try {
            return usuarioConverter.paraUsuarioDTO(
            usuarioRepository.findByEmail(email)
                    .orElseThrow(
                    () -> new ResourceNotFoundException("Email não encontrado" + email)
                    )
            );
        } catch (ResourceNotFoundException e ){
            throw new ResourceNotFoundException("Email não encontrado" +email);
        }
    }
    public void deletaUsuarioPorEmail(String email){ usuarioRepository.deleteByEmail(email);}

    public UsuarioDTO atualizaDadosUsuario(String token, UsuarioDTO dto){
       //Busca de email do usuário através do token (tira a obrigatoriedade do email)
       String email = jwtUtil.extractUsername(token.substring(7));

       //Criptografia de senha
       dto.setSenha(dto.getSenha()!=null ? passwordEncoder.encode(dto.getSenha()) : null);

       //Busca dos dados do usuário no banco de dados
       Usuario usuarioEntity = usuarioRepository.findByEmail(email).orElseThrow(()->
               new ResourceNotFoundException("Email não localizado"));
       //Mescla dos dados recebidos na requisição DTO com dados do DB
       Usuario usuario = usuarioConverter.updateUsuario(dto, usuarioEntity);

       //Salva novos dados do usuário convertido e depois converte para usuarioDTO
       return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }

    public EnderecoDTO atualizaEndereco(Long idEndereco, EnderecoDTO enderecoDTO) {

        Endereco entity = enderecoRepository.findById(idEndereco).orElseThrow(() ->
                new ResourceNotFoundException("Id não encontrado "+ idEndereco));

        Endereco endereco = usuarioConverter.updateEndereco(enderecoDTO, entity);


        return  usuarioConverter.paraEnderecoDTO(enderecoRepository.save(endereco));
    }

    public TelefoneDTO atualizaTelefone(Long idTelefone, TelefoneDTO telefoneDTO){
        Telefone entity = telefoneRepository.findById(idTelefone).orElseThrow(()->
                new ResourceNotFoundException("Id não encontrado " + idTelefone));

        Telefone telefone = usuarioConverter.updateTelefone(telefoneDTO, entity);

        return usuarioConverter.paraTelefoneDTO(telefoneRepository.save(telefone));
    }

    public EnderecoDTO cadastraEndereco(String token, EnderecoDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()->
                new ResourceNotFoundException("Email não localizado" + email));

        Endereco endereco = usuarioConverter.paraEnderecoEntity(dto, usuario.getId());
        return usuarioConverter.paraEnderecoDTO(
                enderecoRepository.save(endereco));
    }

    public TelefoneDTO cadastraTelefone(String token, TelefoneDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()->
                new ResourceNotFoundException("Email não localizado" + email));

        Telefone telefone = usuarioConverter.paraTelefoneEntity(dto, usuario.getId());
        return usuarioConverter.paraTelefoneDTO(
                telefoneRepository.save(telefone));
    }
}
