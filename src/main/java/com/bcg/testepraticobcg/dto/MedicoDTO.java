package com.bcg.testepraticobcg.dto;

import com.bcg.testepraticobcg.entity.Especialidade;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
public class MedicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @Length(min = 5,  max = 120, message = "tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @Digits(integer = 7, message = "No maximo 7 digitos", fraction = 0)
    private Integer crm;

    @NotEmpty(message = "Não pode ser vazio")
    private Integer telefoneFixo;

    @NotEmpty(message = "Não pode ser vazio")
    private Integer celular;

    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    private List<EspecialidadeDTO> especialidades = new ArrayList<>();


}
