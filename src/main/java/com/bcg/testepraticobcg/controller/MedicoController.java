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

    @DeleteMapping(value = "/soft-delete/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable Long id) {
        service.softDelete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<List<MedicoDTO>> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(service.findByNome(nome));
    }

    @GetMapping(value = "/telefoneFixo/{telefoneFixo}")
    public ResponseEntity<MedicoDTO> findByTelefoneFixo(@PathVariable Long telefoneFixo) {
        return ResponseEntity.ok().body(service.findByTelefoneFixo(telefoneFixo));
    }

    @GetMapping(value = "/crm/{crm}")
    public ResponseEntity<MedicoDTO> findByCrm(@PathVariable Integer crm) {
        return ResponseEntity.ok().body(service.findByCrm(crm));
    }
    @GetMapping(value = "/elefoneCelular/{telefoneCelular}")
    public ResponseEntity<MedicoDTO> findByTelefoneCelular(@PathVariable Long telefoneCelular) {
        return ResponseEntity.ok().body(service.findByTelefoneCelular(telefoneCelular));
    }

    @GetMapping(value = "/logradouro/{logradouro}")
    public ResponseEntity<List<MedicoDTO>> findByLogradouro(@PathVariable String logradouro) {
        return ResponseEntity.ok().body(service.findByLogradouro(logradouro));
    }

    @GetMapping(value = "/bairro/{bairro}")
    public ResponseEntity<List<MedicoDTO>> findByBairro(@PathVariable String bairro) {
        return ResponseEntity.ok().body(service.findByBairro(bairro));
    }
    @GetMapping(value = "/cep/{cep}")
    public ResponseEntity<List<MedicoDTO>> findByCep(@PathVariable Integer cep) {
        return ResponseEntity.ok().body(service.findByCep(cep));
    }

    @GetMapping(value = "/complemento/{complemento}")
    public ResponseEntity<List<MedicoDTO>> findByComplemento(@PathVariable String complemento) {
        return ResponseEntity.ok().body(service.findByComplemento(complemento));
    }
    @GetMapping(value = "/uf/{uf}")
    public ResponseEntity<List<MedicoDTO>> findByUf(@PathVariable String uf) {
        return ResponseEntity.ok().body(service.findByUf(uf));
    }
    @GetMapping(value = "/localidade/{localidade}")
    public ResponseEntity<List<MedicoDTO>> findByLocalidade(@PathVariable String localidade) {
        return ResponseEntity.ok().body(service.findByLocalidade(localidade));
    }
}



