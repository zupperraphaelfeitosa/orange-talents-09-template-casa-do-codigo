package br.com.zup.raphaelfeitosa.casadocodigo.Estados;

import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public void cadastrarEstado(@RequestBody @Valid EstadoRequest estadoRequest){
        EstadoModel novoEstado = estadoRequest.toEstadoModel(paisRepository);
        estadoRepository.save(novoEstado);
    }
}
