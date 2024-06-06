package inteli.algoritmos;

import inteli.dellvale.Digrafo;
import inteli.dellvale.Edge;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 A classe EdmondsKarp implementa o algoritmo de fluxo máximo Edmonds-Karp de um grafo da classe Graph.
 */

public class EdmondsKarp {

    private double[][] flow; // matriz para armazenar o fluxo máximo entre os vértices i e j
    private boolean[] visited; // array que verifica se o vértice foi visitado
    private int[] parent; // array para armazenar os pais dos vértices visitados
    private boolean path; // verifica se ainda há um caminho de aumento de fluxo
    private Digrafo graph; // grafo no qual estamos calculando o fluxo máximo;

    public EdmondsKarp(Digrafo graph) { // inicializa a classe passando um grafo como parâmetro para o construtor
        this.graph = graph;
        this.flow = new double[graph.getV()][graph.getV()];
        this.parent = new int[graph.getV()];
        this.visited = new boolean[graph.getV()];
        this.path = true;

    }

    public double getMaxFlow(int s, int t) { // método para calcular e retornar o fluxo máximo da fonte s até sumidouro t
        while (path == true) { // loop enquanto ainda existir um caminho de aumento de fluxo
            final Queue<Integer> Q = new ArrayDeque<Integer>();
            Q.add(s);

            // reinicializa os vértices visitados para cada nova iteração do loop
            for (int i = 0; i < graph.getV(); i++) {
                visited[i] = false;
            }
            visited[s] = true;
            boolean check = false;
            int current;
            while (!Q.isEmpty()) {
                current = Q.poll();
                if (current == t) {
                    check = true;
                    break;
                }
                for (Edge node : this.graph.getAdj(current)){
                    int nodeIndex = this.graph.getNodeIndex(node.getDestiny().intValue());
                    if (!visited[nodeIndex] && this.graph.getAdjMatrix()[current][nodeIndex] > flow[current][nodeIndex]) {
                        visited[nodeIndex] = true;
                        Q.add(nodeIndex);
                        parent[nodeIndex] = current;

                    }

                }
            }
            if (check == false) {
                break; // nenhum caminho de aumento foi encontrado, termina o loop
            }

            // calcula o fluxo adicional que pode ser enviado ao longo do caminho encontrado
            double temp = graph.getAdjMatrix()[parent[t]][t] - flow[parent[t]][t];
            for (int k = t; k != s; k = parent[k]) {
                temp = Math.min(temp, (graph.getAdjMatrix()[parent[k]][k] - flow[parent[k]][k]));
            }

            // atualiza o fluxo ao longo do caminho de aumento
            for (int m = t; m != s; m = parent[m]) {
                flow[parent[m]][m] +=  temp;

                this.graph.getEdge(parent[m],m ).incFlow((int)temp);
                flow[m][parent[m]] -= temp;
            }
        }
        double result = 0;
        for (int n = 0; n < graph.getV(); n++) {
            result += flow[s][n];
        }
        return result;
    }


    public static void main(String[] args) {
        /* Pequeno teste, comentado agora, para testar o funcionamento do código de EdmondsKarp
        Graph teste = new Graph(6);
        teste.addEdge(0, 1, 16);
        teste.addEdge(0, 2, 13);
        teste.addEdge(1, 3, 12);
        teste.addEdge(1, 2, 10);
        teste.addEdge(2, 1, 4);
        teste.addEdge(3, 2, 9);
        teste.addEdge(2, 4, 14);
        teste.addEdge(3, 5, 20);
        teste.addEdge(4, 3, 7);
        teste.addEdge(4, 5, 4);
        EdmondsKarp malha = new EdmondsKarp(teste);
        System.out.println(malha.getMaxFlow(0, 5)); */
    }
}
