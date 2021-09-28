package br.com.zup.raphaelfeitosa.casadocodigo.Categoria;

import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.CampoUnicoGenerico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @CampoUnicoGenerico(
            nomeCampo = "nome",
            classeDominio = CategoriaModel.class,
            message = "Categoria já cadastrada no sistema!")
    private String nome;

    public CategoriaRequest(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public CategoriaModel toCategoriaModel() {
        return new CategoriaModel(nome);
    }

}
