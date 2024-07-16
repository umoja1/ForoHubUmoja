package com.forohub.challenge.api.domain.services.iservices;

import com.forohub.challenge.api.domain.models.usuario.users.DatosRegistroUsuario;
import com.forohub.challenge.api.domain.models.usuario.users.DatosRespuestaRegistroUsuario;

public interface IRegistroService {
    DatosRespuestaRegistroUsuario registroUsuario(DatosRegistroUsuario datosUsuario);
}
