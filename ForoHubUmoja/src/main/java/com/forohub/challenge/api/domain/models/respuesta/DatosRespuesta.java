package com.forohub.challenge.api.domain.models.respuesta;

public record DatosRespuesta(

        Long id,

        String mensaje,

        String fechaCreacion,

        TopicoRespuestaDto topicoId
) {
}
