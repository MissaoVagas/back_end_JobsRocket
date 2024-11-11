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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid User user) throws PasswordValidationError{
		UserDto userDto = userService.criarUsuario(user);
		return ResponseEntity.created(URI.create("/api/user/" + userDto.getUser_id())).body(userDto);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getUsers(){
		return ResponseEntity.ok(userService.listarUsuarios());
	}
	
	@PutMapping("/candidato/{candidatoId}")
	public ResponseEntity<CandidatoDto> updateCandidato(
			@RequestBody Candidato candidato, @PathVariable Integer candidatoId
			) throws PasswordValidationError{
		return ResponseEntity.ok(userService.atualizarCandidato(candidato, candidatoId));
	}
	
	@PutMapping("/recrutador/{recrutadorId}")
	public ResponseEntity<RecrutadorDto> updateRecrutador(
			@RequestBody Recrutador recrutador, @PathVariable Integer recrutadorId
			) throws PasswordValidationError{
		return ResponseEntity.ok(userService.atualizarRecrutador(recrutador, recrutadorId));
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		userService.deletarUsuario(userId);
	}

}
