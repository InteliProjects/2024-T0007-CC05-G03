/**
 * Classe Edge representa uma aresta em um grafo.
 */
package inteli.dellvale;

import java.math.BigInteger;

public class Edge {

    private BigInteger Origin; // Nó de origem da aresta
    private BigInteger Destiny; // Nó de destino da aresta
    private Node OriginNode;
    private Node DestinyNode;
    private int capacity; // Capacidade da aresta
    private String Submodal; // Submodal da aresta
    private int flow;

    /**
     * Constrói um objeto Edge com os valores especificados.
     * @param Origin O nó de origem da aresta
     * @param Capacity A capacidade da aresta
     * @param Destiny O nó de destino da aresta
     * @param Modal O submodal da aresta
     * @throws IllegalArgumentException Se a capacidade for negativa
     */

    public Edge(BigInteger Origin, int Capacity,BigInteger Destiny,String Modal,Node OriginNode,Node DestinyNode){

        if (Capacity<0) throw new IllegalArgumentException("Capacidade inválida");
        if(DestinyNode==null) throw new IllegalArgumentException("Algum dos nós esta nulo");
        this.Origin= Origin;
        this.Destiny = Destiny;
        this.capacity = Capacity;
        this.Submodal = Modal;
        this.OriginNode = OriginNode;
        this.DestinyNode = DestinyNode;
        this.flow = 0;
    }

    public Node getOriginNode(){
        return this.OriginNode;
    }
    public Node getDestinyNode(){
        return this.DestinyNode;
    }
    public void incFlow(int flow){
        this.flow += flow;
    }


    public void setFlow(int flow){
        this.flow = flow;
    }
    public int getFlow(){
        return this.flow;
    }
    /**
     * Obtém o nó de origem da aresta.
     * @return O nó de origem
     */
    public BigInteger getOrigin(){
        return this.Origin;
    }
    public void changeWeight(int wheight){
        this.capacity = wheight;
    }

    /**
     * Obtém o nó de destino da aresta.
     * @return O nó de destino
     */
    public BigInteger getDestiny(){
        return this.Destiny;
    }

    /**
     * Obtém a capacidade da aresta.
     * @return A capacidade da aresta
     */
    public Integer getCapacity(){
        return this.capacity;
    }

    /**
     * Obtém o submodal da aresta.
     * @return O submodal da aresta
     */
    public String getSubModal(){
        return this.Submodal;
    }
}
