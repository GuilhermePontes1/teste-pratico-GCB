package utils;

import com.bcg.testepraticobcg.dto.EspecialidadeDTO;
import com.bcg.testepraticobcg.dto.MedicoDTO;

import java.util.Arrays;

public class MedicoUtils {


    public static MedicoDTO mockMedico() {

        return com.bcg.testepraticobcg.dto.MedicoDTO.builder()
                .nome("Guilherme")
                .crm(7777722)
                .cep(41490352)
                .telefoneCelular(71981384417L)
                .telefoneFixo(7136008400L)
                .especialidades(Arrays.asList(new EspecialidadeDTO(1L,"MEDICO DE CABEÇA"), new EspecialidadeDTO(2L,"ANGIOLOGISTA")))
                .softDelete(false)
                .build();

    }
    public static MedicoDTO mockMedico2() {

        return com.bcg.testepraticobcg.dto.MedicoDTO.builder()
                .nome("Guilherme")
                .crm(7777722)
                .cep(41490352)
                .telefoneCelular(71981384417L)
                .telefoneFixo(7136008400L)
                .especialidades(Arrays.asList(new EspecialidadeDTO(1L,"MEDICO DE CABEÇA")))
                .softDelete(false)
                .build();

    }



}
