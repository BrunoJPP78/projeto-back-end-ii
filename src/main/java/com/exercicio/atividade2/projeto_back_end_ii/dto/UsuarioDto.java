package com.exercicio.atividade2.projeto_back_end_ii.dto;

import com.exercicio.atividade2.projeto_back_end_ii.model.Tarefa;
import com.exercicio.atividade2.projeto_back_end_ii.model.Usuario;

import java.util.List;

public record UsuarioDto(
        String id,
        String nome,
        String email,
        String telefone,
        List<Tarefa> tarefas
) {
    public UsuarioDto(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(),
                usuario.getTelefone(), usuario.getTarefas());
    }
}
