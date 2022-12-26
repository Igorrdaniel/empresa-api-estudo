package br.com.igorfv.estudoapi.controller;

import br.com.igorfv.estudoapi.DTOs.EmpresaDto;
import br.com.igorfv.estudoapi.repository.EmpresaRepository;
import br.com.igorfv.estudoapi.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<EmpresaDto> buscar() {
        return empresaRepository.findAll();
    }

    @GetMapping("/{empresaId}")
    public ResponseEntity<EmpresaDto> buscarid(@Valid @PathVariable Long empresaId) {
        return empresaRepository.findById(empresaId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaDto adicionar(@Valid @RequestBody EmpresaDto empresa) {
        return empresaService.salvar(empresa);
    }

    @PutMapping("/{empresaId}")
    public ResponseEntity<EmpresaDto> atualizar(@Valid @PathVariable Long empresaId, @RequestBody EmpresaDto empresaDto) {
        if (!empresaRepository.existsById(empresaId)) {
            return ResponseEntity.notFound().build();
        }
        empresaDto.setId(empresaId);
        empresaDto = empresaService.salvar(empresaDto);

        return ResponseEntity.ok(empresaDto);

    }

    @DeleteMapping("/deletar/{empresaId}")
    public ResponseEntity<Void> deletar(@Valid @PathVariable Long empresaId) {
        if (!empresaRepository.existsById(empresaId)) {
            return ResponseEntity.notFound().build();
        }

        empresaService.excluir(empresaId);
        return ResponseEntity.noContent().build();
    }

}
