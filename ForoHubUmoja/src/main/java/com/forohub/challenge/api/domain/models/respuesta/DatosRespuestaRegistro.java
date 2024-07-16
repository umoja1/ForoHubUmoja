package com.forohub.challenge.api.domain.models.respuesta;

public record DatosRespuestaRegistro(

        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion
) {
}
