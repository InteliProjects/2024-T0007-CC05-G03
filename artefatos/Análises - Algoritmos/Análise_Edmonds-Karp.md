# Implementação do Edmonds-Karp:

```java
package inteli.algoritmos;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 A classe EdmondsKarp implementa o algoritmo de Edmonds-Karp para calcular o fluxo máximo em uma rede de fluxo, representada por um grafo da classe Graph. 
 
 Este algoritmo encontra o caminho de aumento de fluxo repetidamente e aumenta
 o fluxo ao longo desses caminhos até que não seja possível encontrar mais
 nenhum, garantindo assim a obtenção do fluxo máximo da fonte ao sumidouro.
*/

public class EdmondsKarp {

    private double[][] flow; // Armazena o fluxo que já foi enviado entre cada par de vértices (i, j).
    private boolean[] visited; // Marca os vértices como visitados (true) ou não visitados (false) durante a busca.
    private int[] parent; // Armazena o predecessor de cada vértice no caminho de aumento encontrado.
    private boolean path; // Flag que indica a existência de um caminho de aumento.
    private Graph graph; // Representação do grafo onde o fluxo máximo está sendo calculado.

    /**
     * Construtor da classe EdmondsKarp.
     * Inicializa as estruturas necessárias para execução do algoritmo sobre o grafo fornecido.
     * @param graph O grafo sobre o qual o fluxo máximo será calculado.
     */
    public EdmondsKarp(Graph graph) {
        this.graph = graph;
        this.flow = new double[graph.V()][graph.V()];
        this.parent = new int[graph.V()];
        this.visited = new boolean[graph.V()];
        this.path = true;
    }

    /**
     * Calcula e retorna o fluxo máximo da fonte (s) para o sumidouro (t) no grafo.
     * Utiliza uma busca em largura para encontrar caminhos de aumento e ajusta o fluxo através desses caminhos.
     * @param s O vértice fonte no grafo.
     * @param t O vértice sumidouro no grafo.
     * @return O valor do fluxo máximo possível de s para t.
     */
    public double getMaxFlow(int s, int t) {
        while (path) { // Continua enquanto existir um caminho de aumento.
            final Queue<Integer> Q = new ArrayDeque<>();
            Q.add(s);

            // Inicializa os vértices como não visitados para cada busca de caminho de aumento.
            for (int i = 0; i < graph.V(); i++) {
                visited[i] = false;
            }
            visited[s] = true;

            boolean foundPath = false; // Indica se um caminho de aumento foi encontrado.
            int current;
            while (!Q.isEmpty()) {
                current = Q.poll(); // Remove e retorna o cabeçalho da fila.
                if (current == t) {
                    foundPath = true; // Caminho de aumento encontrado até o sumidouro.
                    break;
                }
                // Explora os vértices adjacentes não visitados com capacidade residual positiva.
                for (int j = 0; j < graph.V(); j++) {
                    if (!visited[j] && graph.getAdjMatrix()[current][j] > flow[current][j]) {
                        visited[j] = true;
                        Q.add(j);
                        parent[j] = current; // Atualiza o predecessor no caminho.
                    }
                }
            }
            if (!foundPath) break; // Se nenhum caminho de aumento foi encontrado, termina o loop.

            // Calcula o fluxo mínimo adicional que pode ser enviado ao longo do caminho encontrado.
            double pathFlow = Double.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, graph.getAdjMatrix()[u][v] - flow[u][v]);
            }

            // Atualiza o fluxo para cada aresta no caminho de aumento.
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                flow[u][v] += pathFlow;
                flow[v][u] -= pathFlow; // Atualiza o fluxo reverso.
            }
        }
        // Calcula o fluxo total enviado do vértice fonte após não encontrar mais caminhos de aumento.
        double maxFlow = 0;
        for (int v = 0; v < graph.V(); v++) {
            maxFlow += flow[s][v];
        }
        return maxFlow; // Retorna o fluxo máximo encontrado.
    }
}

```

# Análise de complexidade

<div class="center">Figura 1: Análise de Complexidade
<p align="center"> <img src="./image_complexidade.png" alt="Análise de Complexidade"> </p>
Fonte: EDMONDS-KARP AND DINIC’S ALGORITHMS FOR MAXIMUM FLOW. Top Coder, [s. l.], 7 jan. 2022. Disponível em: https://www.topcoder.com/thrive/articles/edmonds-karp-and-dinics-algorithms-for-maximum-flow. Acesso em: 27 mar. 2024.
</div>
<br>  
A complexidade de tempo do Algoritmo de Edmonds-Karp, uma implementação específica do método Ford-Fulkerson para encontrar o fluxo máximo em uma rede, pode ser expressa utilizando as notações de complexidade tradicionais: $O$ (big O), $\Omega$ (big Omega) e $\Theta$ (big Theta).

Pior Caso $O(VE^2)$:
 
 Onde $V$ é o número de vértices e $E$ é o número de arestas na rede. Isso se dá porque o algoritmo pode precisar de examinar todas as arestas em cada uma das $V$ iterações de aumento do fluxo, e em cada iteração, a verificação de caminhos de aumento pode necessitar de uma exploração que é proporcional ao quadrado do número de arestas.

Melhor Caso: $\Omega(E)$
 
 Este cenário ocorre sob condições ideais em que cada incremento no fluxo pode ser conseguido com uma única passagem pelas arestas, sem a necessidade de revisitar ou examinar múltiplas vezes as mesmas arestas ou vértices. Isso assume uma situação altamente otimizada e pouco comum, onde a topologia da rede e as capacidades das arestas permitem que cada aresta contribua para o aumento do fluxo logo na primeira tentativa.

Caso Médio $\Theta(VE^2)$: 

Dado o comportamento do algoritmo e as características variadas das redes nas quais pode ser aplicado, o caso médio tende a se aproximar do pior caso, sendo assim expresso como $\Theta(VE^2)$. Isto reflete o entendimento de que, enquanto em redes específicas e sob certas condições o algoritmo pode performar melhor do que o pior caso teórico, na maioria das situações e especialmente em redes grandes e complexas, a complexidade tende a se manter próxima do limite superior estabelecido pelo pior caso.

# Análise de corretude

## Corretude do Algoritmo Edmond-Karp utilizando Prova por Indução

### Entendimento do Propósito do Algoritmo:

Antes de analisarmos a correção do algoritmo Edmonds-Karp utilizando a técnica de prova por indução, é essencial entender seu objetivo. O algoritmo de Edmonds-Karp é uma implementação específica do algoritmo de Ford-Fulkerson para calcular o fluxo máximo em uma rede de fluxo. Seu propósito é encontrar o máximo fluxo de um vértice fonte $s$ para um vértice sorvedouro $t$ em um grafo direcionado, onde cada aresta tem uma capacidade de fluxo não negativa. Isso é feito repetidamente encontrando caminhos de aumento - caminhos onde o fluxo adicional pode ser enviado da fonte ao sorvedouro - até que nenhum desses caminhos exista mais.

#### Invariante do Laço:
Durante a execução do algoritmo, mantém-se um invariante de laço: a cada iteração, o algoritmo aumenta o fluxo total do sistema enquanto existe um caminho de aumento da fonte ao sorvedouro. Isso é conseguido atualizando as capacidades residuais das arestas no caminho de aumento encontrado.

Para demonstrar a corretude do algoritmo Edmonds-Karp, definiremos algumas notações e propriedades-chave.

Notações:
$G(V,E)$ é o grafo que representa a rede de fluxo, onde $V$ é o conjunto de vértices e $E$ é o conjunto de arestas.
- $c(u, v)$ é a capacidade de fluxo da aresta do vértice $u$ para o vértice $v$.
- $f(u, v)$ é o fluxo atual na aresta de $u$ para $v$.
- $G_f(V, E_f)$ é o grafo residual, onde $E_f$ são as arestas com capacidades residuais positivas.
- $p$ é um caminho de aumento no grafo residual $G_f$.

Propriedades:

1. **Capacidade Residual:** Para cada aresta $(u, v) \in E$, a capacidade residual é definida como $c_f(u, v) = c(u, v) - f(u, v)$. Isso representa a capacidade de fluxo adicional que pode ser enviado de $u$ para $v$.

2. **Caminho de Aumento:** Um caminho de aumento é um caminho no grafo residual $G_f$ da fonte $s$ ao sorvedouro $t$, onde todas as arestas têm capacidade residual positiva. Enviar fluxo ao longo de um caminho de aumento aumenta o fluxo total da rede.

3. **Terminação:** O algoritmo termina quando não há mais caminhos de aumento no grafo residual, o que significa que o fluxo máximo foi alcançado.

#### Prova de Corretude:

**Hipótese de Indução:**
Assumimos que, após cada iteração do algoritmo, o fluxo $f$ é um fluxo válido da fonte ao sorvedouro, e não existem caminhos de aumento que permitam um fluxo maior sem violar as capacidades das arestas.

**Base da Indução:**
Inicialmente, o fluxo $f$ é zero em todas as arestas, o que claramente satisfaz as condições de fluxo válido. Isso serve como nossa base de indução.

**Passo da Indução:**
Suponha que antes da iteração $i$ do algoritmo, o fluxo $f$ é um fluxo válido. Durante a iteração $i$, um caminho de aumento $p$ é encontrado no grafo residual $G_f$, e o fluxo é aumentado ao longo desse caminho.

1. **Manutenção do Fluxo Válido:** O fluxo é atualizado ao longo de $p$ aumentando $f$ nas arestas diretas de $p$ e diminuindo $f$ nas arestas inversas, garantindo que as capacidades das arestas não sejam violadas. Isso mantém a propriedade de que $f$ é um fluxo válido de $s$ a $t$.

2. **Aumento do Fluxo Total:** Ao enviar fluxo adicional ao longo de $p$, o fluxo total da rede aumenta. Isso está de acordo com nossa hipótese de indução, onde cada iteração aumenta o fluxo total até que nenhum caminho de aumento seja encontrado.

3. **Terminação e Máximo Fluxo:** Quando não há caminhos de aumento restantes, o fluxo $f$ não pode ser aumentado sem violar as capacidades das arestas. Isso significa que alcançamos o fluxo máximo possível de $s$ para $t$, provando que o algoritmo termina corretamente com o fluxo máximo.

Portanto, por indução, mostramos que o algoritmo Edmonds-Karp aumenta corretamente o fluxo total a cada iteração, mantendo a validade do fluxo, e termina com o fluxo máximo de $s$ a $t$. Isso prova a corretude do algoritmo Edmonds-Karp.