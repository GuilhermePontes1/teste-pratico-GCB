package com.bcg.testepraticobcg.service;

import com.bcg.testepraticobcg.dto.EspecialidadeDTO;
import com.bcg.testepraticobcg.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository repository;

    @Transactional(readOnly = true)
    public List<EspecialidadeDTO> findAll() {
        return repository.findAll().stream().map(EspecialidadeDTO::new).collect(Collectors.toList());
    }

}

