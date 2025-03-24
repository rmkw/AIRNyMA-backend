package com.forms.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forms.backend.entitys.ppEcoDTO;
import com.forms.backend.services.ppEcoService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/ppeco")
public class ppEcoControllers {

    private final ppEcoService service;

    public ppEcoControllers(ppEcoService service){
        this.service = service;
    }

    @GetMapping
    public List<ppEcoDTO> obtenerTodos() {
        return service.obtenerTodos();
    }
    
    @GetMapping("/{id}")
    public Optional<ppEcoDTO> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/acronimo/{acronimo}")
    public Optional<ppEcoDTO> obtenerPorAcronimo(@PathVariable String acronimo) {
        return service.obtenerPorAcronimo(acronimo);
    }

    @PatchMapping("/{id}/comentario")
    public ResponseEntity<ppEcoDTO> actualizarComentario(
            @PathVariable Long id,
            @RequestBody Map<String, String> requestBody) {

        System.out.println(" Recibida petición PATCH para actualizar comentario");
        System.out.println(" ID recibido: " + id);
        System.out.println(" Cuerpo de la petición: " + requestBody);

        String nuevoComentario = requestBody.get("comentarioPp");

        System.out.println(" Comentario a actualizar: " + nuevoComentario);

        ppEcoDTO procesoActualizado = service.actualizarComentario(id, nuevoComentario);

        return ResponseEntity.ok(procesoActualizado);
    }
}
