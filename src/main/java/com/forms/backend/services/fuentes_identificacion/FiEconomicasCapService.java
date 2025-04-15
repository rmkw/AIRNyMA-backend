package com.forms.backend.services.fuentes_identificacion;


import com.forms.backend.entitys.fuentes_identificacion.CreateFiEconomicasCapDTO;
import com.forms.backend.entitys.fuentes_identificacion.UpdateFiEconomicasCapDTO;
import com.forms.backend.entitys.fuentes_identificacion.fuentEntity;
import com.forms.backend.repository.fuentes_identificacion.FiEconomicasCapRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FiEconomicasCapService {
    @Autowired
    private FiEconomicasCapRepository repository;

    public List<fuentEntity> getAll() {
        return repository.findAllByOrderByIdFuenteAsc();
    }

    public ResponseEntity<Map<String, Object>> getById(Integer id) {
    Optional<fuentEntity> optionalFuente = repository.findById(id);

    if (optionalFuente.isPresent()) {
        return ResponseEntity.ok(Map.of(
            "message", "Fuente encontrada",
            "fuente", optionalFuente.get()
        ));
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
            "message", "La fuente no existe"
        ));
    }
}

   

    public List<fuentEntity> getByUser(Integer idUsuario) {
        return repository.findByResponsableRegisterOrderByIdFuenteAsc(idUsuario);
    }

    public fuentEntity create(CreateFiEconomicasCapDTO dto) {
        fuentEntity entity = new fuentEntity();
        entity.setIdPp(dto.getIdPp());
        entity.setFuente(dto.getFuente());
        entity.setLinkFuente(dto.getLinkFuente());
        
        entity.setAnioEvento(dto.getAnioEvento());
        entity.setComentario(dto.getComentario());
        entity.setResponsableRegister(dto.getResponsableRegister());
        return repository.save(entity);
    }

    public fuentEntity update(Integer id, UpdateFiEconomicasCapDTO dto) {
        Optional<fuentEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            fuentEntity entity = optional.get();
            entity.setIdPp(dto.getIdPp());
            entity.setFuente(dto.getFuente());
            entity.setLinkFuente(dto.getLinkFuente());
            // entity.setLinkAccesoFuente(dto.getLinkAccesoFuente());
            entity.setAnioEvento(dto.getAnioEvento());
            entity.setComentario(dto.getComentario());
            entity.setResponsableActualizacion(dto.getResponsableActualizacion());
            return repository.save(entity);
        }
        return null;
    }

    @Transactional
    public Map<String, Object> deactivateRecord(Integer id) {
        Optional<fuentEntity> optionalRecord = repository.findById(id);
        
        if (optionalRecord.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado");
        }

        fuentEntity record = optionalRecord.get();
        if (!record.getIsactive()) {
            return Map.of("message", "El registro ya está desactivado");
        }

        record.setIsactive(false);
        repository.save(record);

        return Map.of(
            "message", "Registro desactivado correctamente",
            "id", record.getIdFuente()
        );
    }
}
