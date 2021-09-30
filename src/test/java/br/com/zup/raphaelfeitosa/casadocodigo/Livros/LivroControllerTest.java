package br.com.zup.raphaelfeitosa.casadocodigo.Livros;


import br.com.zup.raphaelfeitosa.casadocodigo.Autor.AutorModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Autor.AutorRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.Categoria.CategoriaModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Categoria.CategoriaRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class LivroControllerTest {

    private final String uri = "/livros";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    @Order(1)
    @DisplayName("200 OK - Cadastro de livro")
    void cadastroDeLivroComSucessoRetorno200() throws Exception {
        AutorModel autor = new AutorModel("Novo Autor", "autor@gmail.com", "Descrição do Autor");
        CategoriaModel categoria = new CategoriaModel("Nova Categoria");
        autorRepository.save(autor);
        categoriaRepository.save(categoria);

        String novoLivro = "{ \n" +
                "\"titulo\":\"Titulo novo livro\",\n" +
                "\"resumo\":\"Resumo do novo livro\",\n" +
                "\"sumario\":\"Sumario de tamanho livre\"," +
                "\"preco\": 50.55,\n" +
                "\"numeroDePaginas\": 100,\n" +
                "\"isbn\":\"978–85–333–0227–1\",\n" +
                "\"dataPublicacao\":\"2021-10-30\",\n" +
                "\"idCategoria\":1,\n" +
                "\"idAutor\":1\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoLivro)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    @Order(2)
    @DisplayName("400 Bad Request  - Cadastro de livro com categoria ou autor inexistente")
    void cadastroDeLivroComCategoriaOuAutorInexistente() throws Exception {

        String novoLivro = "{ \n" +
                "\"titulo\":\"Titulo novo livro\",\n" +
                "\"resumo\":\"Resumo do novo livro\",\n" +
                "\"sumario\":\"Sumario de tamanho livre\"," +
                "\"preco\": 50.55,\n" +
                "\"numeroDePaginas\": 100,\n" +
                "\"isbn\":\"978–85–333–0227–1\",\n" +
                "\"dataPublicacao\":\"2021-10-30\",\n" +
                "\"idCategoria\":2,\n" +
                "\"idAutor\":2\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoLivro)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    @Order(3)
    @DisplayName("400 Bad Request  - Error Cadastro de livro com titulo e isbn existente")
    void cadastroDeAutorComEmailInvalido400() throws Exception {
        String novoLivro = "{ \n" +
                "\"titulo\":\"Titulo novo livro\",\n" +
                "\"resumo\":\"Resumo do novo livro\",\n" +
                "\"sumario\":\"Sumario de tamanho livre\"," +
                "\"preco\": 50.55,\n" +
                "\"numeroDePaginas\": 100,\n" +
                "\"isbn\":\"978–85–333–0227–1\",\n" +
                "\"dataPublicacao\":\"2021-10-30\",\n" +
                "\"idCategoria\":1,\n" +
                "\"idAutor\":1\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(novoLivro)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    @Order(4)
    @DisplayName("200 OK  - Listar todos os livros")
    void listarTodosOsLivrosComSucessoRetorno200() throws Exception {

       MvcResult result =  mockMvc.perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200))
                .andReturn();

       String resultContent = result.getResponse().getContentAsString();
        System.out.println(resultContent);
    }

    @Test
    @Order(5)
    @DisplayName("200 OK  - Listar um livro por Id")
    void listarUmLivroComSucessoRetorno200() throws Exception {

        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders
                        .get(uri+"/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200))
                .andReturn();

        String resultContent = result.getResponse().getContentAsString();
        System.out.println(resultContent);
    }
}
