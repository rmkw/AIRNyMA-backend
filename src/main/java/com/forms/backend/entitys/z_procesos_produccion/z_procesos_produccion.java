package com.forms.backend.entitys.z_procesos_produccion;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "z_procesos_produccion")
@Data
public class z_procesos_produccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "programa_informacion")
    private String programaInformacion;

    @Column(name = "acronimo")
    private String acronimo;

    @Column(name = "nombre_proceso")
    private String nombreProceso;

    @Column(name = "clave_periodicidad_proceso")
    private String clavePeriodicidadProceso;

    @Column(name = "periodicidad_proceso")
    private String periodicidadProceso;

    @Column(name = "inicio_vigencia")
    private String inicioVigencia;

    @Column(name = "conclusion")
    private String conclusion;

    @Column(name = "objetivo")
    private String objetivo;

    @Column(name = "poblacion_objeto")
    private String poblacionObjeto;

    @Column(name = "unidad_observacion")
    private String unidadObservacion;

    @Column(name = "unidad_administrativa")
    private String unidadAdministrativa;

    @Column(name = "clave_metodo_generacion")
    private String claveMetodoGeneracion;

    @Column(name = "metodo_generacion")
    private String metodoGeneracion;

    @Column(name = "cobertura_tematica")
    private String coberturaTematica;

    @Column(name = "cobertura_geografica")
    private String coberturaGeografica;

    @Column(name = "productos")
    private String productos;

    @Column(name = "clave_periodicidad_productos")
    private String clavePeriodicidadProductos;

    @Column(name = "periodicidad_productos")
    private String periodicidadProductos;

    @Column(name = "clave_grado_madurez")
    private String claveGradoMadurez;

    @Column(name = "grado_madurez")
    private String gradoMadurez;

    @Column(name = "clave_iin")
    private String claveIin;

    @Column(name = "condicion_iin")
    private String condicionIin;

    @Column(name = "fecha_determinacion_iin")
    private String fechaDeterminacionIin;

    @Column(name = "clave_periodicidad_cambios")
    private String clavePeriodicidadCambios;

    @Column(name = "periodicidad_cambios")
    private String periodicidadCambios;

    @Column(name = "clave_origen_recursos")
    private String claveOrigenRecursos;

    @Column(name = "origen_recursos")
    private String origenRecursos;

    @Column(name = "clave_dga")
    private String claveDga;

    @Column(name = "dga_responsable")
    private String dgaResponsable;

    @Column(name = "fecha_incorporacion")
    private String fechaIncorporacion;

    @Column(name = "clave_condicion_infraestructura")
    private String claveCondicionInfraestructura;

    @Column(name = "condicion_infraestructura")
    private String condicionInfraestructura;

    @Column(name = "clave_infraestructura")
    private String claveInfraestructura;

    @Column(name = "infraestructura")
    private String infraestructura;

    @Column(name = "estatus")
    private String estatus;

    @Column(name = "id_di")
    private Integer idDi;

    @Column(name = "comentario_pp")
    private String comentarioPp;
}
