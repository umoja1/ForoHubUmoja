package com.forohub.challenge.api.domain.validaciones.ivalidaciones;

import com.forohub.challenge.api.domain.models.usuario.perfil.DatosActualizarPerfil;
import com.forohub.challenge.api.domain.models.usuario.perfil.Perfil;

import java.util.List;

public interface iValidadorActualizacionPerfiles {
    void validarId(List<Perfil> perfiles, Long id);


}
