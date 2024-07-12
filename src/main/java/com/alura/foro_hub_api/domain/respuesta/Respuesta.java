package com.alura.foro_hub_api.domain.respuesta;

import com.alura.foro_hub_api.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_topico")
    private Topico topico;

    public Respuesta(DatosRespuesta datosRespuesta) {
        this.autor = datosRespuesta.autor();
        this.mensaje = datosRespuesta.mensaje();
        this.fechaCreacion = LocalDateTime.now();
    }

}
