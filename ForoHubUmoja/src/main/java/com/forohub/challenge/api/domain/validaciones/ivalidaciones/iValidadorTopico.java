package com.forohub.challenge.api.domain.validaciones.ivalidaciones;

import com.forohub.challenge.api.domain.models.topico.TopicoDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface iValidadorTopico {

    public void validarPagina(Page datos);

    public void topicoExiste(boolean titulo, boolean mensaje);

    public void idPerfilNoEncontrado(boolean id);

    void topicoIdNoexiste(boolean topicoId);

    void listaVacia(List<TopicoDto> topicos);
}

