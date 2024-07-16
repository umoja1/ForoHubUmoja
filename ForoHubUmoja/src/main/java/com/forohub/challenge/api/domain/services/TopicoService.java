package com.forohub.challenge.api.domain.services;

import com.forohub.challenge.api.domain.models.categoria.Curso;
import com.forohub.challenge.api.domain.models.topico.ActualizarTopicoDto;
import com.forohub.challenge.api.domain.models.topico.Topico;
import com.forohub.challenge.api.domain.models.topico.TopicoDto;
import com.forohub.challenge.api.domain.repository.PerfilRepositorio;
import com.forohub.challenge.api.domain.repository.TopicoRepositorio;
import com.forohub.challenge.api.domain.services.iservices.ITopicoService;
import com.forohub.challenge.api.domain.validaciones.ivalidaciones.iValidadorTopico;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService implements ITopicoService {

    @Autowired
    private TopicoRepositorio topicoRepositorio;

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    @Autowired
    private List<iValidadorTopico> validadorTopicos;

    @Override
    public List<TopicoDto> listarTopicos() {
        var topicos = topicoRepositorio.findAll().stream()
                .map(t-> new TopicoDto(t))
                .collect(Collectors.toList());
        validadorTopicos.forEach(v-> v.listaVacia(topicos));
        return  topicos;
    }

    @Override
    public Page<TopicoDto> paginarTopicos(Pageable pageable) {

        Page<Topico> topicos = topicoRepositorio.findByActivoTrue(pageable);
        validadorTopicos.forEach(v-> v.validarPagina(topicos));
        return topicos.map(TopicoDto::new);
    }

    @Override
    public TopicoDto crearTopico(Topico topico) throws BadRequestException {

        boolean tituloExiste = topicoRepositorio.existsByTitulo(topico.getTitulo());
        boolean mensajeExiste = topicoRepositorio.existsByMensaje(topico.getMensaje());

        validadorTopicos.forEach(v-> v.topicoExiste(tituloExiste, mensajeExiste));

        boolean perfilId = perfilRepositorio.existsById(topico.getPerfilId().getId());

        validadorTopicos.forEach(v-> v.idPerfilNoEncontrado(perfilId));

        topicoRepositorio.save(topico);

        TopicoDto topicoRespuesta = new TopicoDto(topico.getId(),topico.getTitulo(),
                topico.getMensaje(), topico.getPerfilId().getNombre(),
                Curso.values().toString(),topico.getFechaCreacion());

        return topicoRespuesta;
    }

    @Override
    public TopicoDto listarPorId(Long id) {

        boolean topicoId = topicoRepositorio.existsById(id);
        validadorTopicos.forEach(v-> v.topicoIdNoexiste(topicoId));

        Optional<Topico> topico = topicoRepositorio.findById(id);

        return new TopicoDto(topico.get());
    }

    @Override
    public TopicoDto actualizarTopico(ActualizarTopicoDto body) {

        boolean topicoId = topicoRepositorio.existsById(body.id());
        validadorTopicos.forEach(v-> v.topicoIdNoexiste(topicoId));

        Optional<Topico> topico = topicoRepositorio.findById(body.id());

        topico.get().setFechaCreacion(crearFormatoFecha());
        topico.get().actualizarDatos(body);

        return new TopicoDto(topico.get());
    }

    @Override
    public void borrarTopico(Long id) {

        boolean topicoId = topicoRepositorio.existsById(id);
        validadorTopicos.forEach(v-> v.topicoIdNoexiste(topicoId));

        Optional<Topico> topico = topicoRepositorio.findById(id);
        topico.get().eliminarTopico();
        topicoRepositorio.save(topico.get());
    }

    public String crearFormatoFecha(){

        LocalDateTime fechaCreacion = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = fechaCreacion.format(formatter);

        return fechaFormateada;

    }


}
