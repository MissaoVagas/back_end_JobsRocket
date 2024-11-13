package com.back_end.JobsRocket.service;

import com.back_end.JobsRocket.model.CurriculoPrincipais;
import com.back_end.JobsRocket.repository.CurriculoPrincipaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CurriculoPrincipaisService {

    @Autowired
    private CurriculoPrincipaisRepository repository;

    // Listar todos os currículos principais
    public List<CurriculoPrincipais> listarTodos() {
        return repository.findAll();
    }

    // Listar todos os currículos principais com paginação
    public Page<CurriculoPrincipais> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // Salvar um novo currículo principal
    public CurriculoPrincipais salvar(CurriculoPrincipais curriculoPrincipais) {
        validarCurriculoPrincipais(curriculoPrincipais);
        return repository.save(curriculoPrincipais);
    }

    // Buscar um currículo principal por ID
    public CurriculoPrincipais buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Atualizar um currículo principal existente
    public CurriculoPrincipais atualizar(CurriculoPrincipais curriculoPrincipais) {
        if (repository.existsById(curriculoPrincipais.getPrincipais_id())) {
            validarCurriculoPrincipais(curriculoPrincipais);
            return repository.save(curriculoPrincipais);
        }
        return null; // ou lançar uma exceção
    }

    // Deletar um currículo principal pelo ID
    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    // Validação dos dados de currículo principal
    private void validarCurriculoPrincipais(CurriculoPrincipais curriculoPrincipais) {
        if (curriculoPrincipais.getUsername() == null ||
                curriculoPrincipais.getSobre() == null ||
                curriculoPrincipais.getFoto() == null) {
            throw new IllegalArgumentException("Todos os campos principais são obrigatórios.");
        }
    }
}
