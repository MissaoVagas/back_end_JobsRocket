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

import com.back_end.JobsRocket.dto.CandidatoRequestDto;
import com.back_end.JobsRocket.dto.CandidatoResponseDto;
import com.back_end.JobsRocket.dto.RecrutadorRequestDto;
import com.back_end.JobsRocket.dto.RecrutadorResponseDto;
import com.back_end.JobsRocket.dto.UserResponseDto;
import com.back_end.JobsRocket.exceptions.PasswordValidationError;
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
	
	
	@Operation(summary = "Criar um novo usuário candidato", 
            description = "Cria um novo usuario candidato e retorna os detalhes do usuario criado")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Usuario criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Dados inválidos")
	})
	@PostMapping("/candidato")
	public ResponseEntity<CandidatoResponseDto> createUserCandidato(@RequestBody @Valid CandidatoRequestDto user) throws PasswordValidationError{
		CandidatoResponseDto userDto = userService.criarCandidato(user);
		return ResponseEntity.created(URI.create("/api/user/" + userDto.getUser_id())).body(userDto);
	}
	
	
	@Operation(summary = "Criar um novo usuário recrutador", 
            description = "Cria um novo usuario recrutador e retorna os detalhes do usuario criado")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Usuario criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Dados inválidos")
	})
	@PostMapping("/recrutador")
	public ResponseEntity<RecrutadorResponseDto> createUserRecrutador(@RequestBody @Valid RecrutadorRequestDto user) throws PasswordValidationError{
		RecrutadorResponseDto userDto = userService.criarRecrutador(user);
		return ResponseEntity.created(URI.create("/api/user/" + userDto.getUser_id())).body(userDto);
	}
	
	@Operation(summary = "Listar usuários", 
            description = "Lista os usuarios e retorna os detalhes de cada usuario na lista")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista encontrada")
	})
	@GetMapping
	public ResponseEntity<List<UserResponseDto>> getUsers(){
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
	public ResponseEntity<CandidatoResponseDto> updateCandidato(
			@RequestBody CandidatoRequestDto candidato, @PathVariable Integer candidatoId
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
	public ResponseEntity<RecrutadorResponseDto> updateRecrutador(
			@RequestBody RecrutadorRequestDto recrutador, @PathVariable Integer recrutadorId
			) throws PasswordValidationError{
		return ResponseEntity.ok(userService.atualizarRecrutador(recrutador, recrutadorId));
	}
	
	
	@Operation(summary = "Deleta um usuario", 
            description = "Deleta um usuario do banco de dados. Não possui retorno.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario deletado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Usuario não encontrado")
	})
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		userService.deletarUsuario(userId);
	}
	
	@Operation(summary = "Achar um usuario pelo id", 
            description = "Acha um usuario no banco de dados pelo id. Retorna um usuário")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Usuario não encontrado"),
	})
	@GetMapping("/id/{userId}")
	public UserResponseDto getUserById(@PathVariable Integer userId) {
		return userService.acharUsuarioPorId(userId);
	}
	
	@Operation(summary = "Achar um usuario pelo email", 
            description = "Acha um usuario no banco de dados pelo email. Retorna um usuário")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuario encontrado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Usuario não encontrado"),
	})
	@GetMapping("/email/{email}")
	public UserResponseDto getUserByEmail(@PathVariable String email) {
		return userService.acharUsuarioPorEmail(email);
	}

}
