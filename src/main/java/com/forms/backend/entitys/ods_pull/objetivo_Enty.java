package com.forms.backend.entitys.ods_pull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "pull_ods_objetivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class objetivo_Enty {
    @Id
    @Column(name = "id_objetivo")
    private Integer id;

    @Column(name = "objetivo", nullable = false)
    private String nombre;
}
