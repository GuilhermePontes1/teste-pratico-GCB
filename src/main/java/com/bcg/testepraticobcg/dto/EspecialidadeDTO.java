package com.bcg.testepraticobcg.dto;

import com.bcg.testepraticobcg.entity.Especialidade;
import lombok.*;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    public EspecialidadeDTO(Especialidade entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

}
