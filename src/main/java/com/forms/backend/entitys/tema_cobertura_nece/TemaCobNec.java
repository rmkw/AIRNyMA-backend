package com.forms.backend.entitys.tema_cobertura_nece;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pertinencia", schema = "production")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemaCobNec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unique")
    private Long id;

    @Column(name = "Tema_Cob_Nec", nullable = false)
    private String temaCobNec;

    @Column(name = "Nivel_Contribucion")
    private String nivelContribucion;

    @Column(name = "Viab_Est_Der")
    private String viabEstDer;

    @Column(name = "Prop_Est_Der")
    private String propEstDer;

    @Column(name = "Comentario_Pertinencia")
    private String comentarioPertinencia;

    @Column(name = "id_variable_unique", unique = true)
    private Integer idVariableUnique;
}
