package br.com.zup.raphaelfeitosa.casadocodigo.Cliente;


import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoRepository;
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
public class ClienteControllerTest {

    private final String uri = "/clientes";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Test
    @Order(1)
    @DisplayName("200 OK - Cadastro de cliente")
    void cadastroDeClienteComSucessoRetorno200() throws Exception {
        PaisModel pais = new PaisModel("Brazil");
        paisRepository.save(pais);

        EstadoModel estado = new EstadoModel("Pará", pais);
        estadoRepository.save(estado);

        String novoCliente = "{ \n" +
                "\"email\":\"johndoe@gmail.com\",\n" +
                "\"nome\":\"John\",\n" +
                "\"sobreNome\":\"Doe\",\n" +
                "\"documento\":\"05612261055\",\n" +
                "\"endereco\":\"Rua 3\",\n" +
                "\"complemento\":\"Entre rua 4 e rua 2\",\n" +
                "\"cidade\":\"Santarém\",\n" +
                "\"telefone\":\"99999999999\",\n" +
                "\"cep\":\"68462750\",\n" +
                "\"idPais\":1,\n" +
                "\"idEstado\":1\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoCliente)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    @Order(2)
    @DisplayName("200 OK - Cadastro de cliente com estado null")
    void cadastroDeClienteComEstadoNullSucessoRetorno200() throws Exception {
        String novoCliente = "{ \n" +
                "\"email\":\"mariadoe@gmail.com\",\n" +
                "\"nome\":\"Maria\",\n" +
                "\"sobreNome\":\"Doe\",\n" +
                "\"documento\":\"05612261055\",\n" +
                "\"endereco\":\"Rua 3\",\n" +
                "\"complemento\":\"Entre rua 4 e rua 2\",\n" +
                "\"cidade\":\"Santarém\",\n" +
                "\"telefone\":\"99999999999\",\n" +
                "\"cep\":\"68462750\",\n" +
                "\"idPais\":1,\n" +
                "\"idEstado\":null\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoCliente)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    @Order(3)
    @DisplayName("400 Bad Request - Erro cadastro de cliente com mesmo email e documento")
    void erroCadastroDeClienteComEmailOuDocumentoExistenteSemSucessoRetorno400() throws Exception {

        String novoCliente = "{ \n" +
                "\"email\":\"mariadoe@gmail.com\",\n" +
                "\"nome\":\"Maria\",\n" +
                "\"sobreNome\":\"Doe\",\n" +
                "\"documento\":\"05612261055\",\n" +
                "\"endereco\":\"Rua 3\",\n" +
                "\"complemento\":\"Entre rua 4 e rua 2\",\n" +
                "\"cidade\":\"Santarém\",\n" +
                "\"telefone\":\"99999999999\",\n" +
                "\"cep\":\"68462750\",\n" +
                "\"idPais\":1,\n" +
                "\"idEstado\":null\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoCliente)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    @Order(4)
    @DisplayName("400 Bad Request - Erro cadastro de cliente pais ou estado inexistente")
    void erroCadastroDeClienteComPaisInexistenteSemSucessoRetorno400() throws Exception {

        String novoCliente = "{ \n" +
                "\"email\":\"mariadoe@gmail.com\",\n" +
                "\"nome\":\"Maria\",\n" +
                "\"sobreNome\":\"Doe\",\n" +
                "\"documento\":\"05612261055\",\n" +
                "\"endereco\":\"Rua 3\",\n" +
                "\"complemento\":\"Entre rua 4 e rua 2\",\n" +
                "\"cidade\":\"Santarém\",\n" +
                "\"telefone\":\"99999999999\",\n" +
                "\"cep\":\"68462750\",\n" +
                "\"idPais\":10,\n" +
                "\"idEstado\":10\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoCliente)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }
}
