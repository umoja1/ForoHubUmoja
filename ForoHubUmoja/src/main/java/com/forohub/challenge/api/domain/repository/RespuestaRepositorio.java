package com.forohub.challenge.api.domain.repository;

import com.forohub.challenge.api.domain.models.respuesta.Respuesta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepositorio extends JpaRepository<Respuesta,Long> {
    Page<Respuesta> findByActivoTrue(Pageable pagina);
}
