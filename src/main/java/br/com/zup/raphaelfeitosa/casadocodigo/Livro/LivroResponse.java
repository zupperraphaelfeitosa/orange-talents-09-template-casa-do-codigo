package br.com.zup.raphaelfeitosa.casadocodigo.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

    private Long id;
    private String nome;

    public LivroResponse(LivroModel livroModel) {
        this.id = livroModel.getId();
        this.nome = livroModel.getTitulo();
    }

    public static List<LivroResponse> listaConverter(List<LivroModel> livros) {
        return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
