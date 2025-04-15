package com.forms.backend.entitys.captura_relationVarWhitMDEA;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "relacion_mdea_variable_eco")
@Getter
@Setter
public class RelationVarWhitMDEA {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_unique")
  private Long id;

  @Column(name = "id_var_caracterizada")
  private String idVarCaracterizada;

  @Column(name = "id_variable_unique", nullable = false)
  private Long idVariableUnique;

  @Column(name = "id_variable", nullable = false)
  private String idVariable;

  @Column(name = "id_componente")
  private String idComponente;

  @Column(name = "id_subcomponente")
  private String idSubcomponente;

  @Column(name = "id_topico")
  private String idTopico;

  @Column(name = "id_variable_mdea_pull")
  private String idVariableMdeaPull;

  @Column(name = "id_estadistico")
  private String idEstadistico;

  @Column(name = "nivel_contribucion")
  private String nivelContribucion;

  @Column(name = "comentario_relacion_mdea")
  private String comentarioRelacionMdea;
}
