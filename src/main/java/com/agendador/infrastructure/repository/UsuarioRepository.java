package com.agendador.infrastructure.repository;

import com.agendador.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    boolean existsByEmail(String email);

}
