package com.exercicio.atividade2.projeto_back_end_ii.controller;

import com.exercicio.atividade2.projeto_back_end_ii.dto.TarefaDto;
import com.exercicio.atividade2.projeto_back_end_ii.model.Tarefa;
import com.exercicio.atividade2.projeto_back_end_ii.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
