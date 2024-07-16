package com.forohub.challenge.api.domain.services.iservices;

import com.forohub.challenge.api.domain.models.usuario.perfil.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPerfilService {
    DatosRespuestaPerfil crearPerfil(DatosCrearPerfil datos);

    DatosRespuestaActualizacionPerfil actualizarPerfil(DatosActualizarPerfil datos, Long id);

    DatosRespuestaPerfil obtenerPerfil(Long id);


    Page<DatosRespuestaPerfil> paginarPerfiles(Pageable pagina);


    void deshabilitarPerfil(Long id);
}
