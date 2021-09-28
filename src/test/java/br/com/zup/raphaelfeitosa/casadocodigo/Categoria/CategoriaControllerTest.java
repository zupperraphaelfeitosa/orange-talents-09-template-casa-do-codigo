package br.com.zup.raphaelfeitosa.casadocodigo.Categoria;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class CategoriaControllerTest {

    private final String uri = "/categorias";

    @Autowired
    private MockMvc mockMvc;


    @Test
    @Order(1)
    @DisplayName("200 OK - Cadastro de categoria")
    void cadastroDeCategoriaComSucessoRetorno200() throws Exception {

        String novoAutorRequest = "{\"nome\":\"NovaCategoria\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoAutorRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    @Order(2)
    @DisplayName("400 Bad Request  - Erro campo em branco ou nulo")
    void cadastroDeCategoriaComCampoNuloRetorno400() throws Exception {

        String novoAutorRequest = "{\"nome\":\"\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoAutorRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    @Order(3)
    @DisplayName("400 Bad Request  - Erro categoria ja existente")
    void cadastroDeCategoriaExistenteRetorno400() throws Exception {

        String novoAutorRequest = "{\"nome\":\"NovaCategoria\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoAutorRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

}
