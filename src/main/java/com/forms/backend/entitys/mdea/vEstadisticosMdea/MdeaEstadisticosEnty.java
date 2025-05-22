package com.forms.backend.entitys.mdea.vEstadisticosMdea;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mdea_estadisticos", schema = "catalog", uniqueConstraints = @UniqueConstraint(columnNames = { "id_comp", "id_sub", "id_top",
        "id_var", "id_estadistico" }), indexes = {
                @Index(name = "idx_id_comp_id_sub_id_top_id_var", columnList = "id_comp, id_sub, id_top, id_var"),
                @Index(name = "idx_unique_id", columnList = "unique_id")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdeaEstadisticosEnty {
    @Id
    @Column(name = "unique_id", nullable = false)
    private String uniqueId;

    @Column(name = "id_comp", nullable = false)
    private Integer idComp;

    @Column(name = "id_sub", nullable = false)
    private Integer idSub;

    @Column(name = "id_top", nullable = false)
    private Integer idTop;

    @Column(name = "id_var", nullable = false)
    private String idVar;

    @Column(name = "id_estadistico", nullable = false)
    private Integer idEstadistico;

    @Column(name = "nombre", nullable = false)
    private String nombre;
}
