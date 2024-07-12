package com.alura.foro_hub_api.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull
        String autor,
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        Curso curso)
{
}
