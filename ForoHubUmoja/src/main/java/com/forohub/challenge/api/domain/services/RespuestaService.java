package com.forohub.challenge.api.domain.services;

import com.forohub.challenge.api.domain.models.respuesta.*;
import com.forohub.challenge.api.domain.models.topico.Topico;
import com.forohub.challenge.api.domain.models.usuario.perfil.Perfil;
import com.forohub.challenge.api.domain.repository.PerfilRepositorio;
import com.forohub.challenge.api.domain.repository.RespuestaRepositorio;
import com.forohub.challenge.api.domain.repository.TopicoRepositorio;
import com.forohub.challenge.api.domain.services.iservices.iRespuestaService;
import com.forohub.challenge.api.domain.validaciones.ivalidaciones.iValidarRegistroRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService implements iRespuestaService {

    private final RespuestaRepositorio respuestaRepositorio;
    private final List<iValidarRegistroRespuesta> validarRegistroRespuestas;
    private final PerfilRepositorio perfilRepositorio;
    private  final TopicoRepositorio topicoRepositorio;

    @Autowired
    public  RespuestaService(
            RespuestaRepositorio respuestaRepositorio,
            List<iValidarRegistroRespuesta> validarRegistroRespuestas,
            PerfilRepositorio perfilRepositorio,
            TopicoRepositorio topicoRepositorio)
    {
        this.respuestaRepositorio = respuestaRepositorio;
        this.validarRegistroRespuestas = validarRegistroRespuestas;
        this.perfilRepositorio = perfilRepositorio;
        this.topicoRepositorio = topicoRepositorio;
    }

    @Override
    public Page<DatosRespuesta> obtenerRespuestas(Pageable pagina) {

        Page<Respuesta> respuestas = respuestaRepositorio.findByActivoTrue(pagina);
        validarRegistroRespuestas.forEach(v->v.existenRespuestas(respuestas));

        return respuestas
                .map(r->new DatosRespuesta(r.getId(),r.getMensaje(),r.getFechaCreacion(),
                        new TopicoRespuestaDto(r.getTopicoId().getId(),r.getTopicoId().getTitulo(),r.getTopicoId().getMensaje(),
                        r.getTopicoId().getPerfilId().getNombre(),r.getTopicoId().getFechaCreacion())));
    }

    @Override
    public DatosRespuestaRegistro registrarRespuesta(DatoRegistroRespuesta datos) {
        validarRegistroRespuestas.forEach(v->v.existeId(datos.perfilId()));
        validarRegistroRespuestas.forEach(v->v.existeId(datos.topicoId()));
        validarRegistroRespuestas.forEach(v->v.existenDatos(datos));

        Optional<Perfil> perfil = perfilRepositorio.findById(datos.perfilId());
        Optional<Topico> topico = topicoRepositorio.findById(datos.topicoId());

        validarRegistroRespuestas.forEach(v->v.perfilExiste(perfil));
        validarRegistroRespuestas.forEach(v->v.topicoExiste(topico));

        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje(datos.mensaje());
        respuesta.setPerfilId(perfil.get());
        respuesta.setTopicoId(topico.get());
        respuesta.setFechaCreacion(obtenerFechaActual());
        respuesta.activarPerfil();

        respuestaRepositorio.save(respuesta);

        return new DatosRespuestaRegistro(respuesta.getId(), respuesta.getTopicoId().getTitulo(),respuesta.getMensaje(),
                respuesta.getFechaCreacion());
    }

    @Override
    public DatosRespuestaPorId obtenerRespuestaPorId(Long id) {
        validarRegistroRespuestas.forEach(v->v.existeId(id));

        boolean existeRespuesta = respuestaRepositorio.existsById(id);
        validarRegistroRespuestas.forEach(v->v.existeRespuestaEnDb(existeRespuesta));

        Optional<Respuesta> respuesta = respuestaRepositorio.findById(id);

        return new DatosRespuestaPorId(respuesta.get().getId(),respuesta.get().getMensaje(),
                                        respuesta.get().getTopicoId().getTitulo(),respuesta.get().getTopicoId().getCurso(),
                                        respuesta.get().getTopicoId().getPerfilId().getNombre(),
                                        respuesta.get().getTopicoId().getId(),respuesta.get().getFechaCreacion());

    }

    @Override
    public void eliminarRespuesta(Long id) {

        validarRegistroRespuestas.forEach(v->v.existeId(id));
        Optional<Respuesta> respuesta = respuestaRepositorio.findById(id);
        validarRegistroRespuestas.forEach(v->v.respuestaExiste(respuesta));

        respuestaRepositorio.delete(respuesta.get());
    }

    public String obtenerFechaActual(){

        LocalDateTime fechaCreacion = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = fechaCreacion.format(formatter);

        return fechaFormateada;

    }
}
