package com.alura.foro_hub_api.service;

import com.alura.foro_hub_api.domain.respuesta.DatosRespuesta;
import com.alura.foro_hub_api.domain.respuesta.Respuesta;
import com.alura.foro_hub_api.domain.respuesta.RespuestaRepository;
import com.alura.foro_hub_api.domain.topico.Topico;
import com.alura.foro_hub_api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public void registrarRespuesta(Long id, DatosRespuesta datosRespuesta){

        // Buscar el Topico por id
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topico no encontrado"));
        topico.setCantidadRespuestas(topico.getCantidadRespuestas() + 1);

        // Crear la Respuesta con el Topico encontrado
        Respuesta respuesta = new Respuesta(datosRespuesta);
        respuesta.setTopico(topico);

        respuestaRepository.save(respuesta);

    }
}
