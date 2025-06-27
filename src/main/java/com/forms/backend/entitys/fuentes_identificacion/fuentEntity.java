package com.forms.backend.entitys.fuentes_identificacion;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fuentes", schema = "seleccion_variables")
@Getter
@Setter
public class fuentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fuente")
    private Integer idFuente;

    @Column(name = "acronimo", nullable = false)
    private String acronimo;

    @Column(name = "fuente", nullable = false)
    private String fuente;

    @Column(name = "url")
    private String url;

    @Column(name = "edicion")
    private String edicion;

    @Column(name = "comentario_s")
    private String comentario;

    @Column(name = "responsable_register", nullable = false)
    private Integer responsableRegister;

    @Column(name = "responsable_actualizacion")
    private Integer responsableActualizacion;
}
