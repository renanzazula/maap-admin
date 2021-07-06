package com.maap.admin.controller.project;

import com.maap.admin.controller.AbstractRestControllerTest;
import com.maap.admin.domain.Project;
import com.maap.admin.service.project.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {ProjectController.class})
public class ProjectControllerTest extends AbstractRestControllerTest {

    @MockBean
    ProjectService service;

    @Autowired
    MockMvc mockMvc;

    private Project project;

    @BeforeEach
    public void setUp() throws IOException {
        project = newProject();
    }

//    @Test
//    public void testConsultar() throws Exception {
//        Categoria categoria2 = new Categoria();
//        categoria2.setCodigo(2L);
//        categoria2.setNome("bob");
//
//        List<Categoria> categorias = Arrays.asList(categoria, categoria2);
//        when(service.consultar()).thenReturn(categorias);
//        mockMvc.perform(get(CategoriaController.BASE_URL)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)));
//    }
//
//    @Test
//    public void testConsultarByCodigo() throws Exception {
//        when(service.consultarByCodigo(categoria.getCodigo())).thenReturn(categoria);
//        mockMvc.perform(get(CategoriaController.BASE_URL + "/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nome", equalTo(NOME)))
//                .andExpect(jsonPath("$.descricao", equalTo(DESCRICAO)));
//    }

    @Test
    public void testSave() throws Exception {
        when(service.save(project)).thenReturn(project);
        mockMvc.perform(post(ProjectController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(project)))
                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.nome", equalTo(NOME)))
//                .andExpect(jsonPath("$.descricao", equalTo(DESCRICAO)))
        ;
    }

//    @Test
//    public void testDelete() throws Exception {
//        mockMvc.perform(delete(CategoriaController.BASE_URL + "/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    public void testAlterar() throws Exception {
//        when(service.alterar(1L,categoria)).thenReturn(categoria);
//        mockMvc.perform(put(CategoriaController.BASE_URL+"/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(categoria)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nome", equalTo(NOME)))
//                .andExpect(jsonPath("$.descricao", equalTo(DESCRICAO)));
//    }
}