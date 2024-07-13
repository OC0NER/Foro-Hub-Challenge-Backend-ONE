package com.alura.foro_hub_api.controller;

import com.alura.foro_hub_api.domain.respuesta.DatosRespuesta;
import com.alura.foro_hub_api.domain.topico.*;
import com.alura.foro_hub_api.service.TopicoService;
import com.alura.foro_hub_api.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping
    public ResponseEntity<DatosDetalleTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        var response = topicoService.registrarTopico(datosRegistroTopico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(url).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopico>> listarTopicos(@PageableDefault(size = 5, sort = {"fechaCreacion"}) Pageable paginacion) {
        var page = topicoRepository.findAll(paginacion).map(DatosDetalleTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosTopicoConRespuestas> detallarTopico(@PathVariable Long id) {
        return ResponseEntity.ok().body(topicoService.detallarTopico(id));
    }

    @PostMapping("/{id}/respuesta")
    public ResponseEntity<DatosRespuesta> responderTopico(@PathVariable Long id, @RequestBody @Valid DatosRespuesta datosRespuesta) {
        respuestaService.registrarRespuesta(id, datosRespuesta);
        return ResponseEntity.ok(datosRespuesta);

    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datosActualizarTopico) {
        var response = topicoService.actualizarTopico(id, datosActualizarTopico);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

}
