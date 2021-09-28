package br.com.zup.raphaelfeitosa.casadocodigo.Categoria;

import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.CategoriaUnica;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @CategoriaUnica
    private String nome;

    public CategoriaRequest(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public CategoriaModel toCategoriaModel() {
        return new CategoriaModel(nome);
    }

}
