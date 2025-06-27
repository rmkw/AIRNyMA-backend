package com.forms.backend.entitys.fuentes_identificacion;

import lombok.Data;
@Data
public class UpdateFiEconomicasCapDTO {
    private String fuente;
    private String acronimo;
    private String linkFuente;
    
    private String anioEvento;
    private String comentario;
    private Integer responsableActualizacion;
}
