
# Análise do Algoritmo Ford-Fulkerson

## Introdução

O Algoritmo de Ford-Fulkerson é uma abordagem fundamental para resolver o problema do fluxo máximo em redes de fluxo. Baseia-se na identificação repetida de caminhos de aumento, nos quais é possível enviar mais fluxo da fonte para o sumidouro sem violar a capacidade das arestas.

## Descrição do Algoritmo

### Definições Iniciais

- Uma **rede de fluxo** é um grafo direcionado $G = (V, E)$, onde cada aresta $(u, v) \in E$ possui uma capacidade $c(u, v) \geq 0$ e um fluxo $f(u, v)$, com uma fonte $s$ e um sumidouro $t$.
- O **fluxo máximo** representa o maior valor de fluxo que pode ser enviado da fonte $s$ ao sumidouro $t$ sem exceder as capacidades das arestas.

### Operação Principal

O algoritmo busca repetidamente por **caminhos de aumento** — caminhos nos quais o fluxo pode ser incrementado da fonte ao sumidouro. Em cada iteração, o fluxo é aumentado ao longo deste caminho até que não sejam encontrados mais caminhos de aumento.

## Análise de Complexidade

A complexidade temporal do algoritmo Ford-Fulkerson é $O(Ef)$, onde $E$ é o número de arestas na rede, e $f$ é o valor do fluxo máximo obtido. Essa complexidade advém do fato de que, a cada iteração, o algoritmo pode aumentar o fluxo em uma unidade através do caminho de aumento, podendo haver até $f$ tais incrementos.

## Invariante do Algoritmo

Durante a execução do Ford-Fulkerson, mantém-se um invariante crucial:

Após cada iteração, o fluxo na rede é um fluxo válido, respeitando as capacidades das arestas e as leis de conservação do fluxo em cada vértice.


### Demonstração Formal da Corretude

Para fornecer uma demonstração matemática que prove a corretude do algoritmo Ford-Fulkerson por indução, vamos focar no núcleo do algoritmo: a busca por caminhos de aumento e como o fluxo é atualizado ao longo desses caminhos. A demonstração envolverá dois componentes principais:

1. **A existência de um caminho de aumento implica que o fluxo atual não é máximo.**
2. **A atualização do fluxo ao longo de um caminho de aumento nunca viola as restrições de capacidade das arestas e sempre aumenta o fluxo total da fonte ao sumidouro.**

#### Base da Indução

**Passo Base:** Inicialmente, o fluxo em todas as arestas é definido como 0, o que trivialmente cumpre as restrições de capacidade, pois $0 \leq c(u, v))$ para todas as arestas $(u, v)$ e a conservação do fluxo, já que não há fluxo passando pelos vértices. Assim, o fluxo inicial de 0 é válido.

#### Hipótese Indutiva

**Passo Indutivo:** Suponha que, após $k$ iterações do algoritmo, o fluxo $f$ é válido, ou seja, respeita as restrições de capacidade e conservação do fluxo. Além disso, assuma que, se existe um caminho de aumento, o fluxo atual não é máximo.

#### Passo Indutivo

1. **Existência de um Caminho de Aumento:** A existência de um caminho de aumento $P$ da fonte $s$ ao sumidouro $t$ no grafo residual implica que podemos aumentar o fluxo. Utilizando a busca em largura (BFS) garantimos que tal caminho, se existir, será encontrado.

2. **Atualização do Fluxo:** O fluxo ao longo do caminho de aumento é incrementado pelo valor mínimo da capacidade residual em $P$, $c_{f}(P)$. Para cada aresta $(u, v)$ no caminho $P$, o fluxo é atualizado como $f(u, v) = f(u, v) + c_{f}(P)$ e $f(v, u) = f(v, u) - c_{f}(P)$, respeitando as capacidades das arestas e mantendo a conservação do fluxo.

#### Prova da Atualização do Fluxo Mantendo a Validade

A atualização do fluxo mantém a validade do fluxo por duas razões principais:

- **Conservação do Fluxo:** Ao aumentar e diminuir o fluxo de forma simétrica nas arestas diretas e reversas, a conservação do fluxo é mantida em todos os vértices, exceto $s$ e $t$.

- **Respeito às Capacidades:** O incremento do fluxo é limitado pelo mínimo da capacidade residual ao longo de $P$, garantindo que o fluxo atualizado não excede as capacidades das arestas.

#### Conclusão

Por indução, se o algoritmo não encontra mais um caminho de aumento, então o fluxo não pode ser aumentado e, consequentemente, alcançamos o fluxo máximo. Isso prova que o algoritmo Ford-Fulkerson termina com um fluxo válido que é o máximo possível de $s$ a $t$, cumprindo assim a definição de corretude do algoritmo.

Esta prova por indução matemática baseia-se na estrutura iterativa do algoritmo Ford-Fulkerson e na maneira como o fluxo é atualizado ao longo dos caminhos de aumento, garantindo que as propriedades desejadas do fluxo máximo sejam sempre mantidas.

