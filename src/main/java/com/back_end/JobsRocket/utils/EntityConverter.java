package com.back_end.JobsRocket.utils;

import java.util.ArrayList;
import java.util.List;

import com.back_end.JobsRocket.dto.CurriculoAcademicosDto;
import com.back_end.JobsRocket.dto.CurriculoCursosDto;
import com.back_end.JobsRocket.dto.CurriculoPessoaisDto;
import com.back_end.JobsRocket.dto.CurriculoPrincipaisDto;
import com.back_end.JobsRocket.dto.CurriculoProfissionaisDto;
import com.back_end.JobsRocket.dto.CurriculoRequestDto;
import com.back_end.JobsRocket.dto.UserRequestDto;
import com.back_end.JobsRocket.model.Curriculo;
import com.back_end.JobsRocket.model.CurriculoAcademicos;
import com.back_end.JobsRocket.model.CurriculoCursos;
import com.back_end.JobsRocket.model.CurriculoPessoais;
import com.back_end.JobsRocket.model.CurriculoPrincipais;
import com.back_end.JobsRocket.model.CurriculoProfissionais;
import com.back_end.JobsRocket.model.User;

public class EntityConverter {
	
	public static CurriculoAcademicos toEntityAcademicos(CurriculoAcademicosDto academicosDto) {
		CurriculoAcademicos academicos = new CurriculoAcademicos();
		
		academicos.setAtividadesExtras(academicosDto.getAtividadesExtras());
		academicos.setDataFinal(academicosDto.getDataFinal());
		academicos.setDataInicio(academicosDto.getDataInicio());
		academicos.setNomeCurso(academicosDto.getNomeCurso());
		academicos.setNomeFaculdade(academicosDto.getNomeFaculdade());
		academicos.setStatusFaculdade(academicosDto.getStatusFaculdade());
		academicos.setTipoCurso(academicosDto.getTipoCurso());
		academicos.setTipoFormacao(academicosDto.getTipoFormacao());
		
		return academicos;
	}
	
	public static List<CurriculoAcademicos> toEntityAcademicosList(List<CurriculoAcademicosDto> academicosDtoList){
		List<CurriculoAcademicos> academicosList = new ArrayList<>();
		
		for(CurriculoAcademicosDto academicosDto: academicosDtoList) {
			CurriculoAcademicos academico = EntityConverter.toEntityAcademicos(academicosDto);
			academicosList.add(academico);
		}
		
		return academicosList;
	}
	
	public static CurriculoPessoais toEntityPessoais(CurriculoPessoaisDto pessoaisDto) {
		CurriculoPessoais pessoais = new CurriculoPessoais();
		
		pessoais.setCep(pessoaisDto.getCep());
		pessoais.setCidade(pessoaisDto.getCidade());;
		pessoais.setDataNascimento(pessoaisDto.getDataNascimento());
		pessoais.setEndereco(pessoaisDto.getEndereco());
		pessoais.setEstado(pessoaisDto.getEstado());
		pessoais.setGithub(pessoaisDto.getGithub());
		pessoais.setLinkedin(pessoaisDto.getLinkedin());
		pessoais.setPais(pessoaisDto.getPais());
		pessoais.setPortfolioUrl(pessoaisDto.getPortfolioUrl());
		
		return pessoais;
	}
	
	public static CurriculoPrincipais toEntityPrincipais(CurriculoPrincipaisDto principaisDto) {
		CurriculoPrincipais principais = new CurriculoPrincipais();
		
		principais.setUsername(principaisDto.getUsername());
		principais.setFoto(principaisDto.getFoto());
		principais.setSobre(principaisDto.getSobre());
		
		return principais;
	}
	
	public static CurriculoProfissionais toEntityProfissionais(CurriculoProfissionaisDto profissionaisDto) {
		CurriculoProfissionais profissionais = new CurriculoProfissionais();
		
		profissionais.setCargo(profissionaisDto.getCargo());
		profissionais.setDataFinal(profissionaisDto.getDataFinal());
		profissionais.setDataInicio(profissionaisDto.getDataInicio());
		profissionais.setNomeEmpresa(profissionaisDto.getNomeEmpresa());
		profissionais.setResponsabilidades(profissionais.getResponsabilidades());
		profissionais.setTipoEmprego(profissionaisDto.getTipoEmprego());
		
		return profissionais;
	}
	
	public static List<CurriculoProfissionais> toEntityProfissionaisList(List<CurriculoProfissionaisDto> profissionaisDtoList){
		List<CurriculoProfissionais> profissionaisList = new ArrayList<>();
		
		for(CurriculoProfissionaisDto profissionaisDto: profissionaisDtoList) {
			CurriculoProfissionais profissionais = EntityConverter.toEntityProfissionais(profissionaisDto);
			profissionaisList.add(profissionais);
		}
		
		return profissionaisList;
	}
	
	public static CurriculoCursos toEntityCursos(CurriculoCursosDto cursosDto) {
		CurriculoCursos cursos = new CurriculoCursos();
		
		cursos.setDescricao(cursosDto.getDescricao());
		cursos.setDuracao(cursosDto.getDuracao());
		cursos.setInstituicao(cursosDto.getInstituicao());
		cursos.setNomeCurso(cursosDto.getNomeCurso());
		
		return cursos;
	}
	
	public static List<CurriculoCursos> toEntityCursosList(List<CurriculoCursosDto> cursosDtoList){
		List<CurriculoCursos> cursosList = new ArrayList<>();
		
		for(CurriculoCursosDto cursosDto: cursosDtoList) {
			CurriculoCursos cursos = EntityConverter.toEntityCursos(cursosDto);
			cursosList.add(cursos);
		}
		
		return cursosList;
	}
	
	
	public static Curriculo toEntityCurriculo(CurriculoRequestDto requestDto) {
		Curriculo curriculo = new Curriculo();
		
		curriculo.setAcademicos(EntityConverter.toEntityAcademicosList(requestDto.getAcademicos()));
		curriculo.setCursos(EntityConverter.toEntityCursosList(requestDto.getCursos()));
		curriculo.setProfissionais(EntityConverter.toEntityProfissionaisList(requestDto.getProfissionais()));
		curriculo.setPessoais(EntityConverter.toEntityPessoais(requestDto.getPessoais()));
		curriculo.setPrincipais(EntityConverter.toEntityPrincipais(requestDto.getPrincipais()));
		
		return curriculo;
	} 
	
	public static User toEntityUser(UserRequestDto userDto) {
		User user = new User();
		
		user.setNome(userDto.getNome());
		user.setEmail(userDto.getEmail());
		user.setRole(userDto.getRole());
		user.setSenha(userDto.getSenha());
		
		return user;
	}

}
