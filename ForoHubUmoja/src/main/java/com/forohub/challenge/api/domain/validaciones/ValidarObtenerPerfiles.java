package com.forohub.challenge.api.domain.validaciones;

import com.forohub.challenge.api.domain.models.usuario.perfil.Perfil;
import com.forohub.challenge.api.domain.validaciones.ivalidaciones.iValidadorObtenerPerfiles;
import com.forohub.challenge.api.handler.NoContentException;
import org.springframework.data.domain.Page;

public class ValidarObtenerPerfiles implements iValidadorObtenerPerfiles {
    @Override
    public void validarPerfiles(Page<Perfil> perfiles) {
        if (perfiles.isEmpty()){
            throw new NoContentException("No hay perfiles para mostrar.");
        }
    }
}
