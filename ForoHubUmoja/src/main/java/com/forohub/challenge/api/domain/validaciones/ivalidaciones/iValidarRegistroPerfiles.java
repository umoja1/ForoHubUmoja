package com.forohub.challenge.api.domain.validaciones.ivalidaciones;

import com.forohub.challenge.api.domain.models.usuario.perfil.DatosCrearPerfil;
import com.forohub.challenge.api.domain.models.usuario.users.Usuario;

import java.util.List;

public interface iValidarRegistroPerfiles {
    void validarDatosEntrada(DatosCrearPerfil datos);

    void validarId(List<Usuario> usuarios, Long id);
}
