package br.com.zup.raphaelfeitosa.casadocodigo.controllers.dto.request;

import br.com.zup.raphaelfeitosa.casadocodigo.models.AutorModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public AutorModel toAutorModel() {
        return new AutorModel(nome, email, descricao);
    }

}
