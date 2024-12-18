package com.back_end.JobsRocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.back_end.JobsRocket.dto.CurriculoRequestDto;
import com.back_end.JobsRocket.dto.CurriculoResponseDto;
import com.back_end.JobsRocket.model.Candidato;
import com.back_end.JobsRocket.model.Curriculo;
import com.back_end.JobsRocket.model.CurriculoAcademicos;
import com.back_end.JobsRocket.model.CurriculoCursos;
import com.back_end.JobsRocket.model.CurriculoPessoais;
import com.back_end.JobsRocket.model.CurriculoPrincipais;
import com.back_end.JobsRocket.model.CurriculoProfissionais;
import com.back_end.JobsRocket.repository.CandidatoRepository;
import com.back_end.JobsRocket.repository.CurriculoRepository;
import com.back_end.JobsRocket.utils.DtoConverter;
import com.back_end.JobsRocket.utils.EntityConverter;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CurriculoService {
	
	@Autowired
	CurriculoRepository curriculoRepository;
	
	@Autowired
	CandidatoRepository candidatoRepository;
	
	@Autowired
	CurriculoPessoaisService pessoaisService;
	
	@Autowired
	CurriculoPrincipaisService principaisService;
	
	@Autowired
	CurriculoAcademicosService academicosService;
	
	@Autowired
	CurriculoProfissionaisService profissionaisService;
	
	@Autowired
	CurriculoCursosService cursosService;
	
	
	@Transactional
	public CurriculoResponseDto criarCurriculo(CurriculoRequestDto curriculoRequest, Integer candidato_id) {
		
		Curriculo curriculo = EntityConverter.toEntityCurriculo(curriculoRequest);
		
		Candidato candidatoExistente = candidatoRepository.findById(candidato_id)
                .orElseThrow(() -> new EntityNotFoundException("Candidato não encontrado com o ID: " + candidato_id));
		
		curriculo.setCandidato(candidatoExistente);
		
		CurriculoPessoais pessoais = curriculo.getPessoais();
		pessoais.setCurriculo(curriculo);
		pessoaisService.salvar(pessoais);
		
		CurriculoPrincipais principais = curriculo.getPrincipais();
		principais.setCurriculo(curriculo);
		principaisService.salvar(principais);
		
		if (curriculo.getAcademicos() != null) {
	        for (CurriculoAcademicos item : curriculo.getAcademicos()) {
	            item.setCurriculo(curriculo);
	        }
	    }

	    if (curriculo.getProfissionais() != null) {
	        for (CurriculoProfissionais item : curriculo.getProfissionais()) {
	            item.setCurriculo(curriculo);
	        }
	    }

	    if (curriculo.getCursos() != null) {
	        for (CurriculoCursos item : curriculo.getCursos()) {
	            item.setCurriculo(curriculo);
	        }
	    }

	    // Salva o Curriculo e todas as entidades associadas devido ao CascadeType.ALL
	    Curriculo curriculoSalvo = curriculoRepository.save(curriculo);
	    
	    return DtoConverter.toCurriculoResponseDto(curriculoSalvo);
	}
	
	@Transactional
	public List<CurriculoResponseDto> listarCurriculos(){
		return DtoConverter.toCurriculoResponseDtoList(curriculoRepository.findAll());
	}
	
	@Transactional
	public CurriculoResponseDto acharCurriculoPorId(Integer curriculo_id) {
		Curriculo curriculoExistente = curriculoRepository.findById(curriculo_id)
	            .orElseThrow(() -> new EntityNotFoundException("Curriculo não encontrado com o ID " + curriculo_id));
		return DtoConverter.toCurriculoResponseDto(curriculoExistente);
	}
	
	@Transactional
	public CurriculoResponseDto atualizarCurriculo(Curriculo curriculo, Integer curriculo_id) {
		Curriculo curriculoExistente = curriculoRepository.findById(curriculo_id)
	            .orElseThrow(() -> new EntityNotFoundException("Curriculo não encontrado com o ID " + curriculo_id));
		
		curriculoExistente.setPessoais(curriculo.getPessoais());
		curriculoExistente.setPrincipais(curriculo.getPrincipais());
		
		// Atualizar acadêmicos
	    curriculoExistente.getAcademicos().clear();
	    if (curriculo.getAcademicos() != null) {
	        for (CurriculoAcademicos academico : curriculo.getAcademicos()) {
	            academico.setCurriculo(curriculoExistente); // Garantir a referência bidirecional
	            curriculoExistente.getAcademicos().add(academico);
	        }
	    }

	    // Atualizar profissionais
	    curriculoExistente.getProfissionais().clear();
	    if (curriculo.getProfissionais() != null) {
	        for (CurriculoProfissionais profissional : curriculo.getProfissionais()) {
	            profissional.setCurriculo(curriculoExistente);
	            curriculoExistente.getProfissionais().add(profissional);
	        }
	    }

	    // Atualizar cursos
	    curriculoExistente.getCursos().clear();
	    if (curriculo.getCursos() != null) {
	        for (CurriculoCursos curso : curriculo.getCursos()) {
	            curso.setCurriculo(curriculoExistente);
	            curriculoExistente.getCursos().add(curso);
	        }
	    }

	    // Salva o Curriculo atualizado e suas associações (cascade all cuidará das mudanças)
	    return DtoConverter.toCurriculoResponseDto(curriculoRepository.save(curriculoExistente));
	}
	
	@Transactional
	public void deletarCurriculo(Integer curriculo_id) {
		Curriculo curriculoExistente = curriculoRepository.findById(curriculo_id)
	            .orElseThrow(() -> new EntityNotFoundException("Curriculo não encontrado com o ID " + curriculo_id));
		pessoaisService.deletar(curriculoExistente.getPessoais().getPessoais_id());
		principaisService.deletar(curriculoExistente.getPrincipais().getPrincipais_id());
		curriculoRepository.delete(curriculoExistente);
	}

}
