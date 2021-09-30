package br.com.zup.raphaelfeitosa.casadocodigo.Pais;

import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.CampoUnicoGenerico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @CampoUnicoGenerico(
            nomeCampo = "nome",
            classeDominio = PaisModel.class,
            message = "Pais já cadastrado no banco de dados!")
    private String nome;

    public PaisRequest(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public PaisModel toPaisModel() {
        return new PaisModel(nome);
    }
}
