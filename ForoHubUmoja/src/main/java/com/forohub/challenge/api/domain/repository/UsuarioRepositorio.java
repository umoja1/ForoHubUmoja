package com.forohub.challenge.api.domain.repository;

import com.forohub.challenge.api.domain.models.categoria.Roles;
import com.forohub.challenge.api.domain.models.usuario.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String subject);

    boolean existsByLogin(String login);

}
