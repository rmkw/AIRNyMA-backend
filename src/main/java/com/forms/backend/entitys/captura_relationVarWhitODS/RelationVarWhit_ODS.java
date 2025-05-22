package com.forms.backend.entitys.captura_relationVarWhitODS;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "relacion_ods", schema = "production")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelationVarWhit_ODS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unique")
    private Long idUnique;

    @Column(name = "id_variable_unique", nullable = false)
    private Long idVariableUnique;

    @Column(name = "id_variable", nullable = false)
    private String idVariable;

    @Column(name = "id_var_caracterizada")
    private String idVarCaracterizada;

    @Column(name = "id_obj")
    private String idObj;

    @Column(name = "id_meta")
    private String idMeta;

    @Column(name = "id_indicador")
    private String idIndicador;

    @Column(name = "nivel_contribucion")
    private String nivelContribucion;

    @Column(name = "comentario_relacion_ODS")
    private String comentarioRelacionODS;
}
