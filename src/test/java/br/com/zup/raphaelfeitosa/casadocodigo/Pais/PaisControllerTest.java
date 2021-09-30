package br.com.zup.raphaelfeitosa.casadocodigo.Pais;


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
public class PaisControllerTest {

    private final String uri = "/pais";

    @Autowired
    private MockMvc mockMvc;


    @Test
    @Order(1)
    @DisplayName("200 OK - Cadastro de pais")
    void cadastroDePaisComSucessoRetorno200() throws Exception {

        String novoPaisRequest = "{\"nome\":\"Brazil\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoPaisRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    @Order(2)
    @DisplayName("400 Bad Request  - Erro campo em branco ou nulo")
    void cadastroDePaisComCampoNuloRetorno400() throws Exception {

        String novoPaisRequest = "{\"nome\":\"\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoPaisRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    @Order(3)
    @DisplayName("400 Bad Request  - Erro pais ja existente")
    void cadastroDeCategoriaExistenteRetorno400() throws Exception {

        String novoPaisRequest = "{\"nome\":\"Brazil\"}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoPaisRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

}
