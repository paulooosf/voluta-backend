package br.com.fiap.voluta.controller;

import br.com.fiap.voluta.dto.OngDTO;
import br.com.fiap.voluta.service.OngService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/ongs")
public class OngController {

    public final OngService service;

    @Autowired
    public OngController(OngService service) {
        this.service = service;
    }

    @GetMapping("/lista")
    public ResponseEntity<Page<OngDTO>> listar(Pageable pageable) {
        return ResponseEntity.ok(service.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OngDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<OngDTO> buscarPorCnpj(@PathVariable String cnpj) {
        return ResponseEntity.ok(service.buscarPorCnpj(cnpj));
    }

    @PostMapping
    public ResponseEntity<OngDTO> cadastrar(@Valid @RequestBody OngDTO dto) {
        OngDTO ongDTO = service.cadastrar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cnpj}").buildAndExpand(ongDTO.cnpj()).toUri();
        return ResponseEntity.created(uri).body(ongDTO);
    }

    @PutMapping(value = "editar", params = "id")
    public ResponseEntity<OngDTO> editar(@RequestParam Long id, @Valid @RequestBody OngDTO dto) {
        return ResponseEntity.ok(service.editar(id, dto.converter()));
    }

    @DeleteMapping(value = "deletar", params = "id")
    public ResponseEntity<OngDTO> deletar(@RequestParam Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
