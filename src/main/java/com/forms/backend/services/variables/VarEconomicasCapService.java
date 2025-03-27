package com.forms.backend.services.variables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        dto.setAlineacionMdea(entity.getAlineacionMdea());
        dto.setAlineacionOds(entity.getAlineacionOds());
        dto.setResponsableRegister(entity.getResponsableRegister());
        dto.setResponsableActualizacion(entity.getResponsableActualizacion());
        return dto;
    }

    public VarEconomicasCapDTO create(VarEconomicasCapDTO dto) {
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
        entity.setAlineacionMdea(dto.getAlineacionMdea());
        entity.setAlineacionOds(dto.getAlineacionOds());
        entity.setResponsableRegister(dto.getResponsableRegister());
        entity.setResponsableActualizacion(dto.getResponsableActualizacion());
        return entity;
    }
}
