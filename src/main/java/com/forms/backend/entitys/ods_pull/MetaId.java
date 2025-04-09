package com.forms.backend.entitys.ods_pull;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaId implements Serializable {
    private Integer idObjetivo;
    private String idMeta;
}
