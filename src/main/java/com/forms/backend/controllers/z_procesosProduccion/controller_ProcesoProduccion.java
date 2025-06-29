package com.forms.backend.controllers.z_procesosProduccion;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.forms.backend.entitys.z_procesos_produccion.ProcesoProduccionDTO;
import com.forms.backend.entitys.z_procesos_produccion.z_procesos_produccion;
import com.forms.backend.services.z_procesoProduccion.service_pp;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/procesosP")
@RequiredArgsConstructor
public class controller_ProcesoProduccion {
    
    private final service_pp service;

    @GetMapping
    public List<z_procesos_produccion> getTodosLosProcesos(){
        return service.obtenerTodos();
    }

    @GetMapping("/buscar")
    public List<z_procesos_produccion> buscarPorunidad(@RequestParam("unidad_administrativa") String unidad){
        return service.obtenerPorunidad(unidad);
    }
    
    @PutMapping("/comentario/{acronimo}")
    public ResponseEntity<?> actualizarComentario(@PathVariable String acronimo,
            @RequestBody Map<String, String> comentario) {
        String nuevoComentario = comentario.get("comentario");
        service.actualizarComentario(acronimo, nuevoComentario);
        return ResponseEntity.ok(new ResponseMessage("Comentario actualizado correctamente"));
    }

    public class ResponseMessage {
        private String message;
        public ResponseMessage(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
    }

    @GetMapping("/unidad/{idUnidad}")
    public ResponseEntity<List<ProcesoProduccionDTO>> obtenerPorIdUnidad(@PathVariable Integer idUnidad) {
        List<ProcesoProduccionDTO> procesos = service.obtenerPorIdUnidadConConteo(idUnidad);
        return ResponseEntity.ok(procesos);
    }


    
}
