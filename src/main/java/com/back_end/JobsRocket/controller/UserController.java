package com.back_end.JobsRocket.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back_end.JobsRocket.dto.CandidatoDto;
import com.back_end.JobsRocket.dto.RecrutadorDto;
import com.back_end.JobsRocket.dto.UserDto;
import com.back_end.JobsRocket.exceptions.PasswordValidationError;
import com.back_end.JobsRocket.model.Candidato;
import com.back_end.JobsRocket.model.Recrutador;
import com.back_end.JobsRocket.model.User;
import com.back_end.JobsRocket.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@Operation(summary = "Criar um novo usuário", 
            description = "Cria um novo usuario e retorna os detalhes do usuario criado")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Usuario criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Dados inválidos")
	})
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid User user) throws PasswordValidationError{
		UserDto userDto = userService.criarUsuario(user);
		return ResponseEntity.created(URI.create("/api/user/" + userDto.getUser_id())).body(userDto);
	}
	
	@Operation(summary = "Listar usuários", 
            description = "Lista os usuarios e retorna os detalhes de cada usuario na lista")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista encontrada")
	})
	@GetMapping
	public ResponseEntity<List<UserDto>> getUsers(){
		return ResponseEntity.ok(userService.listarUsuarios());
	}
	
	@Operation(summary = "Atualiza um candidato", 
            description = "Atualiza um candidato e retorna os detalhes do candidato atualizado")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Candidato atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Dados inválidos"),
			@ApiResponse(responseCode = "404", description = "Candidato não encontrado"),
	})
	@PutMapping("/candidato/{candidatoId}")
	public ResponseEntity<CandidatoDto> updateCandidato(
			@RequestBody Candidato candidato, @PathVariable Integer candidatoId
			) throws PasswordValidationError{
		return ResponseEntity.ok(userService.atualizarCandidato(candidato, candidatoId));
	}
	
	@Operation(summary = "Atualiza um recrutador", 
            description = "Atualiza um recrutador e retorna os detalhes do recrutador atualizado")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Recrutador atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Dados inválidos"),
			@ApiResponse(responseCode = "404", description = "Recrutador não encontrado"),
	})
	@PutMapping("/recrutador/{recrutadorId}")
	public ResponseEntity<RecrutadorDto> updateRecrutador(
			@RequestBody Recrutador recrutador, @PathVariable Integer recrutadorId
			) throws PasswordValidationError{
		return ResponseEntity.ok(userService.atualizarRecrutador(recrutador, recrutadorId));
	}
	
	
	@Operation(summary = "Deleta um usuario", 
            description = "Deleta um usuariodo banco de dados. Não possui retorno.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario atualizado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Usuario não encontrado"),
	})
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		userService.deletarUsuario(userId);
	}

}
