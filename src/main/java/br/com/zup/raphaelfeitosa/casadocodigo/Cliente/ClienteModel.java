package br.com.zup.raphaelfeitosa.casadocodigo.Cliente;

import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoModel;
import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisModel;

import javax.persistence.*;

@Entity
@Table(name = "tb_clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobreNome;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private PaisModel pais;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoModel estado;

    @Deprecated
    public ClienteModel(){}

    public ClienteModel(String email, String nome, String sobreNome, String documento,
                        String endereco, String complemento, String cidade, String telefone,
                        String cep, PaisModel pais) {
        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
    }

    public void setEstado(EstadoModel estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                " id = " + id +
                " }";
    }
}
