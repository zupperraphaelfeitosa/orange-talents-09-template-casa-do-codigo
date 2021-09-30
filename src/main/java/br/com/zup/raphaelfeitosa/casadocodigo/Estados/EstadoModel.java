package br.com.zup.raphaelfeitosa.casadocodigo.Estados;

import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisModel;

import javax.persistence.*;

@Entity
@Table(name = "tb_estados")
public class EstadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private PaisModel pais;

    @Deprecated
    public EstadoModel(){}

    public EstadoModel(String nome, PaisModel pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
