package com.forms.backend.entitys.ods_pull;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ods_meta", schema = "catalog") // Opcional
@IdClass(MetaId.class)
public class meta_Enty {
     @Id
    @Column(name = "id_objetivo")
    private Integer idObjetivo;
    
    @Id
    @Column(name = "id_meta")
    private String idMeta;
    
    @Column(name = "name_meta", nullable = false)
    private String nombreMeta;
    
    @ManyToOne
    @MapsId("idObjetivo")
    @JoinColumn(name = "id_objetivo", insertable = false, updatable = false)
    @JsonIgnore
    private objetivo_Enty objetivo;
}

