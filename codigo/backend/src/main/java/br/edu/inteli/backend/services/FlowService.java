package br.edu.inteli.backend.services;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import inteli.dellvale.*;
import inteli.algoritmos.*;

/**
 * Serviço para o cálculo de fluxos em uma rede representada por um grafo.
 *
 * <p>Este serviço aplica algoritmos de fluxo máximo, como Ford-Fulkerson e Edmonds-Karp,
 * para determinar os fluxos ótimos em uma rede. A rede é modelada como um grafo direcionado
 * (Digrafo) a partir de uma lista de arestas fornecida.</p>
 */
@Service
public class FlowService {

    /**
     * Calcula e retorna os fluxos máximos usando diferentes algoritmos.
     *
     * <p>Recebe uma lista de arestas que representa as conexões na rede e as utiliza
     * para construir um grafo direcionado. Em seguida, aplica os algoritmos de Ford-Fulkerson
     * e Edmonds-Karp para calcular os fluxos máximos no grafo. Os resultados de cada
     * algoritmo são adicionados a uma lista de inteiros, que é então retornada.</p>
     *
     * @param edges Lista de arestas que representa o grafo.
     * @return Uma lista de inteiros contendo os resultados dos cálculos de fluxo máximo.
     */
    public List<Flow> getAllFlows(List<Edge> edges) {
        long tempoInicial = System.currentTimeMillis();

        List<Flow> flows = new ArrayList<>();
        // Cria um novo objeto Digrafo a partir das arestas fornecidas.
        Flow flow1= new Flow("FF", edges);
        
        flows.add(flow1);
        long intervalo = System.currentTimeMillis() - tempoInicial;
        System.out.println("o fluxo 1:FF executou em " + intervalo+ " ms");
        long tempoInicial2 = System.currentTimeMillis();

        Flow flow2= new Flow("EK", edges);
        flows.add(flow2);
        long intervalo2 = System.currentTimeMillis() - tempoInicial2;
        System.out.println("o fluxo 2:EF executou em " + intervalo2 + " ms");

        

        return flows;
    }
}
