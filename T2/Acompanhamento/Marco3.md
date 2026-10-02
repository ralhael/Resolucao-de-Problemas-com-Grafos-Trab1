# Marco 3: Planejamento Teórico e Estratégia de Solução — Building Teams (CSES 1668)

## 1. Propriedade Estrutural Central, Critério e Resposta Exigida

### Propriedade Estrutural
O problema exige dividir $N$ alunos em duas equipes de forma que nenhum par de amigos pertença à mesma equipe. Em Teoria dos Grafos, essa propriedade é denominada **Bipartição do Grafo (2-colorabilidade)**. 

Um grafo $G = (V, E)$ é bipartido se, e somente se, o conjunto de vértices $V$ pode ser partido em dois conjuntos disjuntos $V_1$ e $V_2$ tais que toda aresta em $E$ conecta um vértice de $V_1$ a um vértice de $V_2$. Pelo **Teorema de König**, um grafo é bipartido se, e somente se, **não contém ciclos ímpares**.

### Critério de Reconhecimento
Durante uma busca no grafo, ao visitar um vértice $v$ com equipe $c_v \in \{1, 2\}$, atribui-se obrigatoriamente a equipe oposta $(3 - c_v)$ a cada vizinho $u$ ainda não visitado. 

Se a busca examinar uma aresta entre $v$ e um vizinho $u$ que **já foi visitado** e possui a mesma equipe ($\text{equipe}[u] == \text{equipe}[v]$), identifica-se a presença de um **ciclo ímpar** (conflito insuperável de coloração).

### Obtenção da Resposta
* **Grafo Bipartido (Sem Conflitos):** O algoritmo imprime uma sequência de $N$ inteiros (separados por espaço), representando a equipe ($1$ ou $2$) de cada vértice.
* **Grafo Não Bipartido (Com Conflito):** Caso um ciclo ímpar seja detectado em qualquer componente, a execução é interrompida e a saída impressa é `IMPOSSIBLE`.

---

## 2. Implementações de Referência (`algs4`) e Adaptações Previstas

Para a resolução do problema, serão utilizadas e adaptadas duas estruturas de referência da biblioteca `algs4`:

### A. `Graph.java`
* **Papel:** Representação computacional do grafo de amizades por meio de **listas de adjacência**.
* **Métodos Utilizados:**
  * `Graph(int V)`: Inicializa a estrutura para $V$ vértices.
  * `addEdge(int v, int w)`: Adiciona a aresta não dirigida entre $v$ e $w$.
  * `adj(int v)`: Retorna os vizinhos adjacentes do vértice $v$.
  * `V()`: Retorna o número total de vértices.
* **Métodos NÃO Utilizados:** `Graph(In in)`, `Graph(Graph G)`, `E()`, `degree(int v)`, `toString()`.
* **Adaptação:** Mapeamento da entrada do CSES (indexada de $1$ a $N$) para a base $0$ a $N-1$ exigida pelo `algs4`.

### B. `NonrecursiveDFS.java`
* **Papel:** Prover o mecanismo de **Busca em Profundidade (DFS) Iterativa** utilizando uma pilha explícita (`Stack<Integer>`). Isso evita a recursão implícita da JVM e previne o erro de estouro de pilha (*StackOverflowError*) para a restrição de $N = 10^5$.
* **Adaptações Previstas:**
  1. **Substituição do Controle de Visitados:** Remoção do vetor `marked[]`. Em seu lugar, será adotado o vetor de inteiros `equipe[]` inicializado com $0$ (não visitado), assumindo $1$ ou $2$ quando visitado.
  2. **Inclusão do Laço Principal:** Adição de um laço `for (int i = 0; i < V; i++)` para garantir que o algoritmo processe todas as componentes desconexas (ilhas) do grafo.
  3. **Alternância de Equipes e Detecção de Conflitos:**
     * Para vizinho $w$ não visitado (`equipe[w] == 0`): atribuição `equipe[w] = 3 - equipe[v]` e empilhamento de $w$.
     * Para vizinho $w$ já visitado e com `equipe[w] == equipe[v]`: sinalização de ciclo ímpar e encerramento com `IMPOSSIBLE`.
  4. **Preservação de Iteradores:** Manutenção do uso de iteradores de adjacência para assegurar a travessia eficiente de cada aresta em tempo linear.

---

## 3. Rastreamento Manual em Instância Pequena

Considerando um caso com **ciclo ímpar** (não bipartido) com $N = 3$ e $M = 3$:
* **Entrada (base 1):** `1-2`, `2-3`, `3-1`
* **Entrada (base 0):** `0-1`, `1-2`, `2-0`
* **Listas de Adjacência:** `0: [1, 2]`, `1: [0, 2]`, `2: [1, 0]`

### Tabela de Rastreamento do Algoritmo

| Passo | Vértice Atual ($v$) | Vizinho Examinado ($w$) | Estado de `equipe[w]` | Ação Realizada | Estado da Pilha (`Stack`) | Vetor `equipe[]` |
| :---: | :---: | :---: | :---: | :--- | :---: | :---: |
| 0 | - | - | - | Inicia $i=0$: `equipe[0]=1`, empilha 0 | `[0]` | `[1, 0, 0]` |
| 1 | 0 | 1 | `0` (não visitado) | `equipe[1] = 3-1 = 2`, empilha 1 | `[0, 1]` | `[1, 2, 0]` |
| 2 | 1 | 0 | `1` (visitado) | `equipe[0] == equipe[1]`? ($1 == 2$: Falso). Continua. | `[0, 1]` | `[1, 2, 0]` |
| 3 | 1 | 2 | `0` (não visitado) | `equipe[2] = 3-2 = 1`, empilha 2 | `[0, 1, 2]` | `[1, 2, 1]` |
| 4 | 2 | 1 | `2` (visitado) | `equipe[1] == equipe[2]`? ($2 == 1$: Falso). Continua. | `[0, 1, 2]` | `[1, 2, 1]` |
| 5 | 2 | 0 | `1` (visitado) | `equipe[0] == equipe[2]`? ($1 == 1$: **VERDADEIRO**) | `[0, 1, 2]` | `[1, 2, 1]` |

> **Resultado do Rastreamento:** No Passo 5, ao examinar a aresta $2 \rightarrow 0$, detecta-se `equipe[0] == equipe[2] == 1`. O algoritmo interrompe imediatamente e retorna `IMPOSSIBLE`.

---

## 4. Complexidade de Tempo e Memória

### Complexidade de Tempo
* **Construção do Grafo:** $\mathcal{O}(V + E)$ para a leitura e inserção de $M$ arestas nas listas de adjacência.
* **Execução da DFS Iterativa:** $\mathcal{O}(V + E)$. Cada vértice é inserido e removido da pilha no máximo uma vez. Cada aresta é examinada exatamente duas vezes (uma a partir de cada extremidade).
* **Complexidade Total de Tempo:** $\mathcal{O}(V + E)$, perfeitamente adequada para os limites do problema ($N, M \le 10^5$), executando em menos de 0.2 segundos.

### Complexidade de Memória

* **Representação do Grafo (Estrutura de Dados Principal):**
  * Vetor de listas de adjacência: $\Theta(V + E)$ de espaço.
* **Memória Auxiliar:**
  * Vetor de equipes (`equipe[]`): $\Theta(V)$ inteiros.
  * Pilha explícita (`Stack`): $\mathcal{O}(V)$ no pior caso (grafo em formato de caminho).
  * Iteradores de adjacência: $\Theta(V)$ ponteiros.

