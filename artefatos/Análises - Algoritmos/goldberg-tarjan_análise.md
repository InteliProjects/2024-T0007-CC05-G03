# Análise do Algoritmo Goldberg-Tarjan

## Introdução
O Algoritmo de Goldberg-Tarjan, ou algoritmo de pré-fluxo e empurrar-relabel, apresenta uma técnica eficiente para resolver o problema de fluxo máximo em redes de fluxo. Diferente da abordagem baseada em caminhos de aumento usada por Ford-Fulkerson, o Goldberg-Tarjan trabalha inicializando um pré-fluxo que excede as demandas dos vértices e ajusta progressivamente esses fluxos até atingir um estado de fluxo máximo.

## Descrição do Algoritmo

### Definições Iniciais

 - Uma rede de fluxo é definida por um grafo direcionado $G = (V, E)$, onde cada aresta $(u, v) \in E$ tem uma capacidade $c(u, v) \geq 0$ e um fluxo $f(u, v)$, com uma fonte $s$ e um sumidouro $t$.
- Diferentemente do algoritmo de Ford-Fulkerson e Edmonds-Karp, o Goldberg-Tarjan introduz o conceito de altura para cada vértice e de pré-fluxo, que permite temporariamente que o fluxo entrante em um vértice exceda o fluxo saínte.


### Operação Principal

O algoritmo opera em duas fases principais: **empurrar** (push) e **relabel** (relabel). Na fase de empurrar, se tenta enviar o excesso de pré-fluxo de um vértice para seus vizinhos downstream. Se isso não for possível, o algoritmo relabela o vértice, aumentando sua altura para criar uma nova oportunidade de empurrar o pré-fluxo.

## Análise de Complexidade
A complexidade temporal do algoritmo Goldberg-Tarjan é $O(V^2E)$, sendo uma melhoria significativa sobre o pior caso do algoritmo Ford-Fulkerson, principalmente para redes densas.

## Invariante do Algoritmo
O algoritmo mantém dois invariantes durante sua execução:

Pré-fluxo: Em qualquer momento, o pré-fluxo é tal que o fluxo entrante pode exceder o fluxo saínte, mas nunca o contrário.
Alturas: As alturas dos vértices são usadas para direcionar o pré-fluxo e são ajustadas para manter o gradiente decrescente do fluxo da fonte ao sumidouro.

### Demonstração Formal da Corretude

A corretude do algoritmo de Goldberg-Tarjan é garantida se, ao final da execução, o pré-fluxo se converte em um fluxo válido que é máximo. A demonstração formal por indução abordará esses aspectos:

### Base da Indução

**Passo Base:** No início, somente a fonte $s$ tem um pré-fluxo, sendo este distribuído completamente para seus vizinhos. As alturas são inicializadas de forma que $s$ tem altura $|V|$ e todos os outros vértices têm altura $0$. Este é um estado válido de pré-fluxo.

#### Hipótese Indutiva

**Passo Indutivo:** Assuma que após $k$ operações (empurrar ou relabel), o estado de pré-fluxo e as alturas dos vértices garantem que o fluxo ainda é um pré-fluxo válido, respeitando a capacidade das arestas e a condição de altura para operações de empurrar.

#### Passo Indutivo

1. **Operação de Empurrar:** Se um vértice $u$ tem excesso de pré-fluxo e há uma aresta $(u, v)$ tal que a altura de $u$ é exatamente um a mais que a de $v$, o pré-fluxo pode ser empurrado para $v$. Isso reduz o excesso em $u$ sem violar as condições de pré-fluxo ou altura.

2. **Operação de Relabel:** Se não é possível empurrar o pré-fluxo de $u$ por falta 
de arestas adequadas, então $u$ é relabelado. Isso aumenta a altura de $u$ para o mínimo necessário que permita potencialmente um empurrar futuro. A altura é ajustada para ser um a mais que a menor altura entre os vizinhos de $u$ para os quais o empurrar é possível de acordo com a capacidade residual.

#### Prova de que as Operações Mantêm a Validade

- **Pré-fluxo:** As operações de empurrar garantem que o pré-fluxo excedente em qualquer vértice é reduzido de maneira válida, sem exceder as capacidades das arestas. Isso assegura que em qualquer ponto da execução, o que temos é um pré-fluxo válido.

- **Alturas:** A operação de relabel somente ocorre quando não há possibilidade de empurrar, garantindo que a condição de empurrar baseada em altura sempre se mantenha. Isso previne ciclos infinitos de empurrar entre vértices de mesma altura, movendo o pré-fluxo progressivamente em direção ao sumidouro.

#### Conclusão

Por indução, quando não há mais operações de empurrar ou relabel a serem feitas, todos os vértices, exceto $s$ e $t$, não têm excesso de pré-fluxo, significando que alcançamos um estado onde o pré-fluxo se converte em fluxo válido. Nesse ponto, o fluxo de $s$ para $t$ é máximo porque não há mais como "empurrar" fluxo adicional para $t$ sem violar as restrições de capacidade ou a condição de pré-fluxo.

Dessa forma, o algoritmo de Goldberg-Tarjan termina com um fluxo válido que maximiza o fluxo de $s$ a $t$, provando sua corretude. A eficiência e as inovações em termos de manipulação de pré-fluxo e ajustes de altura são fundamentais para a eficácia do algoritmo em encontrar a solução ótima para problemas de fluxo máximo.



