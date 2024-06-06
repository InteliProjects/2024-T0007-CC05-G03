# Análise do Algoritmo de Edmonds-Karp

## Introdução

O Algoritmo de Edmonds-Karp constitui uma variante eficaz do Algoritmo de Ford-Fulkerson, desenvolvido especificamente para resolver o problema do fluxo máximo em redes de fluxo. Este algoritmo se destaca por empregar a busca em largura (BFS) na identificação do caminho de aumento mais curto. Essa característica não apenas facilita a descoberta de um caminho de aumento, mas também assegura a eficiência do algoritmo, confinando o número de iterações a um espectro polinomial em relação à quantidade de vértices no grafo.

## Descrição do Algoritmo

### Definições Fundamentais

- **Rede de Fluxo:** Considera-se um grafo direcionado $G = (V, E)$, onde cada aresta $(u, v) \in E$ é associada a uma capacidade $c(u, v) \geq 0$ e a um fluxo $f(u, v)$. Esse grafo é dotado de uma fonte $s$ e um sumidouro $t$.
- **Fluxo Máximo:** Define-se como o fluxo máximo o maior valor de fluxo que é possível enviar da fonte $s$ ao sumidouro $t$, sem que haja a superação das capacidades das arestas.

### Operação Principal

O algoritmo de Edmonds-Karp distingue-se do Ford-Fulkerson pela aplicação da busca em largura (BFS) para determinar o **caminho de aumento mais curto** em termos de contagem de arestas. Esta metodologia não somente localiza um caminho de aumento eficazmente, mas também garante a finalização do algoritmo em um número polinomial de etapas, otimizando a performance e a aplicabilidade do mesmo.

## Análise de Complexidade

A análise de complexidade do algoritmo de Edmonds-Karp revela uma complexidade temporal de $O(VE^2)$, onde $V$ e $E$ representam, respectivamente, o número de vértices e de arestas presentes na rede de fluxo. Este resultado é diretamente influenciado pela estratégia de uso da BFS para a identificação dos caminhos de aumento, o que restringe o número total de iterações a um valor estritamente polinomial.

## Invariante do Algoritmo

Durante cada etapa do algoritmo, mantém-se a garantia de que:

- O fluxo presente na rede é sempre um fluxo válido, obedecendo às capacidades estabelecidas para as arestas e às leis de conservação do fluxo em cada vértice.
- A distância, medida como o número de arestas, dos caminhos de aumento selecionados nunca apresenta redução.

### Demonstração Formal da Corretude

#### Base da Indução

**Passo Inicial:** No começo, o fluxo em todas as arestas é inicializado como 0, cumprindo com as restrições de capacidade e a conservação do fluxo, estabelecendo assim a base sólida para o raciocínio indutivo subsequente.

#### Hipótese Indutiva

**Passo Indutivo:** Sob a suposição de que, após $k$ iterações, o fluxo se mantém válido e a distância ao sumidouro, por meio dos caminhos de aumento, não sofre decréscimo, avança-se para a etapa seguinte.

1. **Identificação do Caminho de Aumento:** A aplicação da busca em largura garante a seleção do caminho mais curto de aumento. A presença desse caminho indica que o fluxo corrente não atingiu sua capacidade máxima.
   
2. **Atualização do Fluxo:** O ajuste do fluxo é realizado pelo valor mínimo da capacidade residual encontrada ao longo do caminho identificado. Essa modificação respeita as limitações de capacidade de cada aresta, preservando simultaneamente a conservação do fluxo.

#### Conclusão

A implementação da busca em largura (BFS) pelo Edmonds-Karp para identificar caminhos de aumento mais curtos limita o número de iterações, resultando em uma complexidade polinomial e garantindo que, na ausência de novos caminhos, o fluxo máximo é atingido. Essa abordagem não apenas resolve de forma eficiente o problema do fluxo máximo, mas também mantém as propriedades fundamentais de fluxo, assegurando a conclusão dentro de um marco temporal polinomial. Esta análise compacta destaca a precisão e a robustez do Algoritmo de Edmonds-Karp, demonstrando sua capacidade de oferecer soluções confiáveis e otimizadas para desafios complexos na ciência da computação.