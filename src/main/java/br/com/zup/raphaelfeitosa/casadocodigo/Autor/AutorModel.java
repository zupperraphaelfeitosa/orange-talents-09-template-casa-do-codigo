package br.com.zup.raphaelfeitosa.casadocodigo.Autor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_autor")
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDateTime instante = LocalDateTime.now();

    @Column(nullable = false, length = 400)
    private String descricao;

    @Deprecated
    public AutorModel() {
    }

    public AutorModel(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
