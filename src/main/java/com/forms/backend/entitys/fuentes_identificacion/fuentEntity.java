package com.forms.backend.entitys.fuentes_identificacion;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fuentes", schema = "production")
@Data
public class fuentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuente;
    private String idPp;
    private String fuente;
    private String linkFuente;
    
    private String anioEvento;
    private String comentario;
    private Boolean isactive = true;
    private Integer responsableRegister;
    private Integer responsableActualizacion;
}
