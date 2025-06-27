package com.forms.backend.entitys.variables;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.forms.backend.entitys.captura_relationVarWhitMDEA.RelationVarWhitMDEA;
import com.forms.backend.entitys.captura_relationVarWhitODS.RelationVarWhit_ODS;
import com.forms.backend.entitys.tema_cobertura_nece.TemaCobNec;

@Getter
@Setter
public class VaryRelationsDTO {
    private String idVariableCaracterizada; // Nuevo ID que se usa como PK

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

    // Relaciones
    private List<RelationVarWhitMDEA> mdeas;
    private List<RelationVarWhit_ODS> ods;
    private List<TemaCobNec> pertinencia;

}
