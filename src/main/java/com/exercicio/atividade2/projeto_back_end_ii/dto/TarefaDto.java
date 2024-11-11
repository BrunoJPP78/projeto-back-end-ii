package com.exercicio.atividade2.projeto_back_end_ii.dto;

import com.exercicio.atividade2.projeto_back_end_ii.Enums.Prioridade;
import com.exercicio.atividade2.projeto_back_end_ii.model.Tarefa;
import com.exercicio.atividade2.projeto_back_end_ii.model.Usuario;

import java.time.LocalDate;

public record TarefaDto(
        String id,
        String titulo,
        String descricao,
        LocalDate dataCriacao,
        Prioridade prioridade,
        Usuario usuario
) {
    public TarefaDto(Tarefa tarefa){
        this(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(),
                tarefa.getDataCriacao(), tarefa.getPrioridade(), tarefa.getUsuario());
    }
}
