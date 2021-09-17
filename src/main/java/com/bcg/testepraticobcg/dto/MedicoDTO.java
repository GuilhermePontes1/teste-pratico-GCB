package com.bcg.testepraticobcg.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigInteger;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MedicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @Length(min = 5,  max =80, message = "tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @Length(min = 7,  max = 7, message = "tamanho deve ser entre  7 caracteres")
    private Long crm;

    @NotEmpty(message = "Não pode ser vazio")
    private BigInteger telefone;

    @NotEmpty(message = "Não pode ser vazio")
    private BigInteger celular;



}
