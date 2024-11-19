package com.back_end.JobsRocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.back_end.JobsRocket.dto.DestaqueDto;
import com.back_end.JobsRocket.dto.CategoriaDto;
import com.back_end.JobsRocket.dto.EmpresaDestaqueDto;
import com.back_end.JobsRocket.service.HomeService;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/destaques")
    public ResponseEntity<List<DestaqueDto>> getDestaques() {
        List<DestaqueDto> destaques = homeService.getDestaques();
        return ResponseEntity.ok(destaques);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDto>> getCategorias() {
        List<CategoriaDto> categorias = homeService.getCategorias();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/empresas-destaque")
    public ResponseEntity<List<EmpresaDestaqueDto>> getEmpresasDestaque() {
        List<EmpresaDestaqueDto> empresasDestaque = homeService.getEmpresasDestaque();
        return ResponseEntity.ok(empresasDestaque);
    }
}