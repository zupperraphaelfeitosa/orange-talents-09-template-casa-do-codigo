package br.com.zup.raphaelfeitosa.casadocodigo.Estado;


import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisRepository;
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
public class EstadoControllerTest {

    private final String uri = "/estados";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PaisRepository paisRepository;


    @Test
    @Order(1)
    @DisplayName("200 OK - Cadastro de estado")
    void cadastroDeEstadoComSucessoRetorno200() throws Exception {
        PaisModel pais = new PaisModel("Brazil");
        paisRepository.save(pais);

        String novoEstado = "{ \n" +
                "\"nome\":\"Pará\",\n" +
                "\"idPais\":1\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoEstado)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    @Order(2)
    @DisplayName("200 OK - Cadastro de Estado em outro país")
    void cadastroDeEstadoEmOutroPaisComSucessoRetorno200() throws Exception {
        PaisModel pais = new PaisModel("Argentina");
        paisRepository.save(pais);

        String novoEstado = "{ \n" +
                "\"nome\":\"Pará\",\n" +
                "\"idPais\":2\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoEstado)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    @Order(3)
    @DisplayName("400 Bad Request  - Cadastro de estado com pais inexistente")
    void cadastroDeEstadoComPaisInexistente() throws Exception {

        String novoEstado = "{ \n" +
                "\"nome\":\"Pará\",\n" +
                "\"idPais\":3\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoEstado)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    @Order(4)
    @DisplayName("400 Bad Request  - Erro estado ja existente no mesmo País")
    void cadastroDeEstadoExistenteNoMesmoPaisRetorno400() throws Exception {

        String novoEstado = "{ \n" +
                "\"nome\":\"Pará\",\n" +
                "\"idPais\":1\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoEstado)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

}
