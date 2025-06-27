

package com.forms.backend.entitys.fuentes_identificacion;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuenteConConteoDTO {
    private Integer idFuente;
    private String acronimo;
    private String fuente;
    private String linkFuente;
    private String anioEvento;
    private String comentario;
    private Boolean isactive;
    private Integer responsableRegister;
    private Integer responsableActualizacion;
    private Long totalVariables; // <--- nuevo campo
}
