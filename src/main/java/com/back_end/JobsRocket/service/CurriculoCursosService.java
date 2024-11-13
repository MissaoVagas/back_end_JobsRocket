package com.back_end.JobsRocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back_end.JobsRocket.model.CurriculoCursos;
import com.back_end.JobsRocket.model.User;
import com.back_end.JobsRocket.repository.CurriculoCursosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CurriculoCursosService {
	
	@Autowired
	CurriculoCursosRepository cursosRepository;
	
	public CurriculoCursos criarCurso(CurriculoCursos curso) {
		return cursosRepository.save(curso);
	}
	
	public List<CurriculoCursos> listarCursos(){
		return cursosRepository.findAll();
	}
	
	public CurriculoCursos atualizarCurso(CurriculoCursos curso, Integer curso_id) {
		CurriculoCursos cursoExistente = cursosRepository.findById(curso_id)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com o ID: " + curso_id));
		
		cursoExistente.setInstituicao(curso.getInstituicao());
		cursoExistente.setNomeCurso(curso.getNomeCurso());
		cursoExistente.setDuracao(curso.getDuracao());
		cursoExistente.setDescricao(curso.getDescricao());
		
		return cursosRepository.save(cursoExistente);
	}
	
	public void deletarCurso(Integer curso_id) {
		CurriculoCursos cursoExistente = cursosRepository.findById(curso_id)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com o ID: " + curso_id));
		
		cursosRepository.delete(cursoExistente);
	}

}
