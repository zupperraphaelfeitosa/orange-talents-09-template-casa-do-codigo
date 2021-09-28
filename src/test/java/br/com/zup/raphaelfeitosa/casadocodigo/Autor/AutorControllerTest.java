package br.com.zup.raphaelfeitosa.casadocodigo.Autor;


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
public class AutorControllerTest {

    private final String uri = "/autor";

    @Autowired
    private MockMvc mockMvc;


    @Test
    @Order(1)
    @DisplayName("200 OK - Cadastro de autor")
    void cadastroDeAutoComSucessoRetorno200() throws Exception {

        String novoAutorRequest = "{\n" +
                "\"nome\":\"John Doe\",\n" +
                "\"email\":\"johndoe@gmail.com\",\n" +
                "\"descricao\":\"Descrição de cadastro de autor com campo em branco\"\n" +
                "}";

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
    void cadastroDeAutoComCampoNulo() throws Exception {

        String novoAutorRequest = "{\n" +
                "\"nome\":\"\",\n" +
                "\"email\":\"johndoe@gmail.com\",\n" +
                "\"descricao\":\"Descrição de cadastro de autor com email invalido!\"\n" +
                "}";

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
    @DisplayName("400 Bad Request  - Erro email invalido")
    void cadastroDeAutorComEmailInvalido400() throws Exception {

        String novoAutorRequest = "{\n" +
                "\"nome\":\"John Doe\",\n" +
                "\"email\":\"emailinvalido.com\",\n" +
                "\"descricao\":\"Descrição de cadastro de autor realizada com sucesso!\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoAutorRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    @Order(4)
    @DisplayName("400 Bad Request  - Erro email unico")
    void cadastroDeAutorComEmailUnico400() throws Exception {

        String novoAutorRequest = "{\n" +
                "\"nome\":\"John Doe\",\n" +
                "\"email\":\"johndoe@gmail.com\",\n" +
                "\"descricao\":\"Descrição de cadastro de autor com email unico ja cadastrado\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoAutorRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

}
