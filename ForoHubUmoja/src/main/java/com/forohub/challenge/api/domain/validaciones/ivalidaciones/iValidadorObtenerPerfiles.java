package com.forohub.challenge.api.domain.validaciones.ivalidaciones;

import com.forohub.challenge.api.domain.models.usuario.perfil.Perfil;
import org.springframework.data.domain.Page;

public interface iValidadorObtenerPerfiles {
    void validarPerfiles(Page<Perfil> perfiles);
}
