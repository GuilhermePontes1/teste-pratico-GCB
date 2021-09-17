package com.bcg.testepraticobcg.repository;

import com.bcg.testepraticobcg.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicoRepository  extends JpaRepository<Medico, Long> {
    List<Medico> findByNomeIgnoreCase(String nome);

    Medico findByCrm(Integer crm);

    Medico findByTelefoneFixo(Long telefoneFixo);

    Medico findByTelefoneCelular(Long telefoneCelular);

    List<Medico> findByCep(Integer cep);

    List<Medico> findByLogradouroIgnoreCase(String logradouro);

    List<Medico> findByComplementoIgnoreCase(String complemento);

    List<Medico> findByBairroIgnoreCase(String bairro);

    List<Medico> findByLocalidadeIgnoreCase(String localidade);

    List<Medico> findByUfIgnoreCase(String uf);
}
