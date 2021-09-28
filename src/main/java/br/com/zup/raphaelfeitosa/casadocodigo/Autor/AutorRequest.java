package br.com.zup.raphaelfeitosa.casadocodigo.Autor;

import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.CampoUnicoGenerico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @CampoUnicoGenerico(
            nomeCampo = "email",
            classeDominio = AutorModel.class,
            message = "Autor ja cadastrado no sistema!")
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
