package com.bcg.testepraticobcg.service;
import com.bcg.testepraticobcg.dto.EspecialidadeDTO;
import com.bcg.testepraticobcg.dto.MedicoDTO;
import com.bcg.testepraticobcg.entity.Especialidade;
import com.bcg.testepraticobcg.entity.Medico;
import com.bcg.testepraticobcg.repository.EspecialidadeRepository;
import com.bcg.testepraticobcg.repository.MedicoRepository;
import com.bcg.testepraticobcg.service.exceptions.DatabaseException;
import com.bcg.testepraticobcg.service.exceptions.ResourceNotFoundException;
import com.bcg.testepraticobcg.viacep.EnderecoDTO;
import com.bcg.testepraticobcg.viacep.ViaCEPWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.ValidatingMinimumSpecialization;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;
    @Autowired
    private EspecialidadeRepository especialidadeRepository;
    @Autowired
    private ViaCEPWebService viaCepWbService;

    @Transactional
    public MedicoDTO save(MedicoDTO dto) {
        Medico entity = new Medico();
        copyDtoEntity(entity, dto);
        ValidatingMinimumSpecialization.validating(dto);
        repository.save(entity);
        return new MedicoDTO(entity, entity.getEspecialidades());

    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not  found : " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database violation");
        }
    }

    @Transactional
    public MedicoDTO update(Long id, MedicoDTO dto) {
        try {
            Medico aux = updateAux(id, dto);
            repository.save(aux);
            return new MedicoDTO(aux, aux.getEspecialidades());
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found :" + id);
        }

    }
    @Transactional(readOnly = true)
    public List<MedicoDTO> findAll() {
        return repository.findAll().stream().map(x -> new MedicoDTO(x, x.getEspecialidades()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MedicoDTO findById(Long id) {
        return repository.findById(id).map(x -> new MedicoDTO(x, x.getEspecialidades()))
                .orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada)"));
    }

    @Transactional(readOnly = true)
    public List<MedicoDTO> findByNome(String nome) {
        return repository.findByNomeIgnoreCase(nome).stream().map(x-> new MedicoDTO(x,x.getEspecialidades())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MedicoDTO findByTelefoneFixo(Long telefoneFixo) {
        Medico aux = repository.findByTelefoneFixo(telefoneFixo);
        if (aux == null) {
            throw new ResourceNotFoundException("A entidade não foi localizada");
        }
        return new MedicoDTO(aux, aux.getEspecialidades());
    }

    @Transactional(readOnly = true)
    public MedicoDTO findByCrm(Integer crm) {
        Medico aux = repository.findByCrm(crm);
        if (aux == null) {
            throw new ResourceNotFoundException("A entidade não foi localizada");
        }
        return new MedicoDTO(aux, aux.getEspecialidades());
    }

    @Transactional(readOnly = true)
    public MedicoDTO findByTelefoneCelular(Long telefoneCelular) {
        Medico aux = repository.findByTelefoneCelular(telefoneCelular);
        if (aux == null) {
            throw new ResourceNotFoundException("A entidade não foi localizada");
        }
        return new MedicoDTO(aux, aux.getEspecialidades());
    }
    @Transactional(readOnly = true)
    public List<MedicoDTO> findByLogradouro(String logradouro) {
        return repository.findByLogradouroIgnoreCase(logradouro).stream()
                .map(x -> new MedicoDTO(x, x.getEspecialidades())).collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public List<MedicoDTO> findByCep(Integer cep) {
        return repository.findByCep(cep).stream().map(x -> new MedicoDTO(x, x.getEspecialidades()))
                .collect(Collectors.toList());

    }
    @Transactional(readOnly = true)
    public List<MedicoDTO> findByBairro(String bairro) {
        return repository.findByBairroIgnoreCase(bairro).stream().map(x -> new MedicoDTO(x, x.getEspecialidades()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MedicoDTO> findByComplemento(String complemento) {
        return repository.findByComplementoIgnoreCase(complemento).stream()
                .map(x -> new MedicoDTO(x, x.getEspecialidades())).collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public List<MedicoDTO> findByLocalidade(String localidade) {
        return repository.findByLocalidadeIgnoreCase(localidade).stream()
                .map(x -> new MedicoDTO(x, x.getEspecialidades())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MedicoDTO> findByUf(String uf) {
        return repository.findByUfIgnoreCase(uf).stream().map(x -> new MedicoDTO(x, x.getEspecialidades()))
                .collect(Collectors.toList());

    }


    private void copyDtoEntity(Medico entity, MedicoDTO dto) {
        entity.setNome(dto.getNome());
        entity.setCrm(dto.getCrm());
        entity.setTelefoneFixo(dto.getTelefoneFixo());
        entity.setTelefoneCelular(dto.getTelefoneCelular());
        entity.setCep(dto.getCep());
        EnderecoDTO enderecoDTO = viaCepWbService.viaCEPWebService(entity.getCep());
        entity.setLogradouro(enderecoDTO.getLogradouro());
        entity.setComplemento(enderecoDTO.getComplemento());
        entity.setBairro(enderecoDTO.getBairro());
        entity.setLocalidade(enderecoDTO.getLocalidade());
        entity.setUf(enderecoDTO.getUf());
        entity.getEspecialidades().clear();
        for (EspecialidadeDTO espDTO : dto.getEspecialidades()) {
            Especialidade aux = especialidadeRepository.getById(espDTO.getId());
            entity.getEspecialidades().add(aux);
        }

    }

    private Medico updateAux(Long id, MedicoDTO dto) {
        Medico entity = repository.getById(id);
        entity.setNome(dto.getNome());
        entity.setCrm(dto.getCrm());
        entity.setTelefoneFixo(dto.getTelefoneFixo());
        entity.setTelefoneCelular(dto.getTelefoneCelular());
        entity.setCep(dto.getCep());
        EnderecoDTO enderecoDTO = viaCepWbService.viaCEPWebService(entity.getCep());
        entity.setLogradouro(enderecoDTO.getLogradouro());
        entity.setComplemento(enderecoDTO.getComplemento());
        entity.setBairro(enderecoDTO.getBairro());
        entity.setLocalidade(enderecoDTO.getLocalidade());
        entity.setUf(enderecoDTO.getUf());
        entity.getEspecialidades().clear();
        for (EspecialidadeDTO espDTO : dto.getEspecialidades()) {
            Especialidade aux = especialidadeRepository.getById(espDTO.getId());
            entity.getEspecialidades().add(aux);
        }
        return entity;
    }
}
