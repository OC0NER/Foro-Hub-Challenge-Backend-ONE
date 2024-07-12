package com.alura.foro_hub_api.domain.topico;

import com.alura.foro_hub_api.domain.respuesta.DatosRespuesta;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;

import java.util.Set;
import java.util.stream.Collectors;

public record DatosTopicoConRespuestas(
        String titulo,
        String autor,
        String mensaje,
        Curso curso,
        String fechaCreacion,
        Set<DatosRespuesta> respuestas,
        Integer cantidadRespuestas,
        String estado
) {
    public DatosTopicoConRespuestas(Topico topico) {
        this(topico.getTitulo(), topico.getAutor(), topico.getMensaje(),
                topico.getCurso(), topico.getFechaCreacion().toString(),
                topico.getRespuestas().stream()
                        .map(DatosRespuesta::new)
                        .collect(Collectors.toSet()),
                topico.getCantidadRespuestas(), topico.getEstado()
        );
    }
}
