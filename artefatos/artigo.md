---
title: Modelo para o artigo
author: Inteli
date: Fevereiro de 2024
abstract: Escreva aqui o resumo deste artigo.
---

# Introdução

<div align="justify">

&emsp;Este projeto foi desenvolvido para a uma grande empresa brasileira da área de mineração e aborda o desafio crítico de maximizar o fluxo de minérios aos Portos finais que a empresa abastece, pontos fundamentais para o funcionamento das operações de mineração da empresa. A necessidade de otimizar a cadeia de suprimentos e os processos logísticos é muito importante neste processo, assim como mencionado em "A logística de e a gestão da cadeia de suprimentos", da UNIS/MG, especialmente em um ambiente industrial dinâmico. A complexidade dos processos envolvidos exigem soluções que sejam eficientes, flexíveis e adaptáveis às variáveis naturais e locais que influenciam o percurso da cadeia de suprimentos. Além disso, a estrutura logística compreende uma rede complexa de locais de extração, transporte e processamento, e cada um possui suas próprias características logísticas.

&emsp;A abordagem proposta neste estudo é a utilização da modelagem em grafos para representar as conexões e pontos ao longo da cadeia de suprimentos. Esta estrutura em grafos permite representar de forma eficiente as conexões entre os diversos pontos da cadeia de suprimentos da empresa, desde as minas de extração de minério até o Porto. Apesar de funcional, a solução atual da Vale demanda um tempo considerável para sua execução e enfrenta limitações que impactam a capacidade da empresa em lidar com as demandas do mercado de forma satisfatória. Portanto, este projeto visa maximizar o fluxo de minérios até o Porto e, consequentemente, otimizar o processo de tomada de decisão por meio da implementação de uma solução mais adequada.

&emsp;Ao explorar abordagens como Neo4J, um banco de dados não relacional orientado a grafos, para modelar e armazenar as informações referentes à estrutura atual do sistema de distribuição e definir a escolha de um algoritmo para resolver o problema de encontro das quantidades ideais por rota, almeja-se maximizar a chegada de minério ao porto, o que diminui a ociosidade de locais intermediários de armazenamento do material. Além disso, busca-se reduzir o tempo necessário para a obtenção de resultados, o que contribui para a melhoria das operações da empresa. Esse cenário foi descrito de forma semelhante no artigo da FATEC denominado "Cadeia logística do minério de ferro de acordo com a Vale, importância internacional de uma logística viável", cujos autores elaboram a descrição sobre o o valor de uma boa cadeia logística para uma empresa nacional.

&emsp;Ademais, é importante ressaltar que a solução é desenvolvida utilizando metodologias ágeis, conforme estrutura de desenvolvimento de projetos proposta pelo Inteli. Assim, considerando um período de 5 sprints, cada uma delas abrangendo duas semanas, é possível agrupar todos os procedimentos em 5 etapas. Primeiramente, o grupo faz um entendimento do negócio que a empresa está inserida, o contexto do problema e mapeamento do usuário. Em seguida, ele faz uma modelagem refinada, representando o problema por meio de um grafo no Neo4j, além de selecionar alguns algoritmos clássicos relevantes para o problema, apresentando suas vantagens e desvantagens. As outras três etapas englobam a construção de uma interface utilizando Springboot para a mostragem da solução, bem como implementação dos algoritmos e testagem, realizando modificações quando necessário.

</div>

# Motivação

<div align="justify">

&emsp;A empresa enfrenta o desafio contínuo de otimizar sua extensa rede logística. Distribuídas em três sistemas produtivos principais — Sul, Sudeste e Norte —, as minas da empresa produzem minério de ferro com diferentes propriedades físicas e químicas, cada uma atendendo as demandas específicas de seus clientes. Este cenário sublinha a complexidade do planejamento logístico, onde o objetivo principal é maximizar a eficiência da rede de transporte e do atendimento ao cliente, respeitando restrições operacionais variadas e mantendo a sustentabilidade das operações.

&emsp;Motivada pelo objetivo estratégico de liderar em eficiência e inovação no competitivo cenário global da mineração, a empresa busca constantemente desenvolver soluções que otimizem sua cadeia de suprimentos. Essas soluções visam não apenas atender às necessidades imediatas de transporte e distribuição de minério, mas também se alinham com práticas sustentáveis, refletindo o compromisso da empresa com a responsabilidade ambiental. Este esforço é crucial para manter o equilíbrio entre a excelência operacional e a constância da empresa, essencial para a liderança contínua e inovação no setor.

&emsp;O projeto em discussão visa enfrentar diretamente a complexidade desta malha logística, através da modelagem em grafos, para decidir de forma ótima o fluxo de minério das minas para os clientes, considerando um horizonte de planejamento fixo. Este planejamento leva em conta a variabilidade das capacidades de transporte e os diferentes lead times, focando na quantidade produzida por mina que é transportada pela malha. A decisão sobre os fluxos de minério é baseada em uma análise detalhada, utilizando dados fornecidos pela própria empresa, incluindo especificações de portos, usinas, clientes, e capacidades logísticas.

&emsp;A metodologia adotada neste projeto enfatiza a importância de responder de maneira ágil e inovadora às demandas do mercado. Por meio da implementação de tecnologias de ponta, o projeto busca não apenas solucionar problemas operacionais imediatos, mas também adaptar-se às inovações tecnológicas e abraçar estratégias competitivas emergentes. Este direcionamento estratégico assegura a posição de liderança da Vale no mercado, destacando-se não só pela excelência operacional, mas também por uma solução inovadora no setor.

&emsp;O escopo do projeto abrange a construção de um software capaz de gerenciar eficientemente os fluxos de minério, respeitando as restrições operacionais e maximizando o atendimento às demandas dos clientes. O MVP, focado inicialmente no sistema Sudeste, será um passo crucial para o desenvolvimento futuro de soluções mais abrangentes, capazes de otimizar a cadeia logística completa da mineradora. Este software representará um avanço significativo, permitindo análises mais rápidas e eficazes, e contribuindo para uma gestão mais assertiva e inovadora dos recursos da empresa.

&emsp;Concluindo, este projeto representa um esforço concentrado da Vale em redefinir os padrões de eficiência, inovação e sustentabilidade na logística de mineração. Ao buscar melhorias operacionais significativas a empresa reafirma seu compromisso com o crescimento e a tecnologia. Este projeto não apenas fortalece a sua liderança no setor, mas também promove um impacto positivo extensivo para toda a indústria.

</div>

# Metodologia

<div align="justify">

&emsp;Esta seção do presente artigo tem como objetivo descrever os principais métodos e procedimentos utilizados no desenvolvimento da solução proposta pelo grupo Dell Vale, permitindo sua replicabilidade em contextos similares ou diferentes. Dessa forma, outros desenvolvedores, ou interessados na área de atuação da solução, conseguem compreender os processos e seus respectivos resultados, adaptando-os para suas realidades.

&emsp;Nessa lógica, é importante ressaltar que a solução é desenvolvida utilizando metodologias ágeis conforme estrutura de desenvolvimento de projetos proposta pelo Inteli(INTELI, 2021). Como destacado por Schwaber (2004), a utilização de metodologias ágeis, como o Scrum, permite uma abordagem iterativa e adaptativa, essencial para o sucesso em projetos complexos e dinâmicos. Assim, considerando um período de 5 sprints, cada uma delas abrangendo duas semanas, é possível dividir todos os procedimentos em 5 grupos apresentados e descritos a seguir.


**1. Análise inicial do contexto do problema**

&emsp;Primeiramente, o grupo faz uma análise de negócios, abrangendo contexto da indústria do parceiro, modelo de 5 Forças de Porter, Análise SWOT da Vale, Value Proposition Canvas do produto e Matriz de Risco do projeto. Além disso, ele realiza um entendimento da experiência do usuário por meio da criação de Personas e User Stories. Assim, é possível compreender o problema inicialmente, elaborando dúvidas para discutir com os stakeholders. Nesse sentido, as dúvidas são sanadas no final dessa sprint, em um encontro com os representantes do parceiro, em que há discussões acerca das dúvidas, desafios enfrentados com o sistema atual e expectiva da solução a ser desenvolvida.

**2. Modelagem refinada do problema e versão inicial do Artigo**

&emsp;O próximo passo é fazer uma modelagem refinada, representando o problema por meio de um grafo, além de selecionar algoritmos clássicos relevantes para o problema, com abordagens distintas para chegar na solução, apresentando as vantagens e desvantagens de cada algoritmo. Outro ponto importante dessa etapa é a elaboração de um diagrama de classes do domínio do problema, implementando as classes em Java com seus respectivos programas de teste. Por fim, há a escrita da versão inicial do artigo, este presente documento, contendo as partes de introdução, metodologia e referências.

**3. Estrutura do Grafo e Algoritmos, Front-end da Aplicação e Versão intermediária do Artigo**

&emsp;Nesse momento do desenvolvimento, o grupo verifica se a estrutura de dados do grafo é adequada para o problema, implementa algoritmos clássicos da literatura para solucioná-lo e avalia a precisão e consistência dos resultados obtidos. Além disso, ele desenvolve um protótipo inicial do front-end da aplicação utilizando React, permitindo a navegação de telas para a validação do parceiro. Ademais, a equipe redige as seções de metodologia, motivação e revisão bibliográfica, considerando os resultados de pesquisas em fontes científicas sobre o assunto.

**4. Análise de Complexidade e Corretude, Aplicação Integrada e Conclusões do Artigo**

&emsp;Nessa etapa, a equipe implementa outros algoritmos, fazendo testes e ajustes quando necessário, bem como analisa e justifica o melhor e pior caso de cada um, utilizando matemática e notações adequadas para determinar a complexidade deles, além de fazer a análise de corretude dos algoritmos usando indução no invariante do laço. Outra parte importante desse momento é a construção do front-end, integrado com os algoritmos utilizados, que processam o grafo e resolvem o problema do projeto. Por fim, há a escrita das seções sobre os resultados do trabalho da equipe e das conclusões do projeto.

**5. Refinamento da aplicação, Refinamento e Validação dos artefatos de negócio e Artigo completo**

&emsp;O último passo do desenvolvimento desse projeto é comparar os resultados obtidos dos algoritmos utilizados entre si, bem como com a solução que a empresa paceira já utiliza, ajustando os modelos de grafos e fazendo o gerenciamento da aplicação. Além disso, o grupo refina os artefatos de negócio produzidos na Sprint 1 de acordo com os feedbacks recebidos e ajustes necessários. Ademais, a equipe entrega o Artigo completo revisado e finalizado para eventual publicação, revisando as seções e fazendo modificações quando necessário.

&emsp;Feita essa divisão de procedimentos cronológica, o grupo os seguirá de acordo com o calendário previsto, utilizando algumas ferramentas e outras estruturas, para conseguir cumprir com os objetivos, que são descritas a seguir.

**GitHub Project**

&emsp;O GitHub Projects é uma ferramenta, do próprio GitHub, que permite que equipes organizem e gerenciem seus projetos. Assim, a equipe Dell Vale o utiliza para descrição e atribuição de tarefas, elencando as prioridades daquele período e comentando nos cards de trabalho, facilitando, assim, a comunicação e cooperação entre os membros do grupo, além de ajudar no versionamento do projeto hospedado no GitHub.

**Neo4j**

&emsp;O Neo4j é um sistema de gerenciamento de banco de dados de grafo, orientado a propriedades. Ele utiliza uma estrutura de grafo, que é composta por nós, relacionamentos e propriedades. Nesse sentido, o grupo faz uso desse sistema para analisar os dados recebidos da empresa parceira, realizando consultas de maneira eficiente com a linguagem de consulta Cypher do Neo4j e tomando decisões com base nos resultados obtidos.

**React**

&emsp;React é uma biblioteca de JavaScript utilizada para criar interfaces de usuário em aplicativos e páginas da web com uma abordagem baseada em componentes. Dessa forma, a equipe a utlizará para construir a interface que recebe os dados e mostra os outputs obtidos para o usuário.

**Spring Boot**

&emsp;Spring Boot é um projeto da família Spring Framework, desenvolvido pela Pivotal Software, que visa simplificar o processo de configuração e desenvolvimento de aplicativos Java, oferecendo configurações padrões, eliminando a necessidade de configurar manualmente muitos aspectos de um aplicativo. Nessa lógica, o grupo o utilizará para construir o back-end da aplicação web.

**Tailwind CSS**

&emsp;O Tailwind CSS é um framework CSS fornece uma série de classes utilitárias que podem ser aplicadas diretamente ao HTML para estilizar os elementos. Cada classe utilitária representa uma única propriedade CSS, como tamanho de fonte, margens, preenchimentos, cores, alinhamentos, entre outros. Assim, o Dell Vale o utlizará para estilizar a aplicação web desenvolvida.

&emsp;Em resumo, utilizando essas ferramentas e seguindo os procedimentos elencados nessa seção, acredita-se que os resultados obtidos são confiáveis e importantes para diversas análises feitas durante o desenvolvimento do projeto. Assim, espera-se que outros desenvolvedores consigam reproduzir essa abordagem em outros projetos e soluções com base nos métodos descritos e resultados alcançados pelo grupo Dell Vale.

</div>

# Trabalhos relacionados

<div align="justify">

&emsp;Nessa seção, serão abordados alguns trabalhos relacionados à temática deste artigo, ou seja, problemas de logística solucionados com algoritmos em grafos, bem como seus impactos na escolha de abordagem pela equipe Dell Vale para resolver o problema proposto.

&emsp;Um dos trabalhos é o desenvolvido por alunos da disciplina de Pesquisa Operacional Aplicada à
Logística, ofertada no Curso Superior de Tecnologia em Logística do IFES – Campus Viana. Ele tem como objetivo discutir e resolver o problema de “Entrega das urnas para Eleição de Reitor do IFES". A solução encontrada pelos alunos envolvia a aplicação do algoritmo de Dijkstra, voltada para problemas de caminho mínimo, que retornava o menor tempo de trajeto, ou o menor caminho, para a entregas das urnas (E SÁ; DA COSTA; PRANE, 2018). Apesar de solucionar um tipo de problema diferente do que o proposto neste artigo, é válida a abordagem em grafos e o raciocínio por trás da lógica da solução desenvolvida pelos estudantes para ser mencionada.

&emsp;Outro artigo importante para a temática retratada, é o "A New Model for the Multi-Depot Vehicle Routing Problem with Time Windows" (Cordeau; Laporte; Mercier A, 2006). Nesse trabalho, os autores sugerem um novo modelo para o problmea de roteamento de veículos com múltiplos depósitos e janelas de tempo, utilizando algoritmos de fluxo máximo para encontrar soluções eficientes. O modelo é aplicado em cenários de logística onde múltiplos depósitos precisam ser atendidos dentro de janelas de tempo específicas. Dessa forma, ele soluciona um problema semelhante com o proposto pela empresa parceira e, portanto, serve como guia para a escolha de abordagem da Dell Vale.

&emsp;Diante dos trabalhos apresentados nessa seção, a abordagem escolhida pelo grupo e os algoritmos adotados para resolver o problema, que são descritos na próxima seção, terão como base as metodologias e resultados obtidos pelos artigos citados. Portanto, espera-se que os resultados alcançados no final do projeto sejam condizentes com a realdiade do problema solucionado.

</div>

# Algoritmos adotados para resolver o problema

<div align="justify">

&emsp;Os algoritmos utilizados em nosso estudo foram inspirados em conceitos descritos em 'Introduction to Algorithms' (Cormen et al., 2009). Nessa seção, serão descritos brevemente quais foram utilizados para resolver o problema, bem como suas principais características e o que os diferenciam dos demais. 

&emsp;Primeiramente, o grupo Dell Vale escolheu o algoritmo de Ford-Fulkerson (FORD; FULKERSON, 1956), por ser um dos primeiros algoritmos citados quando se fala de fluxo máximo, para implementar nos dados da Vale. Essencialmente, o algoritmo funciona aumentando de forma iterativa o fluxo em uma rede residual até que não seja mais possível incrementá-lo. Essa manipulação das capacidades das arestas, torna o algoritmo de Ford-Fulkerson uma ferramenta de fácil utilização e eficaz para a otimização de fluxos em redes.

&emsp;O segundo algoritmo impletado foi o de Edmonds-Karp (EDMONDS; KARP, 1972). Por ser uma variação do de Ford-Fulkerson, possui muitas características semelhantes com o algoritmo anterior, o que deixa claro sua fácil utilização no projeto. Contudo, uma de suas peculiaridades é a escolha do menor caminho de aumento na rede residual para cada interação, utilizado a Busca em Largura (BFS), o que aumenta o consumo de memória, mas reduz o tempo de processamento.


&emsp;Por fim, o último algoritmo escolhido pela equipe foi o de Goldberg-Tarjan (GOLDBERG; TARJAN, 1986). Diferentemente dos algoritmos baseados em caminhos de aumento, como Ford-Fulkerson, ele trabalha modificando os fluxos locais através de operações de "push" (empurrar) e "relabel" (reclassificar), sem a necessidade de encontrar caminhos de aumento completos a cada iteração, o que constribui para a sua capacidade de lidar com um grande volume de dados.

&emsp;Diante desses três algoritmos, é possível construir vários casos de testes que analisem a performance e os resultados de cada um deles para, então, fazer a escolha definitiva para a resolução do problema, que será abordada na próxima seção. Vale ressaltar que mais detalhes desses algoritmos mencionados podem ser encontrados no artefato de entendimento_contexto_problema desse repositório.

</div>

# Resultados obtidos

<div align="justify">

&emsp;Nessa seção, serão abordados os resultados obtidos pelo grupo Dell Vale, por meio da implementação dos algoritmos escolhidos e detalhados na seção anterior desse documento, bem como uma análise de suas performances em relação ao problema.

&emsp;Primeiramente, após o tratamento dos dados da empresa parceira, transformando todas as informações de fluxo para um grafo direcionado, a implementação dos diferentes algoritmos resultou em diferentes cenários e velocidades de processamento. Para o algoritmo de Goldberg-Tarjan, Ford-Fulkerson e Edmonds-Karp, os resultados obtidos foram respectivamente 1000, 192864 e 192864.0.

&emsp;Dados esses números, é possível perceber que nos dois últimos algoritmos os fluxos batem, mas o primeiro está muito pequeno em comparação. Com isso, o grupo Dell Vale elencou três hipóteses acerca dos motivos para que isso tenha acontecido: a primeira é de que o grafo está incorreto, a segunda é de que o algoritmo de Goldberg-Tarjan está com dificudldades de se adaptar a grafos complexos, e a terceira seria de que os outros dois algoritmos estão incorretos.

&emsp;Nesse sentido, foi feito a soma de todas as capacidades de arestas contendo um nó de destino final (clientes), que resultou em 311506. Este valor é importante, pois ele é um limite de o máximo de fluxo que poderia chegar ao final da rede. Assim, comparando esse valor com os fluxos obtidos, pode-se adimitir que os fluxos dos dois últimos algoritmos são plausíveis, o que descarta a terceira hipótese.

&emsp;Além disso, pode-se descartar a primeira hipótese, por conta da coerência entre os algoritmos de Edmonds-Karp e Ford-Fulkerson, que dão o mesmo valor, que é coerente com a capacidade máxima. Por fim, resta a segunda hipótese que deve ser averiguada com mais profundidade, pois o algoritmo de Goldberg-Tarjan do grupo Dell Vale não foi implementado a partir do artigo original, ele foi derivado de outra implementação dele mesmo em C++.

&emsp;Vale ressaltar que algoritmo de Goldberg-Tarjan apresentou uma velocidade superior para fazer os cálculos com os dados, em comparação com os outros algoritmos, por ele permitir uma melhor manipulação de operações de empurrar e rebaixar, o que levou a uma convergência mais rápida para o fluxo máximo. 

</div>

# Conclusão

&emsp;Este projeto representou um esforço colaborativo intenso e focado na otimização da cadeia logística de distribuição de minério de ferro de uma das maiores empresas de mineração do Brasil. Marcado por um grande desafio de prover o fluxo máximo e aumentar a eficiência no transporte de minério por toda essa cadeia, demonstrando assim,  ponto crítico para as operações de mineração da empresa. A abordagem adotada, centrada na modelagem de grafos e na implementação de algoritmos avançados, não só abordou as necessidades operacionais imediatas mas também se alinhou com os objetivos de longo prazo de inovação e liderança de mercado da empresa.

&emsp;A utilização de ferramentas de ponta, como o banco de dados orientado a grafos Neo4J, facilitou a modelagem das complexas relações logísticas, permitindo uma representação eficaz das diversas rotas e capacidades envolvidas. Os algoritmos de Ford-Fulkerson, Edmonds-Karp e Goldberg-Tarjan foram explorados e adaptados para atender as especificidades do contexto logístico da empresa, demonstrando a versatilidade e a robustez dessas técnicas em solucionar problemas complexos de fluxo máximo. Ademais, um complexo tratamento de dados XML responsável por fazer a interseção entre os dados da Vale e a aplicação, em conjunto de tecnologias como SpringBoot para a comunicação cliente-servidor e React para uma interface fluída e intuitiva, foram determinantes para o sucesso do projeto.

&emsp;A execução deste projeto em cinco sprints, seguindo metodologias ágeis, permitiu um desenvolvimento iterativo e adaptativo, com espaço para avaliação e realinhamento constantes. Esse processo não apenas garantiu uma solução mais alinhada com as necessidades do negócio, mas também proporcionou oportunidades para melhorias contínuas e adaptações às mudanças do mercado.

&emsp;Os resultados obtidos revelaram que são capazes de proporcionarem melhorias significativas em termos de eficiência logística e capacidade de resposta às demandas de mercado. A análise de desempenho dos algoritmos indicou que a solução proposta é viável, especialmente em termos de assertividade na gestão de fluxos.

&emsp;A colaboração entre a equipe de desenvolvimento e a empresa foi fundamental para o sucesso do projeto, permitindo uma compreensão profunda dos desafios logísticos e das expectativas de negócio. A abertura para o diálogo e a troca de conhecimentos contribuíram significativamente para a elaboração de uma solução que não apenas atendia aos requisitos técnicos, mas também se alinhava estrategicamente aos objetivos de negócio da empresa.

&emsp;Em resumo, este projeto destacou-se como um exemplo de como a tecnologia e a inovação podem ser aplicadas para solucionar desafios complexos no setor de mineração. Através da aplicação de conceitos avançados de modelagem de grafos e algoritmos, foi possível não apenas proporcionar uma solução capaz de melhorar a eficiência logística, mas também contribuir para a sustentabilidade operacional e a competitividade de mercado. Assim, este trabalho não só atingiu seus objetivos imediatos, mas também estabeleceu uma base sólida para futuras inovações e melhorias contínuas na gestão logística da empresa.

# Referências Bibliográficas

**Algoritmo de Edmonds-Karp** In: WIKIPÉDIA: a enciclopédia livre. [São Francisco, CA: Fundação Wikimedia], 2017. Disponível em: https://pt.wikipedia.org/wiki/Algoritmo_de_Edmonds-Karp. Acesso em: 29 mar. 2024.

Cordeau J.F.; Laporte G.; Mercier A. **A New Model for the Multi-Depot Vehicle Routing Problem with Time Windows.** International Conference on Machine Learning and Cybernetics: 2006. Disponível em: https://ieeexplore.ieee.org/document/4028485. Acesso em: 28 mar. 2024.

Cormen, T. H.; Leiserson, C. E.; Rivest, R. L; & Stein, C. **Introduction to Algorithms** (3rd ed.). MIT Press (2009). Este texto é um recurso abrangente sobre algoritmos e estruturas de dados, oferecendo insights teóricos e práticos que podem ser aplicados em diversas áreas da computação.

DE SOUZA, A. C.; DOS SANTOS, B. V.; DA SILVA, C. E. **Cadeia logística do minério de ferro de acordo com a Vale importância internacional de uma logística viável** FATEC - 2021. Disponível em: https://fateclog.com.br/anais/2021/parte3/1031-1453-1-RV.pdf. Acesso em: 29 mar. 2024.

E SÁ, L. C.; DA COSTA, L. S.; PRANE, B. Z. **Modelagem Matemática de problemas logísticos: discutindo o processo de entrega de urnas para eleição de Reitor do IFES.** Espírito Santo: 2018. Disponível em: https://www.ime.usp.br/~pf/algoritmos_para_grafos/aulas/flow.html. Acesso em: 27 mar. 2024.

**Ford-Fulkerson algorithm.** In: WIKIPÉDIA: a enciclopédia livre. [São Francisco, CA: Fundação Wikimedia], 2017. Disponível em: https://en.wikipedia.org/wiki/Ford%E2%80%93Fulkerson_algorithm. Acesso em: 29 mar. 2024.

Inteli; **Escritório de Projetos**. São Paulo: 2021. Disponível em: https://www.inteli.edu.br/escritorio-de-projetos/. Acesso em: 29 mar. 2024.

Knuth, D. E. **The Art of Computer Programming**, Volume 1: Fundamental Algorithms (3rd ed.): 1997. Addison-Wesley. Este livro clássico de Donald Knuth oferece uma base profunda sobre algoritmos fundamentais, que pode ser relevante para o contexto do seu projeto, especialmente se você estiver explorando algoritmos de otimização ou de busca.

**Push-relabel maximum flow algorithm** In: WIKIPÉDIA: a enciclopédia livre. [São Francisco, CA: Fundação Wikimedia], 2017. Disponível em: https://en.wikipedia.org/wiki/Push%E2%80%93relabel_maximum_flow_algorithm. Acesso em: 29 mar. 2024.

Robinson, I.; Webber, J.; & Eifrem, E. **Graph Databases: New Opportunities for Connected Data**. 2015. O'Reilly Media. Este livro fornece uma visão abrangente sobre bancos de dados de grafos, incluindo Neo4J, o que pode ser especialmente relevante se seu projeto utilizar essa tecnologia para modelagem ou solução de problemas.

Goldberg, A. V., & Tarjan, R. E. (1988). A new approach to the maximum-flow problem. Journal of the ACM (JACM), 35(4), 921-940.

Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). Introduction to Algorithms (3rd ed.). MIT Press.

Schwaber, K. (2004). Agile Project Management with Scrum. Microsoft Press.

Leite,Caio. et al.**A LOGÍSTICA E A GESTÃO DA CADEIA DE SUPRIMENTOS: Um estudo de caso de uma empresa da região do Sul de Minas Gerais**.2015. Disponível em:https://www.aedb.br/seget/arquivos/artigos15/9122276.pdf

Silberschatz, A.; Galvin, P. B.; & Gagne, G. **Operating System Concepts** (10th ed.): 2018. Wiley. Embora focado em conceitos de sistemas operacionais, este livro oferece uma visão sobre a eficiência e otimização de recursos, que pode ser aplicável ao seu projeto, especialmente se envolver a otimização de processos ou recursos.

WEBB, P. et al.**Spring Boot Reference Documentation**. (n.d.). Spring Boot. Version 3.2.4. Disponível em: https://docs.spring.io/spring-boot/docs/current/reference/html/. Acesso em: 29 mar. 2024. A documentação oficial do Spring Boot é uma fonte crucial para entender como utilizar esse framework em projetos de desenvolvimento de software, incluindo configuração, customização e deployment.

