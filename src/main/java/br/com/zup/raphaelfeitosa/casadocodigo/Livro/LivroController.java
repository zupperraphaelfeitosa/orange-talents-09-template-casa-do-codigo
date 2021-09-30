package br.com.zup.raphaelfeitosa.casadocodigo.Livro;

import br.com.zup.raphaelfeitosa.casadocodigo.Autor.AutorRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.Categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public void cadastrarLivro(@RequestBody @Valid LivroRequest livroRequest) {
        LivroModel novoLivro = livroRequest.toLivroModel(categoriaRepository, autorRepository);
        livroRepository.save(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> listarLivros() {
        List<LivroModel> livros = livroRepository.findAll();
        return ResponseEntity.ok(LivroResponse.listaConverter(livros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhesReponse> livroDetalhes(@PathVariable Long id) {
        Optional<LivroModel> livrosDetalhes = livroRepository.findById(id);
        if (livrosDetalhes.isPresent()) {
            return ResponseEntity.ok(new LivroDetalhesReponse(livrosDetalhes.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
