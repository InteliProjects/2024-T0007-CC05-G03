package inteli.algoritmos;

import inteli.dellvale.Digrafo;
import inteli.places.Place;
import inteli.transport.Transport;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * A classe FordFulkerson implementa o algoritmo de Ford-Fulkerson para calcular o fluxo máximo em uma rede de fluxo.
 * Este algoritmo é útil para resolver problemas de fluxo máximo, como encontrar a capacidade máxima de rede
 * que pode ser enviada de uma fonte para um sumidouro sem exceder a capacidade das arestas na rede.
 */
public class FordFulkerson {

    private int numberOfNodes;
    private Place[] places;
    private Transport[] transports;
    private Digrafo graph;

    /**
     * Construtor para inicializar a rede de fluxo com um determinado número de nós.
     *
     * @param graph O número de nós na rede.
     */
    public FordFulkerson( Digrafo graph) {
        this.numberOfNodes = graph.getV();
        this.graph = graph;
    }

    /**
     * Adiciona uma aresta ao gráfico da rede de fluxo. Este método ainda precisa ser implementado.
     *
     * @param from O índice do nó de origem da aresta.
     * @param to O índice do nó de destino da aresta.
     * @param capacity A capacidade de fluxo da aresta.
     */

    /**
     * Verifica a existência de um caminho de aumento da origem para o destino no gráfico residual.
     * Utiliza busca em largura para encontrar tal caminho.
     *
     * @param residualGraph O gráfico residual atual.
     * @param origin O índice do nó de origem.
     * @param destiny O índice do nó de destino.
     * @param parent Array que armazena o caminho encontrado.
     * @return true se um caminho de aumento for encontrado, false caso contrário.
     */
    private boolean hasPath(int[][] residualGraph, int origin, int destiny, int[] parent) {
        boolean[] visited = new boolean[numberOfNodes];
        Arrays.fill(visited, false);
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(origin);

        visited[origin] = true;
        parent[origin] = -1;

        while (!queue.isEmpty()) {
            int removeNode = queue.poll();

            for (int v = 0; v < numberOfNodes; v++) {
                if (!visited[v] && residualGraph[removeNode][v] > 0) {
                    queue.add(v);
                    parent[v] = removeNode;
                    visited[v] = true;
                }
            }
        }

        return visited[destiny];
    }

    /**
     * Calcula o fluxo máximo de um nó de origem para um nó de destino utilizando o algoritmo de Ford-Fulkerson.
     *
     * @param graph A matriz representando o gráfico da rede de fluxo, onde cada elemento graph[i][j] representa a capacidade da aresta de i para j.
     * @param origin O índice do nó de origem.
     * @param destiny O índice do nó de destino.
     * @return O valor do fluxo máximo possível.
     */
    public int fordFulkerson(int graph[][], int origin, int destiny) {
        int u, v;
        int[][] residualGraph = new int[numberOfNodes][numberOfNodes];

        for (u = 0; u < numberOfNodes; u++)
            for (v = 0; v < numberOfNodes; v++)
                residualGraph[u][v] = graph[u][v];

        int[] parent = new int[numberOfNodes];
        int maxFlow = 0;

        while (hasPath(residualGraph, origin, destiny, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (v = destiny; v != origin; v = parent[v]) {
                u = parent[v];

                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            for (v = destiny; v != origin; v = parent[v]) {
                u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
                if (this.graph.getEdge(u, v)!=null)
                    this.graph.getEdge(u, v).incFlow(pathFlow);

            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    /**
     * Método principal para executar o algoritmo FordFulkerson. Define um gráfico de exemplo e calcula o fluxo máximo.
     *
     * @param args Argumentos de linha de comando (não usados).
     */
    public static void main(String[] args) {
        int numberOfNodes = 6; // Exemplo com 6 nós

        //FordFulkerson fordFulkerson = new FordFulkerson(numberOfNodes);

        //int graph[][] = new int[][] {
         //       {0, 16, 13, 0, 0, 0},
        //        {0, 0, 10, 12, 0, 0},
       //         {0, 4, 0, 0, 14, 0},
       //         {0, 0, 9, 0, 0, 20},
        //        {0, 0, 0, 7, 0, 4},
       //         {0, 0, 0, 0, 0, 0}};

       // int origin = 0; // Nó de origem
        //int destiny = 5;   // Nó de destino

        //int maxFlow = fordFulkerson.fordFulkerson(graph, origin, destiny);
        //System.out.println("Fluxo máximo possível: " + maxFlow);
    }
}
