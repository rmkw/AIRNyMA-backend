package com.forms.backend.services.variables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.forms.backend.entitys.variables.VarEconomicasCap;
import com.forms.backend.entitys.variables.VarEconomicasCapDTO;
import com.forms.backend.repository.variables.VarEconomicasCapRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VarEconomicasCapService {
    @Autowired
    private VarEconomicasCapRepository repository;

    public List<VarEconomicasCapDTO> getAllActive() {
        return repository.findByIsActiveTrue()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private VarEconomicasCapDTO convertToDTO(VarEconomicasCap entity) {
        VarEconomicasCapDTO dto = new VarEconomicasCapDTO();
        dto.setId(entity.getId());
        dto.setIdVariable(entity.getIdVariable());
        dto.setIdFuente(entity.getIdFuente());
        dto.setIdPp(entity.getIdPp());
        dto.setNombreVariable(entity.getNombreVariable());
        dto.setDefinicionVar(entity.getDefinicionVar());
        dto.setLinkVar(entity.getLinkVar());
        dto.setComentarioVar(entity.getComentarioVar());
        dto.setVarSerieAnio(entity.getVarSerieAnio());
        dto.setAlineacionMdea(entity.getAlineacionMdea());
        dto.setAlineacionOds(entity.getAlineacionOds());
        dto.setResponsableRegister(entity.getResponsableRegister());
        dto.setResponsableActualizacion(entity.getResponsableActualizacion());
        return dto;
    }

    public VarEconomicasCapDTO create(VarEconomicasCapDTO dto) {
            // Validar si ya existe una relación con el mismo idVariable e idFuente
        boolean exists = repository.existsByIdVariableAndIdFuente(dto.getIdVariable(), dto.getIdFuente());
        if (exists) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, // Código 409 Conflict (mejor que 403 en este caso)
                "Ya existe una variable con ese idVariable y esa fuente (idFuente)"
            );
        }
        
        VarEconomicasCap entity = convertToEntity(dto);
            entity.setIsActive(true); // Por defecto, el registro es activo
            VarEconomicasCap savedEntity = repository.save(entity);
            return convertToDTO(savedEntity);
    }

    private VarEconomicasCap convertToEntity(VarEconomicasCapDTO dto) {
        VarEconomicasCap entity = new VarEconomicasCap();
        entity.setIdVariable(dto.getIdVariable());
        entity.setIdFuente(dto.getIdFuente());
        entity.setIdPp(dto.getIdPp());
        entity.setNombreVariable(dto.getNombreVariable());
        entity.setDefinicionVar(dto.getDefinicionVar());
        entity.setLinkVar(dto.getLinkVar());
        entity.setComentarioVar(dto.getComentarioVar());
        entity.setVarSerieAnio(dto.getVarSerieAnio());
        entity.setAlineacionMdea(dto.getAlineacionMdea());
        entity.setAlineacionOds(dto.getAlineacionOds());
        entity.setResponsableRegister(dto.getResponsableRegister());
        entity.setResponsableActualizacion(dto.getResponsableActualizacion());
        return entity;
    }
    
    public List<VarEconomicasCap> getByResponsableAndFuente(Integer responsableRegister, Integer idFuente) {
        return repository.findByResponsableRegisterAndIdFuenteAndIsActiveTrue(responsableRegister, idFuente);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Variable no encontrada");
        }
        repository.deleteById(id);
    }
}
