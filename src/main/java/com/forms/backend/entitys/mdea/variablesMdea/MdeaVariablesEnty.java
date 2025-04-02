package com.forms.backend.entitys.mdea.variablesMdea;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mdea_variables", uniqueConstraints = @UniqueConstraint(columnNames = { "id_comp", "id_sub", "id_top",
        "id_var" }), indexes = {
                @Index(name = "idx_id_comp_id_sub_id_top", columnList = "id_comp, id_sub, id_top"),
                @Index(name = "idx_unique_id", columnList = "unique_id")
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdeaVariablesEnty {
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

    @Column(name = "nombre", nullable = false)
    private String nombre;
}
