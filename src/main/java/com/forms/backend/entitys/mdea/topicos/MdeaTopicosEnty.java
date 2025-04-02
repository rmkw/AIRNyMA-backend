package com.forms.backend.entitys.mdea.topicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mdea_topicos", uniqueConstraints = @UniqueConstraint(columnNames = { "id_comp", "id_sub",
        "id_top" }), indexes = {
                @Index(name = "idx_id_comp_id_sub", columnList = "id_comp, id_sub"),
                @Index(name = "idx_unique_id", columnList = "unique_id")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdeaTopicosEnty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unique_id")
    private Integer uniqueId;

    @Column(name = "id_comp", nullable = false)
    private Integer idComp;

    @Column(name = "id_sub", nullable = false)
    private Integer idSub;

    @Column(name = "id_top", nullable = false)
    private Integer idTop;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "definicion", nullable = false)
    private String definicion;
}
