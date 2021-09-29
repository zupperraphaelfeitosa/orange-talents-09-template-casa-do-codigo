package br.com.zup.raphaelfeitosa.casadocodigo.Livro;

import br.com.zup.raphaelfeitosa.casadocodigo.Autor.AutorModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Categoria.CategoriaModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_livros")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String resumo;

    @Lob
    private String sumario;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer numeroDePaginas;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaModel categoria;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private AutorModel autor;

    @Deprecated
    public LivroModel() {
    }

    public LivroModel(String titulo, String resumo, String sumario, BigDecimal preco,
                      Integer numeroDePaginas, String isbn, LocalDate dataPublicacao,
                      CategoriaModel categoria, AutorModel autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
