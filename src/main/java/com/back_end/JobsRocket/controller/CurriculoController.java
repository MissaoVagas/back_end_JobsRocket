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

import com.back_end.JobsRocket.dto.CurriculoRequestDto;
import com.back_end.JobsRocket.model.Curriculo;
import com.back_end.JobsRocket.service.CurriculoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/curriculo")
public class CurriculoController {
	
	@Autowired
	CurriculoService curriculoService;
	
	@Operation(summary = "Criar um novo curriculo", 
            description = "Cria um novo curriculo e retorna os detalhes do curriculo criado")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Curriculo criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Dados inválidos"),
			@ApiResponse(responseCode = "404", description = "Id do candidato não encontrado"),
	})
	@PostMapping("/candidato/{candidato_id}")
	public ResponseEntity<Curriculo> saveCurriculo(
			@RequestBody CurriculoRequestDto curriculo,@PathVariable Integer candidato_id
			){
		Curriculo curriculoNovo = curriculoService.criarCurriculo(curriculo, candidato_id);
		return ResponseEntity.created(URI.create("/api/curriculo/{candidato_id}/" + curriculoNovo.getCurriculo_id())).body(curriculoNovo);
	}
	
	
	@Operation(summary = "Listar curriculos", 
            description = "Lista os curriculos e retorna os detalhes de cada curriculo na lista")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista encontrada")
	})
	@GetMapping
	public ResponseEntity<List<Curriculo>> getCurriculos(){
		return ResponseEntity.ok(curriculoService.listarCurriculos());
	}
	
	
	@Operation(summary = "Atualiza um curriculo", 
            description = "Atualiza um curriculo e retorna os detalhes do curriculo atualizado")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Curriculo atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Dados inválidos"),
			@ApiResponse(responseCode = "404", description = "Curriculo não encontrado"),
	})
	@PutMapping("/{curriculo_id}")
	public ResponseEntity<Curriculo> updateCurriculo(@RequestBody Curriculo curriculo, @PathVariable Integer curriculo_id){
		return ResponseEntity.ok(curriculoService.atualizarCurriculo(curriculo, curriculo_id));
	}
	
	
	@Operation(summary = "Deleta um curriculo", 
            description = "Deleta um curriculo do banco de dados. Não possui retorno.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Curriculo deletado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Curriculo não encontrado"),
	})
	@DeleteMapping("/{curriculo_id}")
	public void deleteCurriculo(@PathVariable Integer curriculo_id) {
		curriculoService.deletarCurriculo(curriculo_id);
	}
	
	

}
