package com.bcg.testepraticobcg.controller;

import com.bcg.testepraticobcg.dto.EspecialidadeDTO;
import com.bcg.testepraticobcg.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/especialidades")
public class EspecialidadeController {
    @Autowired
    private EspecialidadeService service;

    @GetMapping
    public ResponseEntity<List<EspecialidadeDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
}

