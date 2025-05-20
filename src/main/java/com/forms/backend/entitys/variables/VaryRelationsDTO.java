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
    private Long idUnique;
    private String idVariable;
    private Integer idFuente;
    private String idPp;
    private String nombreVariable;
    private String definicionVar;
    private String linkVar;
    private String comentarioVar;
    private String varSerieAnio;
    private Boolean alineacionMdea;
    private Boolean alineacionOds;
    private Integer responsableRegister;
    private Integer responsableActualizacion;

    private List<RelationVarWhitMDEA> mdeas;
    private List<RelationVarWhit_ODS> ods;
    private List<TemaCobNec> pertinencia;

    public List<TemaCobNec> getPertinencia() {
        return pertinencia;
    }

    public void setPertinencia(List<TemaCobNec> pertinencia) {
        this.pertinencia = pertinencia;
    }

}
