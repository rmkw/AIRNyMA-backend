package com.forms.backend.entitys.captura_relationVarWhitODS;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class relationVarWhit_ods_DTO {
    private Long idUnique;

    private Long idVariableUnique;
    private String idVariable;
    private String idVarCaracterizada;

    private String idObj;
    private String idMeta;
    private String idIndicador;

    private String nivelContribucion;
    private String comentarioRelacionODS;
}
