package br.com.zup.raphaelfeitosa.casadocodigo.controllers;

import br.com.zup.raphaelfeitosa.casadocodigo.controllers.dto.request.AutorRequest;
import br.com.zup.raphaelfeitosa.casadocodigo.models.AutorModel;
import br.com.zup.raphaelfeitosa.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void cadastrarAutor(@RequestBody @Valid AutorRequest autorRequest){

        AutorModel novoAutor = autorRequest.toAutorModel();
        autorRepository.save(novoAutor);
    }
}
