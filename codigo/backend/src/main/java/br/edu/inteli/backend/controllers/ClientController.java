package br.edu.inteli.backend.controllers;

import br.edu.inteli.backend.services.ClientService;
import inteli.places.endPlace.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * O ClientController é responsável por lidar com as solicitações da web relacionadas aos clientes.
 * Ele faz uso do ClientService para buscar informações dos clientes e expõe essas informações
 * através de uma API REST.
 */
@RestController
@RequestMapping("/clients") // Mapeia todas as requisições HTTP para /clients para este controlador.
public class ClientController {
    private final ClientService clientService;

    /**
     * Inicializa uma nova instância do ClientController com um ClientService.
     * A injeção de dependência do ClientService permite que este controlador
     * acesse os métodos de serviço necessários para buscar dados dos clientes.
     *
     * @param clientService O serviço que fornece operações de negócios para clientes.
     */
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Responde a requisições GET para /clients retornando uma lista de todos os clientes.
     * Utiliza o ClientService para obter os dados dos clientes e os retorna encapsulados em
     * uma ResponseEntity.
     *
     * @return Uma ResponseEntity contendo a lista de todos os clientes e o status HTTP OK.
     */
    @GetMapping // Anotação que indica que este método deve ser chamado para requisições GET.
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients(); // Busca todos os clientes através do serviço.
        return ResponseEntity.ok(clients); // Retorna a lista de clientes com status HTTP OK.
    }

}
