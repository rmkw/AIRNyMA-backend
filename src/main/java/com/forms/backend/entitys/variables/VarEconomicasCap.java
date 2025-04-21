package com.forms.backend.entitys.variables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "var_economicas_cap")
@Getter
@Setter
public class VarEconomicasCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variable_unique")
    private Long idUnique;

    @Column(name = "id_variable", nullable = false)
    private String idVariable;

    @Column(name = "id_fuente", nullable = false)
    private Integer idFuente;

    @Column(name = "id_pp", nullable = false)
    private String idPp;

    @Column(name = "nombre_variable", nullable = false)
    private String nombreVariable;

    @Column(name = "defi_var")
    private String definicionVar;

    @Column(name = "link_var")
    private String linkVar;

    @Column(name = "comentario_var")
    private String comentarioVar;

    @Column(name = "var_serie_anio")
    private String varSerieAnio;

    @Column(name = "alineacion_mdea")
    private Boolean alineacionMdea;

    @Column(name = "alineacion_ods")
    private Boolean alineacionOds;

    @Column(name = "responsable_register", nullable = false)
    private Integer responsableRegister;

    @Column(name = "responsable_actualizacion")
    private Integer responsableActualizacion;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
