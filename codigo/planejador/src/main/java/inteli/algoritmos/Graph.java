package inteli.algoritmos;

import java.util.ArrayList;

/*
 A classe Graph implementa um grafo direcionado usando matriz de adjacência.
 */
public class Graph {
    private int V; // quantidade de vértices do grafo
    private int E; // quantidade de arestas do grafo
    private int indegree[]; // array que armazena a quantidade de vértices de entrada para cada vértice
    private double[][] adjMatrix;  // matriz de adjacência representando as capacidades de cada aresta entre os vértices

    public Graph(int V) { // construtor do grafo que recebe como parâmetro o número de vértices do grafo
        this.V = V;
        this.E = 0;
        adjMatrix = new double[V][V];
        indegree = new int[V];
    }

    public void addEdge(int v, int w, double capacity) { // adicona as arestas com os pesos na matriz de adjacência
        if (v < 0 || v >= V || w < 0 || w >= V)
            throw new IllegalArgumentException("Vértice fora do intervalo");

        if(adjMatrix[v][w] == 0) {
            adjMatrix[v][w] = capacity;
            this.E += 1;
            indegree[w] += 1;

        }
    }

    public ArrayList<Integer> adj(int v) { //Retorna uma lista de vértices adjacentes ao vértice especificado
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertice fora do intervalo");
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < this.V; i++) {
            if(adjMatrix[v][i] == 1) {
                list.add(1);
            }
        }

        return list;
    }

    public int V() {

        return this.V;
    }

    public int E() {

        return this.E;
    }

    public int indegree(int v) {

        return indegree[v];
    }

    public int outdegree(int v) { // Retorna o grau de saída de um vértice

        int qtt = 0;
        for(int i = 0; i < this.V; i++) {
            if(adjMatrix[v][i] == 1) {
                qtt += 1;
            }
        }

        return qtt;
    }


    public Graph reverse() { // Retorna o grafo reverso ao grafo passado por parâmetro

        Graph graph = new Graph(this.V);
        for(int i = 0; i < this.V; i++) {
            for(int j = 0; j < this.V; j++) {
                if (this.adjMatrix[i][j] != 0) {
                    graph.addEdge(j, i, this.adjMatrix[i][j]);
                }
            }
        }

        return graph;
    }

    public double[][] getAdjMatrix() {
        return this.adjMatrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices e ").append(E).append(" arestas\n");
        for (int v = 0; v < V; v++) {
            sb.append(v).append(": ");
            for (int w = 0; w < V; w++) {
                if (adjMatrix[v][w] == 1)
                    sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
