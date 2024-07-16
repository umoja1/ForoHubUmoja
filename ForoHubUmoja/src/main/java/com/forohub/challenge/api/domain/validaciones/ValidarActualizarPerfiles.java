package com.forohub.challenge.api.domain.validaciones;

import com.forohub.challenge.api.domain.models.usuario.perfil.DatosActualizarPerfil;
import com.forohub.challenge.api.domain.models.usuario.perfil.Perfil;

import com.forohub.challenge.api.domain.validaciones.ivalidaciones.iValidadorActualizacionPerfiles;
import com.forohub.challenge.api.handler.CustomNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidarActualizarPerfiles implements iValidadorActualizacionPerfiles {

    @Override
    public void validarId(List<Perfil> perfiles, Long id) {
        List<Long> idPerfiles = perfiles.stream().map(Perfil::getId).toList();
        boolean idExiste = idPerfiles.contains(id);
        if (!idExiste){
            throw new CustomNotFoundException("Id no encontrado.");

        }
    }


}
