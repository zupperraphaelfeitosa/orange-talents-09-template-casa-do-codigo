package br.com.zup.raphaelfeitosa.casadocodigo.Pais;

import javax.persistence.*;

@Entity
@Table(name = "tb_pais")
public class PaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    public PaisModel(){}

    public PaisModel(String nome) {
        this.nome = nome;
    }

}
