package com.forms.backend.entitys.variables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "variables", schema = "seleccion_variables")
@Getter
@Setter
public class VarEconomicasCap {
    @Id
    @Column(name = "id_variable_caracterizada")
    private String idVariableCaracterizada;

    @Column(name = "id_variable", nullable = false)
    private String idVariable;

    @Column(name = "id_fuente", nullable = false)
    private Integer idFuente;

    @Column(name = "acronimo", nullable = false)
    private String acronimo; // <- este reemplaza al antiguo "acronimo"

    @Column(name = "nombre", nullable = false)
    private String nombreVariable;

    @Column(name = "definicion")
    private String definicionVar;

    @Column(name = "url")
    private String linkVar;

    @Column(name = "comentario_s")
    private String comentarioVar;

    @Column(name = "alineacion_mdea")
    private Boolean alineacionMdea;

    @Column(name = "alineacion_ods")
    private Boolean alineacionOds;

    @Column(name = "responsable_register", nullable = false)
    private Integer responsableRegister;

    @Column(name = "responsable_actualizacion")
    private Integer responsableActualizacion;
}
