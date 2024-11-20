//package com.back_end.JobsRocket.controller;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import com.back_end.JobsRocket.dto.DestaqueDto;
//import com.back_end.JobsRocket.dto.CategoriaDto;
//import com.back_end.JobsRocket.dto.EmpresaDestaqueDto;
//import com.back_end.JobsRocket.service.HomeService;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//public class HomeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private HomeService homeService;
//
//    @InjectMocks
//    private HomeController homeController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
//    }
//
//    @Test
//    public void testGetDestaques() throws Exception {
//        // Simulando uma lista de destaques
//        DestaqueDto destaque1 = new DestaqueDto(); // Preencha conforme necessário
//        destaque1.setId(1); // Exemplo de preenchimento
//        destaque1.setTitulo("Destaque 1"); // Exemplo de preenchimento
//
//        DestaqueDto destaque2 = new DestaqueDto(); // Preencha conforme necessário
//        destaque2.setId(2); // Exemplo de preenchimento
//        destaque2.setTitulo("Destaque 2"); // Exemplo de preenchimento
//
//        List<DestaqueDto> destaques = Arrays.asList(destaque1, destaque2);
//
//        when(homeService.getDestaques()).thenReturn(destaques);
//
//        mockMvc.perform(get("/api/home/destaques"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2))) // Verifica se a lista tem 2 elementos
//                .andExpect(jsonPath("$[0].titulo").value("Destaque 1")) // Verifica o título do primeiro destaque
//                .andExpect(jsonPath("$[1].titulo").value("Destaque 2")); // Verifica o título do segundo destaque
//    }
//
//    @Test
//    public void testGetCategorias() throws Exception {
//        // Simulando uma lista de categorias
//        CategoriaDto categoria1 = new CategoriaDto(); // Preencha conforme necessário
//        categoria1.setId(1); // Exemplo de preenchimento
//        categoria1.setNome("Categoria 1"); // Exemplo de preenchimento
//
//        CategoriaDto categoria2 = new CategoriaDto(); // Preencha conforme necessário
//        categoria2.setId(2); // Exemplo de preenchimento
//        categoria2.setNome("Categoria 2"); // Exemplo de preenchimento
//
//        List<CategoriaDto> categorias = Arrays.asList(categoria1, categoria2);
//
//        when(homeService.getCategorias()).thenReturn(categorias);
//
//        mockMvc.perform(get("/api/home/categorias"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2))) // Verifica se a lista tem 2 elementos
//                .andExpect(jsonPath("$[0].nome").value("Categoria 1")) // Verifica o nome da primeira categoria
//                .andExpect(jsonPath("$[1].nome").value("Categoria 2")); // Verifica o nome da segunda categoria
//    }
//
//    @Test
//    public void testGetEmpresasDestaque() throws Exception {
//        // Simulando uma lista de empresas em destaque
//        EmpresaDestaqueDto empresaDestaque1 = new EmpresaDestaqueDto(); // Preencha conforme necessário
//        empresaDestaque1.setId(1); // Exemplo de preenchimento
//        empresaDestaque1.setNome("Empresa Destaque 1"); // Exemplo de preenchimento
//
//        EmpresaDestaqueDto empresaDestaque2 = new EmpresaDestaqueDto(); // Preencha conforme necessário
//        empresaDestaque2.setId(2); // Exemplo de preenchimento
//        empresaDestaque2.setNome("Empresa Destaque 2"); // Exemplo de preenchimento
//
//        List<EmpresaDestaqueDto> empresasDestaque = Arrays.asList(empresaDestaque1, empresaDestaque2);
//
//        when(homeService.getEmpresasDestaque()).thenReturn(empresasDestaque);
//
//        mockMvc.perform(get("/api/home/empresas-destaque"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2))) // Verifica se a lista tem 2 elementos
//                .andExpect(jsonPath("$[0].nome").value("Empresa Destaque 1")) // Verifica o nome da primeira empresa em destaque
//                .andExpect(jsonPath("$[1].nome").value("Empresa Destaque 2")); // Verifica o nome da segunda empresa em destaque
//    }
//}
