package br.edu.inteli.backend.controllers;

import br.edu.inteli.backend.services.TransportService;
import inteli.transport.Transport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST dedicado à gestão de transportes.
 *
 * <p>Este controlador provê um endpoint para acessar a lista completa de transportes disponíveis,
 * possibilitando a consulta de todas as opções de transporte cadastradas no sistema.</p>
 */
@RestController
@RequestMapping("/transports") // Define o caminho base para as requisições a este controlador.
public class TransportController {
    private final TransportService transportService;

    /**
     * Constrói uma instância de TransportController com injeção de dependência do TransportService.
     *
     * <p>Permite ao controlador acessar os serviços relacionados à gestão de transportes,
     * facilitando a recuperação e manipulação de informações sobre os meios de transporte.</p>
     *
     * @param transportService O serviço responsável pelas operações relacionadas a transportes.
     */
    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    /**
     * Endpoint para a obtenção de uma lista com todos os meios de transportes disponíveis.
     *
     * <p>Responde a requisições GET para "/transports", utilizando o TransportService para
     * buscar e retornar todos os meios de transporte registrados. O resultado é encapsulado
     * em uma ResponseEntity contendo a lista de transportes e o status HTTP OK.</p>
     *
     * @return ResponseEntity contendo a lista de meios de transporte e o status HTTP OK.
     */
    @GetMapping // Anotação que mapeia requisições GET para este método.
    public ResponseEntity<List<Transport>> getAllTransports() {
        List<Transport> transports = transportService.getAllTransports();
        return ResponseEntity.ok(transports);
    }
}
