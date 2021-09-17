package com.bcg.testepraticobcg.viacep;

import lombok.*;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Service
public class EnderecoDTO {

    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

}
