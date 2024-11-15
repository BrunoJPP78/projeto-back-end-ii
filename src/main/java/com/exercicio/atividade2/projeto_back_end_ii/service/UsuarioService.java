package com.exercicio.atividade2.projeto_back_end_ii.service;

import com.exercicio.atividade2.projeto_back_end_ii.dto.UsuarioDto;
import com.exercicio.atividade2.projeto_back_end_ii.model.Usuario;
import com.exercicio.atividade2.projeto_back_end_ii.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Page<UsuarioDto> findAll(Pageable pageable){
        return usuarioRepository.findAll(pageable).map(UsuarioDto::new);
    }

    public UsuarioDto findById(String id){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isPresent()){
            return new UsuarioDto(optionalUsuario.get());
        }
        throw new NoSuchElementException("Usuário de ID: " + id + " não encontrado.");
    }

    public UsuarioDto save(UsuarioDto usuarioDto){
        return new UsuarioDto(usuarioRepository.save(Usuario.fromDto(usuarioDto)));
    }

    public UsuarioDto update(String id, UsuarioDto usuarioDto) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário de ID: " + id + " não encontrado."));

        // Atualiza apenas os campos enviados
        if (usuarioDto.nome() != null) {
            usuarioExistente.setNome(usuarioDto.nome());
        }
        if (usuarioDto.email() != null) {
            usuarioExistente.setEmail(usuarioDto.email());
        }
        if (usuarioDto.telefone() != null) {
            usuarioExistente.setTelefone(usuarioDto.telefone());
        }
        if (usuarioDto.tarefas() != null) {
            usuarioExistente.setTarefas(usuarioDto.tarefas());
        }

        return new UsuarioDto(usuarioRepository.save(usuarioExistente));
    }
    public void delete(String id) {
        usuarioRepository.deleteById(id);
    }

}
