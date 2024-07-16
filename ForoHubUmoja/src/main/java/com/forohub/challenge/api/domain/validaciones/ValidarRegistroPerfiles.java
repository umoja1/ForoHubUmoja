package com.forohub.challenge.api.domain.validaciones;

import com.forohub.challenge.api.domain.models.usuario.perfil.DatosCrearPerfil;
import com.forohub.challenge.api.domain.models.usuario.users.Usuario;
import com.forohub.challenge.api.domain.validaciones.ivalidaciones.iValidarRegistroPerfiles;
import com.forohub.challenge.api.handler.CustomNotFoundException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class ValidarRegistroPerfiles implements iValidarRegistroPerfiles {
    @Override
    public void validarDatosEntrada(DatosCrearPerfil datos) {
        if(datos == null){
            throw new InvalidDataAccessApiUsageException("ERROR EN LOS DATOS: Esta ingresando valores nulos");

        }
    }

    @Override
    public void validarId(List<Usuario> usuarios, Long id) {
        List<Long> usuariosIds = usuarios.stream().map(Usuario::getId).toList();
        boolean idExiste = usuariosIds.contains(id);

        if (!idExiste){
            throw new CustomNotFoundException("Id no encontrado.");
        }

    }
}
