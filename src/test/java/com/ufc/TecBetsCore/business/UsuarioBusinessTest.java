package com.ufc.TecBetsCore.business;

import com.ufc.TecBetsCore.model.Usuario;
import com.ufc.TecBetsCore.repository.UsuarioRepository;
import com.ufc.TecBetsCore.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UsuarioBusinessTest {

    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    void obtemUsuariosTest(){
        when(usuarioRepository.findAll()).thenReturn(Stream
                .of(new Usuario("123","teste",2,3000),new Usuario("321","teste2",3,2500))
                .collect(Collectors.toList()));
        assertEquals(2, usuarioService.obterTodos().size());
    }
}
