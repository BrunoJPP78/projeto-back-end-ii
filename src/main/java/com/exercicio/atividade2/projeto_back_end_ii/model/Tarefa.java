package com.exercicio.atividade2.projeto_back_end_ii.model;

import com.exercicio.atividade2.projeto_back_end_ii.Enums.Prioridade;
import com.exercicio.atividade2.projeto_back_end_ii.dto.TarefaDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "tarefas")
public class Tarefa {

    @Id
    private String id;

    @NotBlank(message = "O título não pode estar vazio.")
    private String titulo;

    @NotBlank(message = "A descrição não pode estar vazia.")
    private String descricao;

    @NotNull(message = "A data de criação é obrigatória.")
    private LocalDate dataCriacao;

    @NotNull(message = "A prioridade deve ser informada.")
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
