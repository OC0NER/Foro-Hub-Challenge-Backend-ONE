package com.alura.foro_hub_api.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        String autor,
        String titulo,
        String mensaje,
        Curso curso,
        String estado
) {
}
