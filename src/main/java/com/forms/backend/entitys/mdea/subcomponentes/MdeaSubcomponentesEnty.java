package com.forms.backend.entitys.mdea.subcomponentes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mdea_subcomponentes",  schema = "catalog", uniqueConstraints = @UniqueConstraint(columnNames = { "id_comp",
        "id_sub" }), indexes = {
                @Index(name = "idx_id_comp", columnList = "id_comp"),
                @Index(name = "idx_id_sub", columnList = "id_sub")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdeaSubcomponentesEnty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unique_id")
    private Integer uniqueId;

    @Column(name = "id_comp", nullable = false)
    private Integer idComp;

    @Column(name = "id_sub", nullable = false)
    private Integer idSub;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "definicion", nullable = false)
    private String definicion;
}
