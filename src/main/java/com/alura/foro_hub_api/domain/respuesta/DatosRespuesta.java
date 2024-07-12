package com.alura.foro_hub_api.domain.respuesta;

import jakarta.validation.constraints.NotNull;

public record DatosRespuesta(
        @NotNull
        String autor,
        @NotNull
        String mensaje
) {
    public DatosRespuesta(Respuesta respuesta) {
        this(respuesta.getAutor(), respuesta.getMensaje());
    }
}
