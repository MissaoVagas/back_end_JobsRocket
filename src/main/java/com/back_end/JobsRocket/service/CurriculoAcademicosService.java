package com.back_end.JobsRocket.service;

import com.back_end.JobsRocket.model.CurriculoAcademicos;
import com.back_end.JobsRocket.model.enums.Status;
import com.back_end.JobsRocket.repository.CurriculoAcademicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CurriculoAcademicosService {

    @Autowired
    private CurriculoAcademicosRepository repository;

    // Listar todos os currículos acadêmicos
    public List<CurriculoAcademicos> listarTodos() {
        return repository.findAll();
    }

    // Listar todos os currículos acadêmicos com paginação
    public Page<CurriculoAcademicos> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // Salvar um novo currículo acadêmico
    public CurriculoAcademicos salvar(CurriculoAcademicos curriculo) {
        validarCurriculo(curriculo);
        return repository.save(curriculo);
    }

    // Buscar um currículo acadêmico por ID
    public CurriculoAcademicos buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Atualizar um currículo acadêmico existente
    public CurriculoAcademicos atualizar(CurriculoAcademicos curriculo) {
        if (repository.existsById(curriculo.getId())) {
            validarCurriculo(curriculo);
            return repository.save(curriculo);
        }
        return null; // ou lançar uma exceção
    }

    // Deletar um currículo acadêmico pelo ID
    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    // Buscar por nome da faculdade
    public List<CurriculoAcademicos> buscarPorNomeFaculdade(String nomeFaculdade) {
        return repository.findByNomeFaculdade(nomeFaculdade);
    }

    // Buscar por nome do curso
    public List<CurriculoAcademicos> buscarPorNomeCurso(String nomeCurso) {
        return repository.findByNomeCurso(nomeCurso);
    }

    // Buscar por status da faculdade
    public List<CurriculoAcademicos> buscarPorStatusFaculdade(Status statusFaculdade) {
        return repository.findByStatusFaculdade(statusFaculdade);
    }



    private void validarCurriculo(CurriculoAcademicos curriculo) {
        if (curriculo.getNomeFaculdade() == null || curriculo.getNomeCurso() == null) {
            throw new IllegalArgumentException("Nome da faculdade e curso são obrigatórios.");
        }
        // Outras validações conforme necessário
    }
}
