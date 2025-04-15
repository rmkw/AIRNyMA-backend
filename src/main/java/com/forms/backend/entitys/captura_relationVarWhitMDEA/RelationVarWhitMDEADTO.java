package com.forms.backend.entitys.captura_relationVarWhitMDEA;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelationVarWhitMDEADTO {
    private Long id;
    private Long idVariableUnique;
    private String idVariable;
    private String idComponente;
    private String idSubcomponente;
    private String idTopico;
    private String idVariableMdeaPull;
    private String idEstadistico;
    private String nivelContribucion;
    private String comentarioRelacionMdea;
}
