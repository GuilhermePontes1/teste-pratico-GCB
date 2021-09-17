package com.bcg.testepraticobcg.dto;

import com.bcg.testepraticobcg.entity.Especialidade;
import com.bcg.testepraticobcg.entity.Medico;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Long celular;

    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private Integer cep;


    private List<EspecialidadeDTO> especialidades = new ArrayList<>();

    public MedicoDTO(Medico entity) {
        id = entity.getId();
        nome = entity.getNome();
        crm = entity.getCrm();
        telefoneFixo = entity.getTelefoneFixo();
        celular = entity.getCelular();
        cep = entity.getCep();
        logradouro = entity.getLogradouro();
        complemento = entity.getComplemento();
        bairro = entity.getBairro();
        localidade = entity.getLocalidade();
        uf = entity.getUf();
    }

    public MedicoDTO(Medico entity, Set<Especialidade> especialidadesEntity) {
        this(entity);
        especialidadesEntity.forEach(x -> especialidades.add(new EspecialidadeDTO(x)));
    }


}
