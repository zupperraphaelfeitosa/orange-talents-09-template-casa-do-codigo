package br.com.zup.raphaelfeitosa.casadocodigo.Cliente;

import br.com.zup.raphaelfeitosa.casadocodigo.Estados.EstadoRepository;
import br.com.zup.raphaelfeitosa.casadocodigo.Pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public String cadastrarCliente(@RequestBody @Valid ClienteRequest clienteRequest) {
        ClienteModel novoCliente = clienteRequest.toClienteModel(paisRepository, estadoRepository);
        clienteRepository.save(novoCliente);
        return novoCliente.toString();
    }
}
