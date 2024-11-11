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

    public UsuarioDto update(String id, UsuarioDto usuarioDto){
        Usuario usuario = Usuario.fromDto(usuarioDto);
        usuario.setId(id);
        return new UsuarioDto(usuarioRepository.save(usuario));
    }
    public void delete(String id) {
        usuarioRepository.deleteById(id);
    }

}
