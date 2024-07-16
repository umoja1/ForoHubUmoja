package com.forohub.challenge.api.domain.models.usuario.users;

import com.forohub.challenge.api.domain.models.categoria.Roles;

public record DatosRegistroUsuario(

        Long id,

        String login,

        String password,

        Roles rol
) {

}
