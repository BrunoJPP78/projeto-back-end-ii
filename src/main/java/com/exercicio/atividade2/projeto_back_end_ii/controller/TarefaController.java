package com.exercicio.atividade2.projeto_back_end_ii.controller;

import com.exercicio.atividade2.projeto_back_end_ii.dto.TarefaDto;
import com.exercicio.atividade2.projeto_back_end_ii.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/tarefas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<Page<TarefaDto>> findAll(@PageableDefault(5)Pageable pageable){
        return ResponseEntity.ok(tarefaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto>findById(@PathVariable String id) {
        return ResponseEntity.ok(tarefaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TarefaDto> save(@RequestBody TarefaDto tarefaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.save(tarefaDto));
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<TarefaDto>> findAllDeleted() {
        return ResponseEntity.ok(tarefaService.findAllDeleted());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        tarefaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/deleted/user/{usuarioId}")
    public ResponseEntity<List<TarefaDto>> findAllDeletedByUsuarioId(@PathVariable String usuarioId) {
        return ResponseEntity.ok(tarefaService.findAllDeletedByUsuarioId(usuarioId));
    }

    @GetMapping("/pesquisar-titulo")
    public ResponseEntity<List<TarefaDto>> findByTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(tarefaService.findByTitulo(titulo));
    }

    @GetMapping("/pesquisar-data-range")
    public ResponseEntity<List<TarefaDto>> findByDataCriacaoBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(tarefaService.findByDataCriacaoBetween(startDate, endDate));
    }



}
