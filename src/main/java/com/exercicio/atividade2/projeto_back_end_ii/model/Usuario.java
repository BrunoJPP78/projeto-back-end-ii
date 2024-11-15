package com.exercicio.atividade2.projeto_back_end_ii.model;

import com.exercicio.atividade2.projeto_back_end_ii.dto.UsuarioDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter entre 10 e 11 dígitos numéricos.")
    private String telefone;

    @JsonIgnore
    @DBRef
    private List<Tarefa> tarefas;

    public static Usuario fromDto(UsuarioDto usuarioDto){
        return new Usuario(null, usuarioDto.nome(), usuarioDto.email(),
                usuarioDto.telefone(), usuarioDto.tarefas());
    }

}
