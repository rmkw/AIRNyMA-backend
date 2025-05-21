package com.forms.backend.entitys.z_direcciones;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unidades", schema = "catalog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enty_direccionesGenerales {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idUnidad;

    private String nameUnidad; 
}
