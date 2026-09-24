# Marco 2 — Componentes Conexas

## 1. Questão e Modelagem do Problema

O problema consiste em organizar $N$ alunos de uma turma dividindo-os em duas equipes distintas (Equipe 1 e Equipe 2). A regra fundamental é que alunos que possuem uma relação de amizade direta **não podem** ficar na mesma equipe.

Modelamos este cenário como um grafo simples e não-direcionado $G = (V, E)$:
* **Vértice ($V$):** Representa um aluno.
* **Aresta ($E$):** Representa uma relação de amizade direta entre dois alunos.

O objetivo é identificar os **componentes conexos** do grafo, verificar se é possível dividir o grupo em duas equipes e mapear o ID do componente conexo de cada aluno.

---

### Caso Particular ($V=6, E=6$)

Para analisar o comportamento do algoritmo e suas medidas em um cenário controlado, definimos um caso particular composto por $6$ alunos e $6$ relações de amizade, divididos em duas componentes conexas.

#### Entrada
```text
6 6
1 2
1 3
1 4
2 3
3 4
5 6
```

#### Saída Esperada
```text
Impossible
```

## 2. Representação do Grafo e Lista de Adjacência

A partir da entrada fornecida, o grafo é dividido em 2 subgrafos conexos ($C_1$ e $C_2$):

#### Lista de Adjacência
```text
1 → [2, 3, 4]
2 → [1, 3]
3 → [1, 2, 4]
4 → [1, 3]
5 → [6]
6 → [5]
```

## 3. Medidas Estruturais por Componente Conexa

### Componente Conexa $C_1 = \{1, 2, 3, 4\}$

**Excentricidade de cada vértice :
* $\text{Exc}(V_1) = \max(d(1,2), d(1,3), d(1,4)) = \max(1, 1, 1) = 1$
* $\text{Exc}(V_2) = \max(d(2,1), d(2,3), d(2,4)) = \max(1, 1, 2) = 2$
* $\text{Exc}(V_3) = \max(d(3,1), d(3,2), d(3,4)) = \max(1, 1, 1) = 1$
* $\text{Exc}(V_4) = \max(d(4,1), d(4,2), d(4,3)) = \max(1, 2, 1) = 2$

**Raio ($R_1$):** Menor excentricidade de $C_1$ $\to \mathbf{1}$

**Diâmetro ($D_1$):** Maior excentricidade de $C_1$ $\to \mathbf{2}$

**Vértices Centrais:** Vértices com excentricidade igual ao raio $\to \mathbf{\{V_1, V_3\}}$

**Centro:** Agrupamento dos vértices centrais $\to \mathbf{\{V_1, V_3\}}$

### Componente Conexa $C_2 = \{5, 6\}$

**Excentricidade de cada vértice :**
* $\text{Exc}(V_5) = \max(d(5,6)) = 1$
* $\text{Exc}(V_6) = \max(d(6,5)) = 1$

**Raio ($R_2$):** Menor excentricidade de $C_2$ $\to \mathbf{1}$

**Diâmetro ($D_2$):** Maior excentricidade de $C_2$ $\to \mathbf{1}$

**Vértices Centrais:** Vértices com excentricidade igual ao raio $\to \mathbf{\{V_5, V_6\}}$

**Centro:** Agrupamento dos vértices centrais $\to \mathbf{\{V_5, V_6\}}$

## 4. Rastreamento Manual do Algoritmo DFS (Identificação de Componentes)

O algoritmo utiliza Busca em Profundidade (DFS) para percorrer o grafo, atribuir o identificador de componente conexa (id) e definir a equipe (1 ou 2) alternadamente.

### Estruturas de Dados Utilizadas
* `marked[]`: Vetor booleano indicando se o vértice já foi visitado.
* `id[]`: Vetor de inteiros que armazena o ID da componente conexa de cada vértice.
* `equipe[]`: Vetor indicando a qual equipe o aluno pertence (1 ou 2).
* `count`: Contador global de componentes conexas encontradas.

### Execução Manual — DFS 1 (Componente $C_1$)

O laço principal varre os vértices e encontra `marked[1] == false`. Incrementa `count = 1` e dispara `dfs(1, equipe = 1)`.

1. $V_1$: `marked[1] = true`, `id[1] = 1`, `equipe[1] = 1`.
2. Consulta lista `[2, 3, 4]`. Vizinho $2$ não foi visitado $\to$ chama `dfs(2, equipe = 2)`.
3. $V_2$: `marked[2] = true`, `id[2] = 1`, `equipe[2] = 2`.
4. Consulta lista `[1, 3]`. $1$ já visitado. Vizinho $3$ não foi visitado $\to$ chama `dfs(3, equipe = 1)`.
5. $V_3$: `marked[3] = true`, `id[3] = 1`, `equipe[3] = 1`.
6. Consulta lista `[1, 2, 4]`. $1$ e $2$ já visitados. Vizinho $4$ não foi visitado $\to$ chama `dfs(4, equipe = 2)`.
7. $V_4$: `marked[4] = true`, `id[4] = 1`, `equipe[4] = 2`.
8. Consulta lista `[1, 3]`. Ambos já foram visitados.
9. Ocorre o backtracking, desempilhando e finalizando a busca nos vértices $4 \to 3 \to 2 \to 1$.

#### Árvore DFS 1
```text
1 (Equipe 1)
|
2 (Equipe 2)
|
3 (Equipe 1)
|
4 (Equipe 2)
```

#### Predecessores e Tempos
* **Predecessores:** $1 \to -$, $2 \to 1$, $3 \to 2$, $4 \to 3$
* **Tempo de Descoberta (TD):** 1 - 2 - 3 - 4
* **Tempo de Finalização (TF):** 4 - 3 - 2 - 1

### Execução Manual — DFS 2 (Componente $C_2$)

O laço principal avança e encontra `marked[5] == false`. Incrementa `count = 2` e dispara `dfs(5, equipe = 1)`.

1. $V_5$: `marked[5] = true`, `id[5] = 2`, `equipe[5] = 1`.
2. Consulta lista `[6]`. Vizinho $6$ não foi visitado $\to$ chama `dfs(6, equipe = 2)`.
3. $V_6$: `marked[6] = true`, `id[6] = 2`, `equipe[6] = 2`.
4. Consulta lista `[5]`. Já foi visitado.
5. Ocorre o backtracking, finalizando a busca em $6 \to 5$.

#### Árvore DFS 2
```text
5 (Equipe 1)
|
6 (Equipe 2)
```

#### Predecessores e Tempos
* **Predecessores:** $5 \to -$, $6 \to 5$
* **Tempo de Descoberta (TD):** 5 - 6
* **Tempo de Finalização (TF):** 6 - 5

### Estado Final das Estruturas de Dados

| Vértice | Visitado (`marked`) | Predecessor | ID da Componente (`id`) | Equipe Atribuída (`equipe`) |
|:---:|:---:|:---:|:---:|:---:|
| 1 | true | - | 1 | 1 |
| 2 | true | 1 | 1 | 2 |
| 3 | true | 2 | 1 | 1 |
| 4 | true | 3 | 1 | 2 |
| 5 | true | - | 2 | 1 |
| 6 | true | 5 | 2 | 2 |

## 5. Análise de Complexidade

### Complexidade de Tempo: $\mathcal{O}(V + E)$
* **Visita aos Vértices ($\mathcal{O}(V)$):** Cada aluno é marcado como visitado e processado no máximo uma vez.
* **Exploração das Arestas ($\mathcal{O}(E)$):** Cada relação de amizade (aresta) é verificada no máximo duas vezes (uma a partir de cada extremidade) ao percorrer a lista de adjacência.

O tempo total cresce estritamente de forma linear em relação ao tamanho da entrada.

### Complexidade de Espaço: $\mathcal{O}(V + E)$
* **Lista de Adjacência ($\mathcal{O}(V + E)$):** Armazena os $V$ vértices e as $2E$ entradas de arestas no grafo não-direcionado.
* **Vetores Auxiliares ($\mathcal{O}(V)$):** Os vetores `marked`, `id` e `equipe` consomem espaço proporcional a $V$.
* **Pilha de Recursão ($\mathcal{O}(V)$):** No pior caso (grafo em linha simples), a profundidade da pilha recursiva atinge $V$.

### Custo das Consultas de Conectividade
* **Com Pré-processamento ($\mathcal{O}(1)$):** Após a execução única do DFS, o vetor `id[]` fica totalmente preenchido. Para saber se dois alunos $A$ e $B$ pertencem ao mesmo componente conexo, basta comparar em tempo constante:

$$\text{id}[A] == \text{id}[B]$$

* **Sem Pré-processamento ($\mathcal{O}(V + E)$):** Sem armazenar o vetor de componentes, seria necessário realizar uma nova busca (DFS ou BFS) a cada consulta para verificar a existência de um caminho entre $A$ e $B$.
