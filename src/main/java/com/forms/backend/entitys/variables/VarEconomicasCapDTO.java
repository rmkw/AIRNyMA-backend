package com.forms.backend.entitys.variables;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VarEconomicasCapDTO {
    
    private String idVariableCaracterizada; // obligatorio si tú lo generas desde frontend

    private String idVariable;

    private Integer idFuente;

    private String acronimo;

    private String nombreVariable;

    private String definicionVar;

    private String linkVar;

    private String comentarioVar;

    private Boolean alineacionMdea;

    private Boolean alineacionOds;

    private Integer responsableRegister;

    private Integer responsableActualizacion;
}
