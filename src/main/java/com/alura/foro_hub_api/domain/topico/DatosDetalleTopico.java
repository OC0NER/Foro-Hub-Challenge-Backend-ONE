package com.alura.foro_hub_api.domain.topico;

import com.alura.foro_hub_api.domain.respuesta.DatosRespuesta;

import java.util.Set;
import java.util.stream.Collectors;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String autor,
        String mensaje,
        Curso curso,
        String fechaCreacion,
        Integer CantidadRespuestas,
        String estado
) {

    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getAutor(),
                topico.getMensaje(), topico.getCurso(), topico.getFechaCreacion().toString(),
                topico.getCantidadRespuestas(), topico.getEstado()
                );
    }
}
