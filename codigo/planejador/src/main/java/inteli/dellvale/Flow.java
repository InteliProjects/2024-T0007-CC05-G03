package inteli.dellvale;

import inteli.algoritmos.EdmondsKarp;
import inteli.algoritmos.FordFulkerson;

import java.util.ArrayList;
import java.util.List;

public class Flow {
    private int maxFlow;
    private String algorithm;
    private List<Edge> EdgesWithFlow;

    public  Flow(String algorithm, List<Edge> edgesList){
        this.EdgesWithFlow = new ArrayList<>();
        for (Edge edge:edgesList){
            this.EdgesWithFlow.add(edge);
        }
        this.algorithm = algorithm;
        Digrafo graph = new Digrafo(this.EdgesWithFlow);
        graph.resetFlows();
        if(algorithm.equals("FF")){
            FordFulkerson fordFulkerson = new FordFulkerson(graph);
            this.maxFlow = fordFulkerson.fordFulkerson(graph.getAdjMatrix(), 0, graph.getV()-1);

        }else if (algorithm.equals("EK")){
            EdmondsKarp edmondsKarp = new EdmondsKarp(graph);
            this.maxFlow = (int)edmondsKarp.getMaxFlow(0, graph.getV()-1);
        }else{
            this.maxFlow = 0;

        }
    }

    public int getMaxFlow() {
        return maxFlow;
    }

    public List<Edge> getEdgesWithFlow() {
        return EdgesWithFlow;
    }

    public String getAlgorithm() {
        return algorithm;
    }
}
