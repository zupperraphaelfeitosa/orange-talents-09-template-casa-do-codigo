package br.com.zup.raphaelfeitosa.casadocodigo.Livro;

import br.com.zup.raphaelfeitosa.casadocodigo.Autor.AutorModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Autor.AutorRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.Categoria.CategoriaModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Categoria.CategoriaRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.CampoUnicoGenerico;
import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.IdNaoExistente;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroRequest {

    @NotBlank
    @CampoUnicoGenerico(nomeCampo = "titulo",
            classeDominio = LivroModel.class,
            message = "Titulo do livro já cadastrado!")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank
    @CampoUnicoGenerico(nomeCampo = "isbn",
            classeDominio = LivroModel.class,
            message = "ISBN já cadastrado!")
    private String isbn;

    @Future
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @IdNaoExistente(classeDominio = CategoriaModel.class,
            message = "Categoria não existe no banco de dados!")
    private Long idCategoria;

    @NotNull
    @IdNaoExistente(classeDominio = AutorModel.class,
            message = "Autor não existe no banco de dados!")
    private Long idAutor;

    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco,
                        Integer numeroDePaginas, String isbn, LocalDate dataPublicacao,
                        Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public LivroModel toLivroModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        CategoriaModel categoria = categoriaRepository.findById(idCategoria).get();
        AutorModel autor = autorRepository.findById(idAutor).get();

        return new LivroModel(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataPublicacao, categoria, autor);

    }

}
