package com.forohub.challenge.api.domain.models.usuario.users;

import com.forohub.challenge.api.domain.models.categoria.Roles;

public record DatosRespuestaRegistroUsuario(

        Long id,

        String login,

        Roles rol
) {
}
