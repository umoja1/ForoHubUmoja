package com.forohub.challenge.api.domain.models.respuesta;

import com.forohub.challenge.api.domain.models.topico.Topico;

import java.util.List;

public record TopicoRespuestaDto(
        long id,
        String titulo,
        String mensaje,
        String nombre,
        String fechaCreacion
){
}
