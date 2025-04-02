package com.forms.backend.entitys.mdea.componentes;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mdea_componentes")
@Data
public class MdeaComponentesEnty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unique_id")
    private Long uniqueId;

    @Column(name = "id_comp", nullable = false, unique = true)
    private Integer idComp;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "definicion", nullable = false)
    private String definicion;

    @Column(name = "def_corta", nullable = false)
    private String defCorta;

}
