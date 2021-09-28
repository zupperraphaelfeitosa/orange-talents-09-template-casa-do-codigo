package br.com.zup.raphaelfeitosa.casadocodigo.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void cadastrarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest){
        CategoriaModel novaCategoria = categoriaRequest.toCategoriaModel();
        categoriaRepository.save(novaCategoria);
    }
}
