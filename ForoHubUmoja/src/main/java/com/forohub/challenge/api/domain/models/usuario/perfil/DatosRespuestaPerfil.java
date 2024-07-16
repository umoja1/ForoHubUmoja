package com.forohub.challenge.api.domain.models.usuario.perfil;

import com.forohub.challenge.api.domain.models.respuesta.Respuesta;
import com.forohub.challenge.api.domain.models.topico.Topico;
import com.forohub.challenge.api.domain.models.usuario.users.Usuario;

import java.util.List;

public record DatosRespuestaPerfil(

        Long id,

        String nombre,

        String fechaCreacion,

        String fechaActualizacion
) {
}
