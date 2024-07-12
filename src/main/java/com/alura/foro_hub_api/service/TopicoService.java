package com.alura.foro_hub_api.service;

import com.alura.foro_hub_api.domain.topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosDetalleTopico registrarTopico(DatosRegistroTopico datosRegistroTopico) {
        // Valida si el topico ya existe
        if (topicoRepository.existsByTitulo(datosRegistroTopico.titulo()) && topicoRepository.existsByMensaje(datosRegistroTopico.mensaje())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Éste tópico ya existe");
        }
        var Topico = new Topico(datosRegistroTopico);
        topicoRepository.save(Topico);

        return new DatosDetalleTopico(Topico);
    }

    public DatosTopicoConRespuestas detallarTopico(Long id) {
        return new DatosTopicoConRespuestas(validarExistenciaTopico(id));
    }

    public DatosDetalleTopico actualizarTopico(Long id, DatosRegistroTopico datosActualizacionTopico) {
        var topico = validarExistenciaTopico(id);
        topico.setAutor(datosActualizacionTopico.autor());
        topico.setTitulo(datosActualizacionTopico.titulo());
        topico.setMensaje(datosActualizacionTopico.mensaje());
        topico.setCurso(datosActualizacionTopico.curso());

        topicoRepository.save(topico);

        return new DatosDetalleTopico(topico);
    }

    public void eliminarTopico(Long id) {
        var topico = validarExistenciaTopico(id);
        topicoRepository.delete(topico);
    }

    public Topico validarExistenciaTopico(Long id) {
        var topicoOptional = topicoRepository.findByIdWithRespuestas(id);
        if (topicoOptional.isPresent()) {
            return topicoOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Éste tópico no existe");
        }
    }



}
