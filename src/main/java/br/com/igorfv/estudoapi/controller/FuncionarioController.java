package br.com.igorfv.estudoapi.controller;

import br.com.igorfv.estudoapi.DTOs.FuncionarioDto;
import br.com.igorfv.estudoapi.repository.FuncionarioRepository;
import br.com.igorfv.estudoapi.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioDto> buscar() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{funcionarioId}")
    public ResponseEntity<FuncionarioDto> buscarId(@Valid @PathVariable Long funcionarioId) {
        return funcionarioRepository.findById(funcionarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioDto adicionar(@Valid @RequestBody FuncionarioDto funcionario) {
        return funcionarioService.salvar(funcionario);
    }

    @PutMapping("/{funcionarioId}")
    public ResponseEntity<FuncionarioDto> atualizar(@PathVariable Long funcionarioId, @RequestBody FuncionarioDto funcionario) {

        if (!funcionarioRepository.existsById(funcionarioId)) {
            return ResponseEntity.notFound().build();
        }
        funcionario.setId(funcionarioId);
        funcionario = funcionarioService.salvar(funcionario);

        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{funcionarioId}")
    public ResponseEntity<Void> deletar(@PathVariable Long funcionarioId) {
        if (!funcionarioRepository.existsById(funcionarioId)) {
            return ResponseEntity.notFound().build();
        }

        funcionarioService.excluir(funcionarioId);

        return ResponseEntity.noContent().build();
    }

}
