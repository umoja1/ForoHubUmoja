package com.forohub.challenge.api.domain.models.usuario.users;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AutenticacionUsuarioDto(

        String login,

        String password
) {
}
