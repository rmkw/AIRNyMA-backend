package com.forms.backend.entitys.z_procesos_produccion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class proceso_produccion_FULL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDi;  // id_di de la tabla
    
    private String nameDi;  // name_di de la tabla
}
