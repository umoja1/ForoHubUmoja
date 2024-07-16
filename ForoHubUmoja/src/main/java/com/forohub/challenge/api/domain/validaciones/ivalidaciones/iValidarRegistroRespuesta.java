package com.forohub.challenge.api.domain.validaciones.ivalidaciones;

import com.forohub.challenge.api.domain.models.respuesta.DatoRegistroRespuesta;
import com.forohub.challenge.api.domain.models.respuesta.Respuesta;
import com.forohub.challenge.api.domain.models.topico.Topico;
import com.forohub.challenge.api.domain.models.usuario.perfil.Perfil;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface iValidarRegistroRespuesta {
    void existenRespuestas(Page<Respuesta> respuestas);

    void existeRespuestaId(List<Respuesta> respuestas, Long id);

    void existenDatos(DatoRegistroRespuesta datos);

    void existeId(Long id);

    void perfilExiste(Optional<Perfil> perfil);

    void topicoExiste(Optional<Topico> topico);

    void existeRespuestaEnDb(boolean existeRespuesta);


    void respuestaExiste(Optional<Respuesta> respuesta);
}
