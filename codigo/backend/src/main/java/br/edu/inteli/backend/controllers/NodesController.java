package br.edu.inteli.backend.controllers;

import br.edu.inteli.backend.services.NodeService;
import inteli.dellvale.Node;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * Controlador que gerencia as operações de rede (arestas) para a aplicação.
 *
 * <p>Este controlador expõe endpoints para operações com arestas, permitindo
 * a consulta de arestas no sistema. Utiliza o serviço EdgeService para interagir
 * com o conjunto de dados de arestas.</p>
 */
@RestController
@RequestMapping("/nodes")
public class NodesController {
    private final NodeService nodeService;

    /**
     * Construtor com injeção de dependência para o serviço de arestas.
     *
     * <p>Permite a injeção do EdgeService, facilitando a interação com as
     * operações de negócio relacionadas às arestas da rede.</p>
     *
     * @param nodeService Serviço responsável pelas operações e lógica de negócio das arestas.
     */
    @Autowired
    public NodesController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    /**
     * Endpoint para obter todas as arestas disponíveis no sistema.
     *
     * <p>Este método responde a requisições GET para "/edges", retornando uma lista
     * de todas as arestas cadastradas. As arestas são obtidas através do EdgeService,
     * e a resposta é encapsulada em uma ResponseEntity com status HTTP OK.</p>
     *
     * @return ResponseEntity contendo uma lista de arestas e o status HTTP OK.
     */
    @GetMapping("/{product}")
    public ResponseEntity<Node[]> getAllNodes(@PathVariable String product) {
        // A chamada para edgeService.getAllEdges aqui usa parâmetros fixos como exemplo.
        // Em um cenário real, esses parâmetros podem ser dinâmicos, baseados em critérios de filtragem.
        Node[] nodes = this.nodeService.getAllNodes(product);
        return ResponseEntity.ok(nodes);
    }
}
