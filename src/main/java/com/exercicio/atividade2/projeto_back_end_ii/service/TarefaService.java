package com.exercicio.atividade2.projeto_back_end_ii.service;

import com.exercicio.atividade2.projeto_back_end_ii.dto.TarefaDto;
import com.exercicio.atividade2.projeto_back_end_ii.model.Tarefa;
import com.exercicio.atividade2.projeto_back_end_ii.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Page<TarefaDto> findAll(Pageable pageable){
        return tarefaRepository.findAll(pageable).map(TarefaDto::new);
    }

    public TarefaDto findById(String id){
        Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
        if(optionalTarefa.isPresent()){
            return new TarefaDto(optionalTarefa.get());
        }
        throw new NoSuchElementException("Tarefa de Id: " + id + " não encontrado.");
    }

    public TarefaDto save(TarefaDto tarefaDto){
        Tarefa tarefa = Tarefa.fromDto(tarefaDto);
        return new TarefaDto(tarefaRepository.save(tarefa));
    }

    public TarefaDto update(String id, TarefaDto tarefaDto){
        Tarefa tarefa = Tarefa.fromDto(tarefaDto);
        tarefa.setId(id);
        return new TarefaDto(tarefaRepository.save(tarefa));
    }

    public List<TarefaDto> findAllDeleted() {
        return tarefaRepository.findAllDeleted().stream()
                .map(TarefaDto::new)
                .toList();
    }

    public void delete(String id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tarefa de Id: " + id + " não encontrada."));
        tarefa.setDeleted(true);
        tarefaRepository.save(tarefa);
    }

    public List<TarefaDto> findAllDeletedByUsuarioId(String usuarioId) {
        return tarefaRepository.findAllDeletedByUsuarioId(usuarioId)
                .stream()
                .map(TarefaDto::new)
                .toList();
    }

    public List<TarefaDto> findByTitulo(String titulo) {
        return tarefaRepository.findByTituloContainingIgnoreCase(titulo)
                .stream()
                .map(TarefaDto::new)
                .toList();
    }

    public List<TarefaDto> findByDataCriacaoBetween(LocalDate startDate, LocalDate endDate) {
        return tarefaRepository.findByDataCriacaoBetween(startDate, endDate)
                .stream()
                .map(TarefaDto::new)
                .toList();
    }




}
