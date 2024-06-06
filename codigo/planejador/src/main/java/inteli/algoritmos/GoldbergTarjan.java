package inteli.algoritmos;

import java.util.LinkedList;
import java.util.Queue;

public class GoldbergTarjan {
    int numberNodes;//Numero de nós do grafo
    int[][] adjMatrix,flow;//matriz de adjacencia e de fluxo
    int[] height,excess, seen;// Arrays de controle(excesso, distancia e nós ativos)
    int inferior = Integer.MAX_VALUE;//
    Queue<Integer> excess_vertices;//Fila que armazena os vertices que possuem excesso;

    //Construtor do Algoritmo
    public GoldbergTarjan(int numberofNodes,int[][] Graph){
        this.numberNodes = numberofNodes;
        this.adjMatrix = Graph;
        this.height = new int[adjMatrix.length];
        this.seen = new int[adjMatrix.length];
        this.excess = new int[adjMatrix.length];
        this.flow = new int[adjMatrix.length][adjMatrix.length];
        this.excess_vertices = new LinkedList<>();
    }
    //Método que envia um fluxo do nó que possui excesso para um nó vizinho ativo
    public void push(int u,int v){
        int d = Math.min(this.excess[u],this.adjMatrix[u][v]-this.flow[u][v]);
        this.excess[u] -= d;
        this.excess[v] += d;
        this.flow[u][v] +=d;
        this.flow[v][u] -=d;
        if( excess[v]==d){
            excess_vertices.add(v);
        }

    }
    //Este método muda o valor da distancia para o nó u, dependendo dos nós adjacentes
    public void relabel(int u){

        int d =inferior;
        for(int i = 0 ; i<this.adjMatrix.length;i++){
            if(this.adjMatrix[u][i] - this.flow[u][i]>0){
                d = Math.min(d, this.height[i]);
            }
        }
        if(d<inferior){
            height[u] = d+1;
        }
    }
    //Método que manipula a fila de nós ativos realizando o push/relabel até zerar os excessos.
    public void discharge(int u){
        while (this.excess[u]>0){
            if(this.seen[u]<this.numberNodes){
                int v = seen[u];
                if(adjMatrix[u][v]-flow[u][v]>0 && this.height[u]>this.height[v]){
                    push(u, v);
                }else{
                    seen[u]++;
                }
            }else{
                relabel(u);
                seen[u]=0;
            }
        }

    }
    //Método que realiza um fluxo maximo em um grafo, da fonte s a um sorvedouro t
    public int maxFlow(int s, int t){

        //PerFlow inicial: inicia os valores iniciais para os nós próximos à fonte.
        this.height[numberNodes-1] = 0;
        height[s]=numberNodes;
        flow[numberNodes-1][numberNodes-1]=0;
        excess[numberNodes-1] = 0;
        excess[s]=inferior;

        for(int i =0;i<numberNodes;i++){
            if(i!=s){
                push(s, i);
            }
        }
        seen[numberNodes-1]=0;
        //Começa a realizar o push/relabel para os nós ativos
        while (!this.excess_vertices.isEmpty()) {
            int u =this.excess_vertices.poll();
            if(u!=s && u!=t){
                discharge(u);
            }


        }
        //inicia a contagem do fluxo obtido
        int max_flow =  0;
        for (int i = 0; i < numberNodes; i++)
            max_flow += flow[i][t];
        return max_flow;
    }
     public static void main(String[] args) {
        int[][] matriz = new int[][] {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}};
         GoldbergTarjan gt = new GoldbergTarjan(matriz.length,matriz);
         System.out.println(gt.maxFlow(0, matriz.length-1));
    }


}
