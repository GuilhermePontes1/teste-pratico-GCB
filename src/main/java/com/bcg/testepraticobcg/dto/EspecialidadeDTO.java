package com.bcg.testepraticobcg.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class EspecialidadeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;
}
