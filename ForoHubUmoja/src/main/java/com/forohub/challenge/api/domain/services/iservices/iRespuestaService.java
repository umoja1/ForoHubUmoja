package com.forohub.challenge.api.domain.services.iservices;

import com.forohub.challenge.api.domain.models.respuesta.DatoRegistroRespuesta;
import com.forohub.challenge.api.domain.models.respuesta.DatosRespuesta;
import com.forohub.challenge.api.domain.models.respuesta.DatosRespuestaPorId;
import com.forohub.challenge.api.domain.models.respuesta.DatosRespuestaRegistro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface iRespuestaService {
    Page<DatosRespuesta> obtenerRespuestas(Pageable pagina);

    DatosRespuestaRegistro registrarRespuesta(DatoRegistroRespuesta datos);

    DatosRespuestaPorId obtenerRespuestaPorId(Long id);

    void eliminarRespuesta(Long id);
}
