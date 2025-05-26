
package com.forms.backend.entitys.z_procesos_produccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoProduccionDTO {
    private Integer id;
    private String programaInformacion;
    private String acronimo;
    private String nombreProceso;
    private String clavePeriodicidadProceso;
    private String periodicidadProceso;
    private String inicioVigencia;
    private String conclusion;
    private String objetivo;
    private String poblacionObjeto;
    private String unidadObservacion;
    private String unidadAdministrativa;
    private String claveMetodoGeneracion;
    private String metodoGeneracion;
    private String coberturaTematica;
    private String coberturaGeografica;
    private String productos;
    private String clavePeriodicidadProductos;
    private String periodicidadProductos;
    private String claveGradoMadurez;
    private String gradoMadurez;
    private String claveIin;
    private String condicionIin;
    private String fechaDeterminacionIin;
    private String clavePeriodicidadCambios;
    private String periodicidadCambios;
    private String claveOrigenRecursos;
    private String origenRecursos;
    private String claveDga;
    private String dgaResponsable;
    private String fechaIncorporacion;
    private String claveCondicionInfraestructura;
    private String condicionInfraestructura;
    private String claveInfraestructura;
    private String infraestructura;
    private String estatus;
    private Integer idUnidad;
    private String comentarioPp;

    // Campo adicional
    private Long totalVariables;
}
