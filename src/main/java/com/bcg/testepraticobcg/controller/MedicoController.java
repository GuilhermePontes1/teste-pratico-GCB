package com.bcg.testepraticobcg.controller;
import com.bcg.testepraticobcg.dto.MedicoDTO;
import com.bcg.testepraticobcg.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;


    @GetMapping
    public ResponseEntity<List<MedicoDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
    @PostMapping
    public ResponseEntity<MedicoDTO> save(@Valid @RequestBody MedicoDTO dto)  {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.save(dto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> update(@Valid @PathVariable Long id, @RequestBody MedicoDTO dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/by-id/{id}")
    public ResponseEntity<MedicoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value = "/by-nome/{nome}")
    public ResponseEntity<List<MedicoDTO>> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(service.findByNome(nome));
    }

    @GetMapping(value = "/by-telefoneFixo/{telefoneFixo}")
    public ResponseEntity<MedicoDTO> findByTelefoneFixo(@PathVariable Long telefoneFixo) {
        return ResponseEntity.ok().body(service.findByTelefoneFixo(telefoneFixo));
    }

    @GetMapping(value = "/by-crm/{crm}")
    public ResponseEntity<MedicoDTO> findByCrm(@PathVariable Integer crm) {
        return ResponseEntity.ok().body(service.findByCrm(crm));
    }
    @GetMapping(value = "/by-celular/{celular}")
    public ResponseEntity<MedicoDTO> findByCelular(@PathVariable Long celular) {
        return ResponseEntity.ok().body(service.findByTelefoneCelular(celular));
    }

    @GetMapping(value = "/by-logradouro/{logradouro}")
    public ResponseEntity<List<MedicoDTO>> findByLogradouro(@PathVariable String logradouro) {
        return ResponseEntity.ok().body(service.findByLogradouro(logradouro));
    }

    @GetMapping(value = "/by-bairro/{bairro}")
    public ResponseEntity<List<MedicoDTO>> findByBairro(@PathVariable String bairro) {
        return ResponseEntity.ok().body(service.findByBairro(bairro));
    }
    @GetMapping(value = "/by-cep/{cep}")
    public ResponseEntity<List<MedicoDTO>> findByCep(@PathVariable Integer cep) {
        return ResponseEntity.ok().body(service.findByCep(cep));
    }

    @GetMapping(value = "/by-complemento/{complemento}")
    public ResponseEntity<List<MedicoDTO>> findByComplemento(@PathVariable String complemento) {
        return ResponseEntity.ok().body(service.findByComplemento(complemento));
    }
    @GetMapping(value = "/by-uf/{uf}")
    public ResponseEntity<List<MedicoDTO>> findByUf(@PathVariable String uf) {
        return ResponseEntity.ok().body(service.findByUf(uf));
    }
    @GetMapping(value = "/by-localidade/{localidade}")
    public ResponseEntity<List<MedicoDTO>> findByLocalidade(@PathVariable String localidade) {
        return ResponseEntity.ok().body(service.findByLocalidade(localidade));
    }
}



