package com.back_end.JobsRocket.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import com.back_end.JobsRocket.dto.CurriculoRequestDto;
import com.back_end.JobsRocket.dto.CurriculoResponseDto;
import com.back_end.JobsRocket.dto.UserRequestDto;
import com.back_end.JobsRocket.service.CurriculoService;
import com.back_end.JobsRocket.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class CurriculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CurriculoService curriculoService;

    @Mock
    private UserService userService; // Adicionando o UserService

    @InjectMocks
    private CurriculoController curriculoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(curriculoController).build();
    }

    @Test
    public void testSaveCurriculo() throws Exception {
        // Preenchendo o DTO do currículo
        CurriculoRequestDto requestDto = new CurriculoRequestDto();
        requestDto.setPessoais(new CurriculoPessoais(/* preencha com dados válidos */));
        requestDto.setPrincipais(new CurriculoPrincipais(/* preencha com dados válidos */));
        requestDto.setAcademicos(Arrays.asList(new CurriculoAcademicos(/* preencha com dados válidos */)));
        requestDto.setProfissionais(Arrays.asList(new CurriculoProfissionais(/* preencha com dados válidos */)));
        requestDto.setCursos(Arrays.asList(new CurriculoCursos(/* preencha com dados válidos */)));

        // Simulando a resposta do serviço
        CurriculoResponseDto responseDto = new CurriculoResponseDto();
        responseDto.setCurriculo_id(1); // ID gerado após a criação

        when(curriculoService.criarCurriculo(any(CurriculoRequestDto.class), anyInt())).thenReturn(responseDto);

        String jsonCurriculo = "{ \"pessoais\": { /* JSON dos atributos pessoais */ }, " +
                               "\"principais\": { /* JSON dos atributos principais */ }, " +
                               "\"academicos\": [ { /* JSON dos atributos acadêmicos */ } ], " +
                               "\"profissionais\": [ { /* JSON dos atributos profissionais */ } ], " +
                               "\"cursos\": [ { /* JSON dos atributos cursos */ } ] }";

        mockMvc.perform(post("/api/curriculo/candidato/1") // ID do candidato existente
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCurriculo))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("/api/curriculo/" + responseDto.getCurriculo_id())));
    }

    @Test
    public void testGetCurriculos() throws Exception {
        // Simulando uma lista de currículos
        CurriculoResponseDto curriculo1 = new CurriculoResponseDto();
        curriculo1.setCurriculo_id(1);
        
        CurriculoResponseDto curriculo2 = new CurriculoResponseDto();
        curriculo2.setCurriculo_id(2);
        
        List<CurriculoResponseDto> curriculos = Arrays.asList(curriculo1, curriculo2);

        when(curriculoService.listarCurriculos()).thenReturn(curriculos);

        mockMvc.perform(get("/api/curriculo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))); // Verifica se a lista tem 2 elementos
    }

    @Test
    public void testUpdateCurriculo() throws Exception {
        // Preenchendo o DTO do currículo para atualização
        CurriculoRequestDto requestDto = new CurriculoRequestDto();
        requestDto.setPessoais(new CurriculoPessoais(/* preencha com dados válidos */));
        requestDto.setPrincipais(new CurriculoPrincipais(/* preencha com dados válidos */));

        // Simulando a resposta do serviço após atualização
        CurriculoResponseDto responseDto = new CurrculoResponseDto();
        responseDto.setCurriculo_id(1); // ID gerado após a atualização

        when(curriculoService.atualizarCurriculo(any(Currculo.class), anyInt())).thenReturn(responseDto);

        String jsonCurrculo = "{ \"pessoais\": { /* JSON dos atributos pessoais */ }, " +
                              "\"principais\": { /* JSON dos atributos principais */ } }";

        mockMvc.perform(put("/api/currculo/1") // ID do currículo existente
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCurrculo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currculo_id").value(responseDt.getCurrculo_id())); // Ajuste conforme necessário
    }

    @Test
    public void testDeleteCurrculo() throws Exception {
        mockMvc.perform(delete("/api/currculo/1")) // ID do currículo que será deletado
                .andExpect(status().isOk());

        verify(currculoService, times(1)).deletarCurrculo(1);
    }

    @Test
    public void testFindCurrculoById() throws Exception {
        CurrculoResponseDt responseDt = new CurrculoResponseDt(); // Preencha conforme necessário

        when(currculoService.acharCurrculoPorId(anyInt())).thenReturn(responseDt);

        mockMvc.perform(get("/api/currculo/1")) // ID do currículo que será buscado
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currculo_id").value(responseDt.getCurrculo_id())); // Ajuste conforme necessário
    }
}
