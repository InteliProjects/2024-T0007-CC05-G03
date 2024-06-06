/**
 * A classe Digrafo representa um grafo direcionado.
 */
package inteli.dellvale;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Digrafo {
    private int NumberNodes; // Número de nós no grafo
    private int[][] adjMatrix; // Matriz de adjacência para armazenar os pesos das arestas
    private HashMap<Integer,Integer> nodesMap = new HashMap<>(); // Mapeamento dos IDs dos nós para índices da matriz
    ArrayList<Edge>[] adjList;
    private HashMap<Integer,Node> NodesObjectMap = new HashMap<>(); // Mapeamento dos IDs dos nós para índices da matriz

    List<Edge> EdgesList;
    List<Edge> EdgesListWithSFSS;

    Node[] NodesList;
    /**
     * Constrói um objeto Digrafo com o número especificado de nós e arestas.
     * @param edges Lista de arestas do grafo
     */
    public Digrafo(List<Edge> edges){


        List<BigInteger> Vertex= new ArrayList<>();

        for(Edge edge : edges){
            if(!Vertex.contains(edge.getDestiny())){
                Vertex.add(edge.getDestiny());
                NodesObjectMap.put(edge.getDestiny().intValue(),edge.getDestinyNode());
            }
            if(!Vertex.contains(edge.getOrigin())){
                Vertex.add(edge.getOrigin());
                NodesObjectMap.put(edge.getOrigin().intValue(),edge.getOriginNode());

            }
        }
        this.NumberNodes = Vertex.size()+2;
        this.NodesList = new Node[Vertex.size()+2];

        this.adjMatrix = new int[this.NumberNodes][this.NumberNodes];
        List<BigInteger> ArrayOrigin= new ArrayList<>();
        List<BigInteger> ArrayDestiny= new ArrayList<>();
        this.adjList= new ArrayList[this.NumberNodes];
        for (int i=0; i<this.adjList.length;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int node=0;node<this.NumberNodes;node++){
            if(node!=0&&node<this.NumberNodes-1) {
                this.nodesMap.put(Vertex.get(node-1).intValue(), node);
                this.NodesList[node] = this.NodesObjectMap.get(Vertex.get(node-1).intValue());


            }else {
                this.nodesMap.put(node, node);
                if(node==0){
                    Demand demand =new Demand();
                    ArrayList<Demand> demandArray = new ArrayList<>();
                    demandArray.add(demand);
                    this.NodesList[node] = new Node(BigInteger.ZERO,"Super Fonte","Super Fonte","",demandArray);

                }
                if(node==this.NumberNodes-1){
                    Demand demand =new Demand();
                    ArrayList<Demand> demandArray = new ArrayList<>();
                    demandArray.add(demand);
                    this.NodesList[node]= new Node(BigInteger.valueOf(this.NumberNodes-1),"Super sumidouro", "Super sumidouro","",demandArray);

                }            }
        }
        this.EdgesList = edges;
        this.EdgesListWithSFSS = new ArrayList<>(edges);
        createAdjList(edges);
        CreateMatrix();
    }

    /**
     * Adiciona uma aresta com a capacidade especificada entre os nós u e v.
     * @param u O nó de origem da aresta
     * @param v O nó de destino da aresta
     * @param capacity A capacidade da aresta
     * @throws IllegalArgumentException Se a capacidade for negativa ou os nós forem inválidos
     */
    public void addEdge(int u, int v, double capacity){
        if (capacity<0) throw new IllegalArgumentException("Capacidade inválida");
        if ((u<0 || u>NumberNodes)||v<0|| v>NumberNodes) throw new IllegalArgumentException("Nós inválidos");
        adjMatrix[u][v] = (int)capacity;
    }
    public Node[] getNodesList(){
        return this.NodesList;
    }
    public void resetFlows(){
        for (Edge edge : this.EdgesList){
            edge.setFlow(0);
        }
        for (Edge edge : this.EdgesListWithSFSS){
            edge.setFlow(0);
        }
    }
    public void createAdjList(List<Edge> Edges){
        List<BigInteger> ArrayOrigin= new ArrayList<>();
        List<BigInteger> ArrayDestiny= new ArrayList<>();
        Edge fe;
        int[] last_nodes = new int[this.NumberNodes];
        int[] origin_nodes = new int[this.NumberNodes];
        int counter = 0;
        ArrayDestiny.add(BigInteger.valueOf(this.NumberNodes-1));
        ArrayOrigin.add(BigInteger.ZERO);
        for(Edge edge : Edges){
            ArrayDestiny.add(edge.getDestiny());
            ArrayOrigin.add(edge.getOrigin());

            counter++;
        }


        for(Edge edge : Edges) {
            int idNode = edge.getOrigin().intValue();
            int node = this.nodesMap.get(idNode);


            this.adjList[node].add(edge);

            if(!ArrayDestiny.contains(edge.getOrigin())){
                Demand demand =new Demand();
                ArrayList<Demand> demandArray = new ArrayList<>();
                demandArray.add(demand);
                Node sfNode = new Node(BigInteger.ZERO,"Super Fonte","Super Fonte","",demandArray);
                fe = new Edge(BigInteger.ZERO,Integer.MAX_VALUE,edge.getOrigin(),"SF",sfNode,edge.getOriginNode());

                if(origin_nodes[this.nodesMap.get(fe.getDestiny().intValue())]!=1) {
                    this.EdgesListWithSFSS.add(fe);
                    this.adjList[0].add(fe);
                }
                origin_nodes[this.nodesMap.get(fe.getDestiny().intValue())] = 1;
            }
            if(!ArrayOrigin.contains(edge.getDestiny())){
                Demand demand =new Demand();
                ArrayList<Demand> demandArray = new ArrayList<>();
                demandArray.add(demand);                Node ssmNode = new Node(BigInteger.valueOf(this.NumberNodes-1),"Super sumidouro", "Super sumidouro","",demandArray);
                fe = new Edge(edge.getDestiny(),Integer.MAX_VALUE,BigInteger.valueOf(this.NumberNodes-1),"SS",edge.getDestinyNode(),ssmNode);


                if(last_nodes[this.nodesMap.get(fe.getOrigin().intValue())]!=1) {
                    this.EdgesListWithSFSS.add(fe);
                    this.adjList[this.nodesMap.get(fe.getOrigin().intValue())].add(fe);
                }
                last_nodes[this.nodesMap.get(fe.getOrigin().intValue())] = 1;
            }
        }
    }

    public List<Edge> getEdgesListWithSFSS() {
        return EdgesListWithSFSS;
    }

    /**
     * Cria e preenche a matriz de adjacência com as capacidades das arestas.
     *
     * @return A matriz de adjacência preenchida
     */

    public int[][] CreateMatrix(){
        int from;
        int to;

        for(ArrayList<Edge> edgeList : this.adjList){


            for (Edge edge:edgeList){
                from = this.nodesMap.get(edge.getOrigin().intValue());
                to = this.nodesMap.get(edge.getDestiny().intValue());
                this.adjMatrix[from][to] = edge.getCapacity();

            }

            }
        return this.adjMatrix;
    }
    public int[][] getAdjMatrix(){
        return this.adjMatrix;
    }
    public ArrayList<Edge>[] getAdjList(){
        return this.adjList;
    }
    public ArrayList<Edge> getAdj(int id){

        return this.adjList[id];
    }
    public Edge getEdge(int originIndex,int destinyIndex){

        for(Edge edge : this.adjList[originIndex]){

            if(getNodeIndex(edge.getDestiny().intValue())==destinyIndex){
                return edge;

            }
        }        return null;
    }
    public int getNodeIndex(int id){

        return this.nodesMap.get(id);
    }
    public void showAdjList(){
        for (int i=0;i<this.NumberNodes;i++){
            System.out.print(i+"|");
            for(Edge e : this.adjList[i]){
                System.out.print("ID_Origem:"+e.getOrigin()+"-");
                System.out.print("Origem_Node:"+this.nodesMap.get(e.getOrigin().intValue())+"-");

                System.out.print(this.nodesMap.get(e.getDestiny().intValue())+"["+e.getCapacity()+"]"+"ID:"+e.getDestiny().intValue()+" ,"+"["+"Origen node: "+e.getOriginNode().getType()+","+e.getOriginNode().getCountry()+","+e.getOriginNode().getId()+","+e.getOriginNode().getDescription()+"]"+" ,"+"["+"destino node: "+e.getDestinyNode().getType()+","+e.getDestinyNode().getCountry()+","+e.getDestinyNode().getId()+","+e.getDestinyNode().getDescription()+"]");
            }
            System.out.print(".");
            System.out.println();
        }
    }
    public int getV(){
        return this.NumberNodes;
    }

    /**
     * Método principal - não implementado.
     * @param args Argumentos de linha de comando
     */
    public static void main(String[] args) {
        // Método principal - não implementado
    }
}
