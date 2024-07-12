package com.alura.foro_hub_api.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long>{
    Boolean existsByTitulo(String titulo);
    Boolean existsByMensaje(String mensaje);

    @Query("SELECT t FROM Topico t LEFT JOIN FETCH t.respuestas WHERE t.id = :id")
    Optional<Topico> findByIdWithRespuestas(Long id);

}
