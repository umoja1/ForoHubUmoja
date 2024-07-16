package com.forohub.challenge.api.domain.validaciones;

import com.forohub.challenge.api.domain.validaciones.ivalidaciones.iValidarRegistroUsuarios;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

@Component
public class ValidarRegistroUsuarios implements iValidarRegistroUsuarios {

    @Override
    public void usuarioExiste(boolean usuarioExiste) {
        if (usuarioExiste){
            throw new IllegalArgumentException("ERROR USERNAME: El nombre de usuario ingresado ya existe");
        }
    }


}
