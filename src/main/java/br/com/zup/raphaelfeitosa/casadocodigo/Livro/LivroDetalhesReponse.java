package br.com.zup.raphaelfeitosa.casadocodigo.Livro;

import br.com.zup.raphaelfeitosa.casadocodigo.Autor.AutorModel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalhesReponse {


    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer numeroDePaginas;

    private String isbn;

    private LocalDate dataPublicacao;

    private AutorModel autorModel;


    public LivroDetalhesReponse(LivroModel livroModel) {
        this.titulo = livroModel.getTitulo();
        this.resumo = livroModel.getResumo();
        this.sumario = livroModel.getSumario();
        this.preco = livroModel.getPreco();
        this.numeroDePaginas = livroModel.getNumeroDePaginas();
        this.isbn = livroModel.getIsbn();
        this.dataPublicacao = livroModel.getDataPublicacao();
        this.autorModel = livroModel.getAutor();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorModel getAutorModel() {
        return autorModel;
    }
}
