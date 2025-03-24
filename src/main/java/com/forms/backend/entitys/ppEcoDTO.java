package com.forms.backend.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pp_economicas_control")
@Getter
@Setter
@NoArgsConstructor
public class ppEcoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String procesoProduccion;
    private String acronimoProceso;
    private String metodoGeneracion;
    private String objetivo;
    private String poblacionObjeto;
    private String unidadObservacion;
    private String unidadAdministrativa;
    private String periodicidad;
    private String informacionInteresNacional;
    private String estatus;
    private String comentarioPp;
    
}
