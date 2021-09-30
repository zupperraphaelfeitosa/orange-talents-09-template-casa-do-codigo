package br.com.zup.raphaelfeitosa.casadocodigo.Estados;

import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.EstadoUnicoNoPaisComRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.IdNaoExistente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoUnicoNoPaisComRepository(
        message = "Estado já cadastrado com esse país")
public class EstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @IdNaoExistente(classeDominio = PaisModel.class,
            message = "Pais não existe no banco de dados")
    private Long idPais;

    public EstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public EstadoModel toEstadoModel(PaisRepository paisRepository) {
        PaisModel pais = paisRepository.findById(idPais).get();
        return new EstadoModel(nome, pais);
    }

    public Long getIdPais() {
        return idPais;
    }

    public String getNome() {
        return nome;
    }
}
