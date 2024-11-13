package com.back_end.JobsRocket.service;

import com.back_end.JobsRocket.model.CurriculoProfissionais;
import com.back_end.JobsRocket.model.enums.TipoEmprego;
import com.back_end.JobsRocket.repository.CurriculoProfissionaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CurriculoProfissionaisService {

    @Autowired
    private CurriculoProfissionaisRepository repository;

    public List<CurriculoProfissionais> listarTodos() {
        return repository.findAll();
    }

    public Page<CurriculoProfissionais> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public CurriculoProfissionais salvar(CurriculoProfissionais curriculo) {
        validarCurriculo(curriculo);
        return repository.save(curriculo);
    }

    public CurriculoProfissionais buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public CurriculoProfissionais atualizar(CurriculoProfissionais curriculo) {
        if (repository.existsById(curriculo.getId())) {
            return repository.save(curriculo);
        }
        return null; 
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public List<CurriculoProfissionais> buscarPorNomeEmpresa(String nomeEmpresa) {
        return repository.findByNomeEmpresa(nomeEmpresa);
    }

    public List<CurriculoProfissionais> buscarPorCargo(String cargo) {
        return repository.findByCargo(cargo);
    }

    public List<CurriculoProfissionais> buscarPorTipoEmprego(TipoEmprego tipoEmprego) {
        return repository.findByTipoEmprego(tipoEmprego);
    }

   
    private void validarCurriculo(CurriculoProfissionais curriculo) {
        if (curriculo.getNomeEmpresa() == null || curriculo.getCargo() == null) {
            throw new IllegalArgumentException("Nome da empresa e cargo são obrigatórios.");
        }
      
    }
}
