package com.forms.backend.entitys.fuentes_identificacion;

import lombok.Data;

@Data
public class FiEconomicasCapDTO {
    private Integer idFuente;
    private String acronimo;
    private String fuente;
    private String linkFuente;
    
    private String anioEvento;
    private String comentario;
    private Boolean isactive;
    private Integer responsableRegister;
    private Integer responsableActualizacion;
}
