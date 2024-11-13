package com.back_end.JobsRocket.service;

import com.back_end.JobsRocket.model.CurriculoPessoais;
import com.back_end.JobsRocket.repository.CurriculoPessoaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculoPessoaisService {

    @Autowired
    private CurriculoPessoaisRepository repository;

    // Listar todos os currículos pessoais
    public List<CurriculoPessoais> listarTodos() {
        return repository.findAll();
    }

    // Listar todos os currículos pessoais com paginação
    public Page<CurriculoPessoais> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // Salvar um novo currículo pessoal
    public CurriculoPessoais salvar(CurriculoPessoais curriculoPessoais) {
        validarCurriculoPessoais(curriculoPessoais);
        return repository.save(curriculoPessoais);
    }

    // Buscar um currículo pessoal por ID
    public CurriculoPessoais buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Atualizar um currículo pessoal existente
    public CurriculoPessoais atualizar(CurriculoPessoais curriculoPessoais) {
        if (repository.existsById(curriculoPessoais.getPessoais_id())) {
            validarCurriculoPessoais(curriculoPessoais);
            return repository.save(curriculoPessoais);
        }
        return null; // ou lançar uma exceção
    }

    // Deletar um currículo pessoal pelo ID
    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    // Validação dos dados de currículo pessoal
    private void validarCurriculoPessoais(CurriculoPessoais curriculoPessoais) {
        if (curriculoPessoais.getDataNascimento() == null ||
                curriculoPessoais.getPais() == null ||
                curriculoPessoais.getCep() == null ||
                curriculoPessoais.getEstado() == null ||
                curriculoPessoais.getCidade() == null ||
                curriculoPessoais.getEndereco() == null ||
                curriculoPessoais.getLinkedin() == null ||
                curriculoPessoais.getGithub() == null ||
                curriculoPessoais.getPortfolioUrl() == null) {
            throw new IllegalArgumentException("Todos os campos pessoais são obrigatórios.");
        }
    }
}
