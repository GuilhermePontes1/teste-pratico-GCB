package com.bcg.testepraticobcg.viacep;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@RequiredArgsConstructor

@Service
public class EnderecoDTO {

    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;


}
