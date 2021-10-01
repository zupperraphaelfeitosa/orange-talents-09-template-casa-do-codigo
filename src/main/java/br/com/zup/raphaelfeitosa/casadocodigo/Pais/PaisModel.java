package br.com.zup.raphaelfeitosa.casadocodigo.Pais;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaisModel paisModel = (PaisModel) o;

        if (id != null ? !id.equals(paisModel.id) : paisModel.id != null) return false;
        return nome != null ? nome.equals(paisModel.nome) : paisModel.nome == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
