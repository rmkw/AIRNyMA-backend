package com.forms.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.forms.backend.entitys.ppEcoDTO;
import com.forms.backend.repository.ppEcoRepo;

@Service
public class ppEcoService {

    private final ppEcoRepo repository;

    public ppEcoService(ppEcoRepo repository) {
        this.repository = repository; // Solo asigna el repositorio aquí
    }

    public List<ppEcoDTO> obtenerTodos() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "procesoProduccion"));
    }

    public Optional<ppEcoDTO> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<ppEcoDTO> obtenerPorAcronimo(String acronimo) {
        return repository.findByAcronimoProceso(acronimo);
    }

    public ppEcoDTO actualizarComentario(Long id, String comentarioPp) {
        System.out.println("Buscando proceso con ID: " + id);

        Optional<ppEcoDTO> optionalProceso = repository.findById(id);

        if (optionalProceso.isPresent()) {
            ppEcoDTO proceso = optionalProceso.get();
            System.out.println("Proceso encontrado: " + proceso);

            proceso.setComentarioPp(comentarioPp);
            System.out.println("Nuevo comentario asignado: " + comentarioPp);

            return repository.save(proceso);
        } else {
            System.out.println("Proceso no encontrado con ID: " + id);
            throw new RuntimeException("Proceso de Producción no encontrado con ID: " + id);
        }
    }
}
