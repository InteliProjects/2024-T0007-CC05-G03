package br.edu.inteli.backend.services;

import inteli.dellvale.Digrafo;
import inteli.dellvale.Edge;
import inteli.dellvale.Node;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

import static inteli.dellvale.DataApp.CreateEdges;

/**
 * Serviço para gerenciamento de operações relacionadas às arestas (Edges) do grafo.
 *
 * <p>Este serviço fornece funcionalidades para acessar e manipular informações sobre
 * as arestas, que são componentes essenciais na representação do grafo de distribuição
 * de produtos. Utiliza o método estático CreateEdges da classe DataApp para construir
 * e recuperar as arestas a partir de um arquivo XML.</p>
 */
@Service
public class NodeService {

    /**
     * Recupera todas as arestas relacionadas a um produto e cliente específicos.
     *
     * <p>Este método utiliza o método estático CreateEdges para ler e processar as
     * informações de arestas a partir de um arquivo XML, filtrando-as com base no
     * produto e no cliente especificados como parâmetros. O método é capaz de ajustar
     * a seleção de arestas conforme os critérios fornecidos, fornecendo flexibilidade
     * na obtenção de dados de arestas relevantes para diferentes cenários.</p>
     *
     * @param product O identificador do produto para filtrar as arestas relevantes.
     * @param client O identificador do cliente para filtrar as arestas relevantes.
     * @return Uma lista de objetos Edge representando as arestas filtradas.
     */
    public Node[] getAllNodes(String product) {
        // O método CreateEdges é chamado com os parâmetros fornecidos, juntamente com o nome do arquivo XML,
        // para recuperar e construir uma lista de arestas que correspondem aos critérios de filtragem.
        List<Edge> edges = CreateEdges("202204_SistemaSudeste.xml", product);
        Digrafo graph = new Digrafo(edges);

        Node[] nodes =graph.getNodesList();
        
        return nodes;
    }
}
