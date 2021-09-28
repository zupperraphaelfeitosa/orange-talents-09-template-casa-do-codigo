package br.com.zup.raphaelfeitosa.casadocodigo.Categoria;

import br.com.zup.raphaelfeitosa.casadocodigo.validation.annotations.CategoriaUnica;

import javax.persistence.*;

@Entity
@Table(name = "tb_categorias")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    public CategoriaModel() {
    }

    public CategoriaModel(String nome) {
        this.nome = nome;
    }
}
