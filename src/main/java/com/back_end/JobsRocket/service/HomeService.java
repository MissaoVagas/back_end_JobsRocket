package com.back_end.JobsRocket.service;

import org.springframework.stereotype.Service;

import com.back_end.JobsRocket.dto.DestaqueDto;
import com.back_end.JobsRocket.dto.CategoriaDto;
import com.back_end.JobsRocket.dto.EmpresaDestaqueDto;

import java.util.List;
import java.util.Arrays;

@Service
public class HomeService {

    public List<DestaqueDto> getDestaques() {
        return Arrays.asList(
                new DestaqueDto("Destaque 1", "Descrição do destaque 1"),
                new DestaqueDto("Destaque 2", "Descrição do destaque 2"));
    }

    public List<CategoriaDto> getCategorias() {
        return Arrays.asList(
                new CategoriaDto("Categoria 1"),
                new CategoriaDto("Categoria 2"));
    }

    public List<EmpresaDestaqueDto> getEmpresasDestaque() {
        return Arrays.asList(
                new EmpresaDestaqueDto("Empresa 1", "Descrição da empresa 1"),
                new EmpresaDestaqueDto("Empresa 2", "Descrição da empresa 2"));
    }
}