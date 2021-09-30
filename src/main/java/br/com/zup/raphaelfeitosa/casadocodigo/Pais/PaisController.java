package br.com.zup.raphaelfeitosa.casadocodigo.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public void cadastrarPais(@RequestBody @Valid PaisRequest paisRequest) {
        PaisModel novoPais = paisRequest.toPaisModel();
        paisRepository.save(novoPais);
    }
}
