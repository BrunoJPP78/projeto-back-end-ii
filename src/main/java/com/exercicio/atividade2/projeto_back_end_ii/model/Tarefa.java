package com.exercicio.atividade2.projeto_back_end_ii.model;

import com.exercicio.atividade2.projeto_back_end_ii.Enums.Prioridade;
import com.exercicio.atividade2.projeto_back_end_ii.dto.TarefaDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "tarefas")
public class Tarefa {

    private String id;
    private String titulo;
    private String descricao;
    private LocalDate dataCriacao;
    Prioridade prioridade;

    @JsonIgnore
    @DBRef
    private Usuario usuario;

    private boolean isDeleted = false;

    public static Tarefa fromDto(TarefaDto tarefaDto){
        return new Tarefa(null, tarefaDto.titulo(), tarefaDto.descricao(),
                tarefaDto.dataCriacao(), tarefaDto.prioridade(), tarefaDto.usuario(), false);
    }
}
