package com.back_end.JobsRocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back_end.JobsRocket.dto.CandidatoRequestDto;
import com.back_end.JobsRocket.dto.CandidatoResponseDto;
import com.back_end.JobsRocket.dto.RecrutadorRequestDto;
import com.back_end.JobsRocket.dto.RecrutadorResponseDto;
import com.back_end.JobsRocket.dto.UserResponseDto;
import com.back_end.JobsRocket.exceptions.PasswordValidationError;
import com.back_end.JobsRocket.model.Candidato;
import com.back_end.JobsRocket.model.Recrutador;
import com.back_end.JobsRocket.model.User;
import com.back_end.JobsRocket.utils.*;

import jakarta.persistence.EntityNotFoundException;

import com.back_end.JobsRocket.model.enums.Role;
import com.back_end.JobsRocket.repository.CandidatoRepository;
import com.back_end.JobsRocket.repository.RecrutadorRepository;
import com.back_end.JobsRocket.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private RecrutadorRepository recrutadorRepository;
	
	@Transactional
	public CandidatoResponseDto criarCandidato(CandidatoRequestDto candidatoRequest) throws PasswordValidationError {
		Candidato candidato = EntityConverter.toEntityCandidato(candidatoRequest);
		
		if(!Validator.validadorDeSenha(candidato.getSenha())) {
			throw new PasswordValidationError("Senha deve seguir o padrao:\n -1 Letra  maíuscula,\n -1 letra minuscula,\n -1 numero,\n -1 caractere especial,\n -tamanho mínimo de 8 carcteres");
		}
		
		Candidato savedCandidato = candidatoRepository.save(candidato);
        return DtoConverter.toCandidatoDTO(savedCandidato);
	}
	
	@Transactional
	public RecrutadorResponseDto criarRecrutador(RecrutadorRequestDto recrutadorRequest) throws PasswordValidationError {
		Recrutador recrutador = EntityConverter.toEntityRecrutador(recrutadorRequest);
		
		if(!Validator.validadorDeSenha(recrutador.getSenha())) {
			throw new PasswordValidationError("Senha deve seguir o padrao:\n -1 Letra  maíuscula,\n -1 letra minuscula,\n -1 numero,\n -1 caractere especial,\n -tamanho mínimo de 8 carcteres");
		}
		
        return DtoConverter.toRecrutadorDTO(recrutadorRepository.save(recrutador));
	}
	
	
	
	public List<UserResponseDto> listarUsuarios(){
		List<User> usuarios = userRepository.findAll();
		return DtoConverter.toListUserResponseDtos(usuarios);
	}
	
	@Transactional
    public void deletarUsuario(Integer userId) {
        User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + userId));
        
        // Verifica o tipo de usuário pelo Role e exclui da tabela específica
        if (usuario.getRole() == Role.CANDIDATO) {
            candidatoRepository.deleteById(userId);
        } else if (usuario.getRole() == Role.RECRUTADOR) {
            recrutadorRepository.deleteById(userId);
        }

        // Exclui o registro na tabela 'users'
        userRepository.deleteById(userId);
    }
	
	@Transactional
	public CandidatoResponseDto atualizarCandidato(CandidatoRequestDto candidatoRequest, Integer candidatoId) throws PasswordValidationError {
		
		Candidato candidato = EntityConverter.toEntityCandidato(candidatoRequest);
		
		Candidato candidatoExistente = candidatoRepository.findById(candidatoId)
                .orElseThrow(() -> new EntityNotFoundException("Candidato não encontrado com o ID: " + candidatoId));
		
		if(!Validator.validadorDeSenha(candidato.getSenha())) {
			throw new PasswordValidationError("Senha deve seguir o padrao:\n -1 Letra  maíuscula,\n -1 letra minuscula,\n -1 numero,\n -1 caractere especial,\n -tamanho mínimo de 8 carcteres");
		}
		
		candidatoExistente.setNome(candidato.getNome());
		candidatoExistente.setEmail(candidato.getEmail());
		candidatoExistente.setSenha(candidato.getSenha());
		candidatoExistente.setCurriculo(candidato.getCurriculo());
		candidatoExistente.setCampoDeInteresse(candidato.getCampoDeInteresse());
		
		return DtoConverter.toCandidatoDTO(candidatoRepository.save(candidatoExistente));
		

	}
	
	@Transactional
	public RecrutadorResponseDto atualizarRecrutador(RecrutadorRequestDto recrutadorRequest, Integer recrutadorId) throws PasswordValidationError {
		
		Recrutador recrutador = EntityConverter.toEntityRecrutador(recrutadorRequest);
		
		Recrutador recrutadorExistente = recrutadorRepository.findById(recrutadorId)
                .orElseThrow(() -> new EntityNotFoundException("Recrutador não encontrado com o ID: " + recrutadorId));
		
		if(!Validator.validadorDeSenha(recrutador.getSenha())) {
			throw new PasswordValidationError("Senha deve seguir o padrao:\n -1 Letra  maíuscula,\n -1 letra minuscula,\n -1 numero,\n -1 caractere especial,\n -tamanho mínimo de 8 carcteres");
		}
		
		recrutadorExistente.setNome(recrutador.getNome());
		recrutadorExistente.setEmail(recrutador.getEmail());
		recrutadorExistente.setSenha(recrutador.getSenha());
		recrutadorExistente.setNomeEmpresa(recrutador.getNomeEmpresa());
		
		return DtoConverter.toRecrutadorDTO(recrutadorRepository.save(recrutadorExistente));
		

	}
	
	@Transactional
	public UserResponseDto acharUsuarioPorId(Integer userId) {
		User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + userId));
		return DtoConverter.toUserResponseDto(usuario);
	}
	
	@Transactional
	public UserResponseDto acharUsuarioPorEmail(String email) {
		User usuario = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o email: " + email));
		
		return DtoConverter.toUserResponseDto(usuario);
	}

}
