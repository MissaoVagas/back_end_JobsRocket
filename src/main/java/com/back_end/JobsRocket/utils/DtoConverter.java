package com.back_end.JobsRocket.utils;

import com.back_end.JobsRocket.model.*;

import java.util.ArrayList;
import java.util.List;

import com.back_end.JobsRocket.dto.*;

public class DtoConverter {

	public static CandidatoDto toCandidatoDTO(Candidato candidato) {
        CandidatoDto dto = new CandidatoDto();
        dto.setUser_id(candidato.getUser_id());
        dto.setNome(candidato.getNome());
        dto.setEmail(candidato.getEmail());
        dto.setCampoDeInteresse(candidato.getCampoDeInteresse());
        
        if (candidato.getCurriculo() != null) {
        	Curriculo curriculoDTO = new Curriculo();
            curriculoDTO.setCurriculo_id(candidato.getCurriculo().getCurriculo_id());
            dto.setCurriculo(curriculoDTO);
        }
        return dto;
    }

	public static RecrutadorDto toRecrutadorDTO(Recrutador recrutador) {
    	RecrutadorDto dto = new RecrutadorDto();
        dto.setUser_id(recrutador.getUser_id());
        dto.setNome(recrutador.getNome());
        dto.setEmail(recrutador.getEmail());
        dto.setNomeEmpresa(recrutador.getNomeEmpresa());
        return dto;
    }
	
	public static UserDto toUserDTO(User usuario) {
		UserDto dto = new UserDto();
		dto.setUser_id(usuario.getUser_id());
		dto.setNome(usuario.getNome());
		dto.setEmail(usuario.getEmail());
		dto.setRole(usuario.getRole());
		return dto;
	}
	
	public static List<UserDto> toListUserDTO(List<User> usuarios) {
		List<UserDto> userDtos = new ArrayList<>();
		
		for(User usuario: usuarios ) {
			UserDto userDto = DtoConverter.toUserDTO(usuario);
			userDtos.add(userDto);
		}
		
		return userDtos;
		
	}
}
