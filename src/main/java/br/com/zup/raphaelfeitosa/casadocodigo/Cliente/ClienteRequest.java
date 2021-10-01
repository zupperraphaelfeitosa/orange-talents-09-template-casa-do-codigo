package br.com.zup.raphaelfeitosa.casadocodigo.Cliente;

import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.CPFouCNPJ;
import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.CampoUnicoGenerico;
import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.EstadoPertencenteAPais;
import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.IdNaoExistente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@EstadoPertencenteAPais(classeDominio = ClienteRequest.class)
public class ClienteRequest {

    @NotBlank
    @Email
    @CampoUnicoGenerico(
            nomeCampo = "email",
            classeDominio = ClienteModel.class,
            message = "Já existe um cliente com esse e-mail cadastrado"
    )
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobreNome;

    @NotBlank
    @CampoUnicoGenerico(
            nomeCampo = "documento",
            classeDominio = ClienteModel.class,
            message = "Já existe um cliente com esse documento cadastrado"
    )
    @CPFouCNPJ
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @NotNull
    @IdNaoExistente(
            classeDominio = PaisModel.class,
            message = "Pais não cadastrado no sistema"
    )
    private Long idPais;

    @IdNaoExistente(
            classeDominio = EstadoModel.class,
            message = "Estado não cadastrado no sistema passe valor null"
    )
    private Long idEstado;

    public ClienteRequest(
            String email, String nome, String sobreNome, String documento,
            String endereco, String complemento, String cidade, String telefone,
            String cep, Long idPais, Long idEstado
    ) {
        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.idPais = idPais;
        this.idEstado = idEstado;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public ClienteModel toClienteModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        PaisModel pais = paisRepository.findById(idPais).get();
        ClienteModel cliente = new ClienteModel(email, nome, sobreNome, documento,
                endereco, complemento, cidade, telefone,
                cep, pais);

        if (idEstado != null) {
            Optional<EstadoModel> estado = estadoRepository.findById(idEstado);
            cliente.setEstado(estado.get());
        }
        return cliente;
    }
}
