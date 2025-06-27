
package com.forms.backend.entitys.z_procesos_produccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoProduccionDTO {
    private String acronimo;
    private String proceso;
    private String metodo;
    private String objetivo;
    private String pobjeto;
    private String uobservacion;
    private String unidad;
    private String periodicidad;
    private String iin;
    private String estatus;
    private String comentarioS;
    private String comentarioA;
    private Integer idUnidad;

    private Long totalVariables;
}
