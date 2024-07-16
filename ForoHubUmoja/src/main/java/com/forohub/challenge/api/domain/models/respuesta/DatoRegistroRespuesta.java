package com.forohub.challenge.api.domain.models.respuesta;

import com.forohub.challenge.api.domain.models.topico.Topico;
import com.forohub.challenge.api.domain.models.usuario.perfil.Perfil;

public record DatoRegistroRespuesta(
        String mensaje,
        Long perfilId,
        Long topicoId
){}


