package br.edu.inteli.backend.controllers;

import br.edu.inteli.backend.services.EdgeService;
import br.edu.inteli.backend.services.FlowService;
import inteli.dellvale.Edge;

import inteli.dellvale.Flow;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

/**
 * Controlador que gerencia as operações relacionadas aos fluxos na rede.
 *
 * <p>Este controlador expõe endpoints para consultas sobre os fluxos em
 * uma rede, utilizando serviços para interagir com os dados de arestas e
 * calcular os fluxos baseando-se nos critérios especificados nas requisições.</p>
 */
@RestController
@RequestMapping("/flow")
public class FlowController {
    private final FlowService flowService;
    private final EdgeService edgeService;

    /**
     * Construtor com injeção de dependência para os serviços de fluxo e de arestas.
     *
     * <p>Facilita a manipulação de dados e operações de lógica de negócio relacionadas
     * aos fluxos e arestas na rede.</p>
     *
     * @param flowService Serviço responsável pelas operações e lógica de negócio de fluxos.
     * @param edgeService Serviço responsável pelas operações e lógica de negócio de arestas.
     */
    @Autowired
    public FlowController(FlowService flowService, EdgeService edgeService) {
        this.flowService = flowService;
        this.edgeService = edgeService;
    }

    /**
     * Endpoint para obter todos os fluxos baseando-se no produto e no identificador.
     *
     * <p>Este método responde a requisições GET para "/flow/{product}/{id}", onde
     * {product} é o identificador do produto e {id} é o identificador numérico para
     * filtragem das arestas. Calcula e retorna os fluxos nas arestas especificadas.</p>
     *
     * @param product O identificador do produto para filtrar as arestas.
     * @return ResponseEntity contendo uma lista dos fluxos calculados e o status HTTP OK.
     */
    @GetMapping("/{product}")
    public ResponseEntity<List<Flow>> getAllFlows(@PathVariable String product) {
        long tempoInicial = System.currentTimeMillis();
        List<Edge> edges;
        edges = edgeService.getAllEdges(product);
        long intervalo = System.currentTimeMillis() - tempoInicial;
        System.out.println("A leitura do XML executou em " + intervalo+ " ms");
        List<Flow> flows = flowService.getAllFlows(edges);
        


        return ResponseEntity.ok(flows);
    }
}
