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
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        var response = topicoService.registrarTopico(datosRegistroTopico);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopico>> listarTopicos(@PageableDefault(size = 5, sort = {"fechaCreacion"}) Pageable paginacion) {
        var page = topicoRepository.findAll(paginacion).map(DatosDetalleTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarTopico(@PathVariable Long id) {
        return ResponseEntity.ok().body(topicoService.detallarTopico(id));
    }

    @PostMapping("/{id}/respuesta")
    public ResponseEntity responderTopico(@PathVariable Long id, @RequestBody @Valid DatosRespuesta datosRespuesta) {
        respuestaService.registrarRespuesta(id, datosRespuesta);
        return ResponseEntity.ok(datosRespuesta);

    }

    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody DatosRegistroTopico datosActualizacionTopico) {
        var response = topicoService.actualizarTopico(id, datosActualizacionTopico);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

}
