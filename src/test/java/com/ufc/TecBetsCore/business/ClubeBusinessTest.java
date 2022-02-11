package com.ufc.TecBetsCore.business;

import com.ufc.TecBetsCore.model.Clube;
import com.ufc.TecBetsCore.repository.ClubeRepository;
import com.ufc.TecBetsCore.service.ClubeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClubeBusinessTest {

    @Autowired
    private ClubeService clubeService;

    @MockBean
    private ClubeRepository clubeRepository;

    @Test
    void obtemTodosTest(){
        when(clubeRepository.findAll()).thenReturn(Stream
                .of(new Clube("123456","ClubeTeste",1),new Clube("654321","ClubeTeste2",2))
                .collect(Collectors.toList()));
        assertEquals(2, clubeService.obterTodos().size());
    }
}
