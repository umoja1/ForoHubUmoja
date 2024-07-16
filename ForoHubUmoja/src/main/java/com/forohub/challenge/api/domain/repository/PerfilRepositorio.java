package com.forohub.challenge.api.domain.repository;

import com.forohub.challenge.api.domain.models.usuario.perfil.Perfil;
import com.forohub.challenge.api.domain.models.usuario.users.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {
    Perfil findByNombre(String nombre);

    Page<Perfil> findByActivoTrue(Pageable pagina);
}
