package br.edu.inteli.backend.controllers;

import br.edu.inteli.backend.services.PortService;
import inteli.places.endPlace.Port;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST que gerencia as operações relacionadas aos portos.
 *
 * <p>Este controlador fornece endpoints para acessar informações sobre os portos,
 * permitindo a consulta da lista de todos os portos disponíveis no sistema.</p>
 */
@RestController
@RequestMapping("/ports") // Define o caminho base para todos os endpoints neste controlador.
public class PortController {
    private final PortService portService;

    /**
     * Constrói uma instância de PortController com uma injeção de dependência do PortService.
     *
     * <p>Esta abordagem permite ao controlador acessar os métodos e a lógica de negócios
     * fornecidos pelo PortService, facilitando as operações relacionadas aos portos.</p>
     *
     * @param portService O serviço responsável pelas operações de negócios envolvendo portos.
     */
    public PortController(PortService portService) {
        this.portService = portService;
    }

    /**
     * Endpoint para obter uma lista de todos os portos.
     *
     * <p>Este método manipula requisições GET para "/ports", usando o PortService
     * para recuperar todos os portos disponíveis. A lista de portos é então retornada
     * ao cliente encapsulada em uma ResponseEntity com status HTTP OK.</p>
     *
     * @return ResponseEntity contendo a lista de portos e o status HTTP OK.
     */
    @GetMapping // Mapeia requisições GET para este método.
    public ResponseEntity<List<Port>> getAllPorts() {
        List<Port> ports = portService.getAllPorts();
        return ResponseEntity.ok(ports);
    }

}
