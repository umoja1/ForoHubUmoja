package com.forohub.challenge.api.domain.models.respuesta;

import com.forohub.challenge.api.domain.models.categoria.Curso;
import com.forohub.challenge.api.domain.models.topico.Topico;

public record DatosRespuestaPorId(

        Long id,

        String mensaje,

        String titulo,

        Curso curso,

        String autor,

        Long topicoId,

        String fechaCreacion
) {
}
