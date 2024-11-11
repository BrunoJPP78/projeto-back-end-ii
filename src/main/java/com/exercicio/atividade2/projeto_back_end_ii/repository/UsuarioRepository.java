package com.exercicio.atividade2.projeto_back_end_ii.repository;

import com.exercicio.atividade2.projeto_back_end_ii.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
