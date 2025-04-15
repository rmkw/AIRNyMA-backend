package com.forms.backend.entitys.fuentes_identificacion;

import lombok.Data;

@Data
public class CreateFiEconomicasCapDTO {
    private String idPp;
    private String fuente;
    private String linkFuente;
    
    private String anioEvento;
    private String comentario;
    private Integer responsableRegister;
}
