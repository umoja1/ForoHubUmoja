package com.forohub.challenge.api.domain.repository;

import com.forohub.challenge.api.domain.models.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepositorio extends JpaRepository<Topico, Long> {
    boolean existsByTitulo(String titulo);

    boolean existsByMensaje(String mensaje);


    Page<Topico> findByActivoTrue(Pageable pageable);
}
