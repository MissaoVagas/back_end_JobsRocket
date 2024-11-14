package com.back_end.JobsRocket.utils;

import com.back_end.JobsRocket.model.*;

import java.util.ArrayList;
import java.util.List;

import com.back_end.JobsRocket.dto.*;

public class DtoConverter {

	public static CandidatoResponseDto toCandidatoDTO(Candidato candidato) {
        CandidatoResponseDto dto = new CandidatoResponseDto();
        dto.setUser_id(candidato.getUser_id());
        dto.setNome(candidato.getNome());
        dto.setEmail(candidato.getEmail());
        dto.setCampoDeInteresse(candidato.getCampoDeInteresse());
        dto.setRole(candidato.getRole());
        
        if (candidato.getCurriculo() != null) {
        	Curriculo curriculoDTO = new Curriculo();
            curriculoDTO.setCurriculo_id(candidato.getCurriculo().getCurriculo_id());
            dto.setCurriculo(curriculoDTO);
        }
        return dto;
    }

	public static RecrutadorResponseDto toRecrutadorDTO(Recrutador recrutador) {
    	RecrutadorResponseDto dto = new RecrutadorResponseDto();
    	dto.setUser_id(recrutador.getUser_id());
        dto.setNome(recrutador.getNome());
        dto.setEmail(recrutador.getEmail());
        dto.setNomeEmpresa(recrutador.getNomeEmpresa());
        dto.setRole(recrutador.getRole());
        return dto;
    }
	
	public static UserResponseDto toUserResponseDto(User usuario) {
		UserResponseDto dto = new UserResponseDto();
		dto.setUser_id(usuario.getUser_id());
		dto.setNome(usuario.getNome());
		dto.setEmail(usuario.getEmail());
		dto.setRole(usuario.getRole());
		return dto;
	}
	
	public static List<UserResponseDto> toListUserResponseDtos(List<User> usuarios) {
		List<UserResponseDto> userDtos = new ArrayList<>();
		
		for(User usuario: usuarios ) {
			UserResponseDto userDto = DtoConverter.toUserResponseDto(usuario);
			userDtos.add(userDto);
		}
		
		return userDtos;
		
	}
}
