package com.alura.foro_hub_api.domain.topico;

import com.alura.foro_hub_api.domain.respuesta.Respuesta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String titulo;
    private String mensaje;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private LocalDateTime fechaCreacion;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Respuesta> respuestas = new HashSet<>();
    @Setter
    private Integer cantidadRespuestas;
    private String estado;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.autor = datosRegistroTopico.autor();
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.curso = datosRegistroTopico.curso();
        this.fechaCreacion = LocalDateTime.now();
        this.cantidadRespuestas = 0;
        this.estado = "ABIERTO";
    }
}
