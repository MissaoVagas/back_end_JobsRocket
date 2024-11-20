package com.back_end.JobsRocket.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import com.back_end.JobsRocket.dto.CandidatoRequestDto;
import com.back_end.JobsRocket.dto.CandidatoResponseDto;
import com.back_end.JobsRocket.dto.RecrutadorRequestDto;
import com.back_end.JobsRocket.dto.RecrutadorResponseDto;
import com.back_end.JobsRocket.dto.UserResponseDto;
import com.back_end.JobsRocket.exceptions.PasswordValidationError;
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

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testCreateUserCandidato() throws Exception {
        CandidatoRequestDto requestDto = new CandidatoRequestDto();
        requestDto.setNome("João da Silva");
        requestDto.setEmail("joao.silva@example.com");
        requestDto.setSenha("Senha123!");
        
        CandidatoResponseDto responseDto = new CandidatoResponseDto();
        responseDto.setUser_id(1); // ID gerado após a criação
        responseDto.setNome(requestDto.getNome());
        responseDto.setEmail(requestDto.getEmail());

        when(userService.criarCandidato(any(CandidatoRequestDto.class))).thenReturn(responseDto);

        String jsonRequest = "{ \"nome\": \"" + requestDto.getNome() + "\", " +
                             "\"email\": \"" + requestDto.getEmail() + "\", " +
                             "\"senha\": \"" + requestDto.getSenha() + "\" }";

        mockMvc.perform(post("/api/user/candidato")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("/api/user/" + responseDto.getUser_id())));
    }

    @Test
    public void testCreateUserRecrutador() throws Exception {
        RecrutadorRequestDto requestDto = new RecrutadorRequestDto();
        requestDto.setNome("Maria Oliveira");
        requestDto.setEmail("maria.oliveira@example.com");
        requestDto.setSenha("Senha123!");

        RecrutadorResponseDto responseDto = new RecrutadorResponseDto();
        responseDto.setUser_id(2); // ID gerado após a criação
        responseDto.setNome(requestDto.getNome());
        responseDto.setEmail(requestDto.getEmail());

        when(userService.criarRecrutador(any(RecrutadorRequestDto.class))).thenReturn(responseDto);

        String jsonRequest = "{ \"nome\": \"" + requestDto.getNome() + "\", " +
                             "\"email\": \"" + requestDto.getEmail() + "\", " +
                             "\"senha\": \"" + requestDto.getSenha() + "\" }";

        mockMvc.perform(post("/api/user/recrutador")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("/api/user/" + responseDto.getUser_id())));
    }

    @Test
    public void testGetUsers() throws Exception {
        UserResponseDto user1 = new UserResponseDto();
        user1.setUser_id(1);
        user1.setNome("João da Silva");
        
        UserResponseDto user2 = new UserResponseDto();
        user2.setUser_id(2);
        user2.setNome("Maria Oliveira");

        List<UserResponseDto> users = Arrays.asList(user1, user2);

        when(userService.listarUsuarios()).thenReturn(users);

        mockMvc.perform(get("/api/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))) // Verifica se a lista tem 2 elementos
                .andExpect(jsonPath("$[0].nome").value("João da Silva")) // Verifica o nome do primeiro usuário
                .andExpect(jsonPath("$[1].nome").value("Maria Oliveira")); // Verifica o nome do segundo usuário
    }

    @Test
    public void testUpdateCandidato() throws Exception {
        CandidatoRequestDto requestDto = new CandidatoRequestDto();
        requestDto.setNome("João da Silva Atualizado");
        
        CandidatoResponseDto responseDto = new CandidatoResponseDto();
        responseDto.setUser_id(1); // ID do candidato atualizado

        when(userService.atualizarCandidato(any(CandidatoRequestDto.class), anyInt())).thenReturn(responseDto);

        String jsonRequest = "{ \"nome\": \"" + requestDto.getNome() + "\", " +
                             "\"email\": \"joao.silva@example.com\", " +
                             "\"senha\": \"Senha123!\" }";

        mockMvc.perform(put("/api/user/candidato/1") // ID do candidato existente
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(responseDt.getUser_id())); // Ajuste conforme necessário
    }

    @Test
    public void testUpdateRecrutador() throws Exception {
        RecrutadorRequestDto requestDt = new RecrutadorRequestDt();
        requestDt.setNome("Maria Oliveira Atualizada");
        
        RecrutadorResponseDt responseDt = new RecrutadorResponseDt();
        responseDt.setUser_id(2); // ID do recrutador atualizado

        when(userService.atualizarRecrutador(any(RecrutadorRequestDt.class), anyInt())).thenReturn(responseDt);

        String jsonRequest = "{ \"nome\": \"" + requestDt.getNome() + "\", " +
                             "\"email\": \"maria.oliveira@example.com\", " +
                             "\"senha\": \"Senha123!\" }";

        mockMvc.perform(put("/api/user/recrutador/2") // ID do recrutador existente
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(responseDt.getUser_id())); // Ajuste conforme necessário
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/user/1")) // ID do usuário que será deletado
                .andExpect(status().isOk());

        verify(userService, times(1)).deletarUsuario(1);
    }

    @Test
    public void testGetUserById() throws Exception {
        UserResponseDt responseDt = new UserResponseDt(); // Preencha conforme necessário

        when(userService.acharUsuarioPorId(anyInt())).thenReturn(responseDt);

        mockMvc.perform(get("/api/user/id/1")) // ID do usuário que será buscado
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(responseDt.getUser_id())); // Ajuste conforme necessário
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        UserResponseDt responseDt = new UserResponseDt(); // Preencha conforme necessário

        when(userService.acharUsuarioPorEmail(anyString())).thenReturn(responseDt);

        mockMvc.perform(get("/api/user/email/test@example.com")) // Email do usuário que será buscado
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(responseDt.getUser_id())); // Ajuste conforme necessário
    }
}
