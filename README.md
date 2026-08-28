# Resolução de Problemas com Grafos — Trabalho 1

## 1. Questão

O problema apresenta um mapa de um prédio representado por uma matriz de dimensão `N × M`.

![Questão](ImgTrab1/printq.png)

A entrada fornece as dimensões da matriz e, em seguida, o mapa, onde cada posição representa chão ou parede.

A saída esperada é um inteiro representando a **quantidade de cômodos existentes no mapa**.

---

## 2. Interpretação e Modelagem

Para transformar o problema em um grafo, interpretamos:

* `.` → representa um espaço de chão e, portanto, um **vértice**.
* `#` → representa uma parede e não é considerado um vértice.
* **Aresta** → representa a possibilidade de andar entre dois espaços de chão adjacentes, podendo se movimentar para cima, baixo, esquerda ou direita.

Dessa forma, os espaços de chão conectados entre si formam um **subgrafo**.

Cada subgrafo conectado representa um **cômodo**.

---

## 3. Representação como Grafo

A partir da interpretação do mapa, foi construída a seguinte representação:

![Grafo da questão](ImgTrab1/grapho1Questao.png)

Na representação existem **3 subgrafos**, ou seja, **3 grupos de vértices que não possuem conexão entre si**.

Portanto:

* **Quantidade de subgrafos:** 3
* **Quantidade de cômodos:** 3
* **Saída esperada:** `3`

---

## 4. Nova Entrada

Nesta etapa será adicionada uma nova entrada para representar outro mapa como grafo e verificar uma nova saída.

### Entrada

```text
7 10
##########
#..#.....#
#..#..#..#
####..#..#
#........#
#.########
#........#
```

### Saída Esperada

```text
2
```

## Representação com Grafo 
 
![Grafo da questão](ImgTrab1/GrafoProblemaNovo.png)

* **Quantidade de subgrafos:** 2
* **Quantidade de cômodos:** 2
* **Saída esperada:** `2`

---

## MARCO 2

---

## 5. Matriz de Adjacência do Grafo Problema 1

Aqui iremos mostrar a Matriz de Adjacência que constitui em uma matriz quadrada que os vértices compõe cada linha e cada coluna, e cada posição Xij representa a conexão/ligação dos respectivos vértices 

![Matriz de Adjacência](ImgTrab1/MatrizAdjacencia.png)


  * Positivo: Nesse modelo a matriz de adjacência tem uma facilidade de encontrar se dois vértices possuem ligação, basta consultar M[i,j]. 
  * Negativo: Se torna inviável visto que o consumo de memoria é muito alto para que o armazenamento da maioria das posições da matriz sejam 0 já que possuem apenas 4 vizinhos no máximo.

---

## 6. Lista de Adjacência do Grafo Problema 1

Aqui iremos mostrar a Lista de Adjacência que constitui em uma lista que cada posição é um vértice do grafo , e em cada posição tem outra lista com todos os outros vértices que fazem conexão diretamente com ele

![Lista de Adjacência](ImgTrab1/listaAdj.png)

  * Positivo: Nesse modelo se torna mais viável , pois eu vou armazenar apenas os vizinhos ligados diretamente ao vértice que no máximo serão quatro ( cima , baixo , esquerda , direita) 
  * Negativo: Para eu verificar se 2 vértices tem acesso eu teria que percorrer a lista daquela posição ate encontrar o vértice desejado.

## 7. Representação implícita do Grafo Problema 1

* Positivo: é a mais adequada para esse problema porque não precisamos armazenar explicitamente as arestas do grafo, o próprio mapa deixa nos observarmos se há conectividade ou nao. Se observar cada '.' que são nossos      vertices,  eles representam o quadrado do chão  e se olhar para cima, baixo , esquerda e direita você conseguira ver se eles tem conexão se houver outro '.' de encontro , assim demonstrando a possibilidade de andar      entre os dois quadrados no chão.

  
## 8. Medidas Estruturais Pertinentes

  * Ordem : 12
  * Tamanho : 22


---

## MARCO 3

---

# Marco 3 — Aplicação básica de DFS

## 1. Lista de Adjacência

A partir da representação do grafo, foi construída a lista de
adjacência dos vértices, a ordem dos vizinhos na lista depende da forma como as arestas são
encontradas durante a leitura da matriz. Como a inserção dos vizinhos é realizada no início da lista, o vizinho encontrado mais recentemente
fica na primeira posição.Para o vértice `4`, caso `3` seja encontrado primeiro e `6`
posteriormente, a lista será:

```text
4 → [6, 3]
```

Assim, o DFS seguirá primeiro o vizinho `6` e posteriormente `3`.

A lista de adjacência utilizada é:

```text
1  → [2]
2  → [1]

3  → [6, 4]
4  → [5, 3]
5  → [7, 4]
6  → [10, 3]
7  → [12, 5]
10 → [11, 6]
11 → [12, 10]
12 → [7, 11]

8  → [9]
9  → [8]
```

---

## 2. Execução Manual do DFS

O grafo possui três componentes conexos. Portanto, é necessário iniciar
um DFS para cada componente ainda não visitado.



---

### DFS 1 — Componente `{1, 2}`

O DFS começa pelo vértice `1`.

```text
1 → 2
```

O vértice `2` possui apenas `1` como vizinho, que já foi visitado.

#### Árvore DFS 1

```text
1
|
2
```

#### Predecessores

```text
1 → -
2 → 1
```

#### Tempo de Descoberta

```text
TD: 1 - 2
```

#### Tempo de Finalização

```text
TF: 2 - 1
```

---

### DFS 2 — Componente `{3, 4, 5, 6, 7, 10, 11, 12}`

O DFS começa pelo vértice `3`.

A lista de adjacência de `3` é:

```text
3 → [6, 4]
```

Portanto, o primeiro vizinho analisado será `6`.

A execução ocorre da seguinte forma:

```text
3 → 6 → 10 → 11 → 12 → 7 → 5 → 4
```

Ao chegar em `4`, seus vizinhos já foram visitados, portanto a busca
começa a retornar.

#### Árvore DFS 2

```text
3
|
6
|
10
|
11
|
12
|
7
|
5
|
4
```

A árvore representa as arestas utilizadas pelo DFS para descobrir cada
novo vértice.

Dessa forma:

```text
3 descobriu 6
6 descobriu 10
10 descobriu 11
11 descobriu 12
12 descobriu 7
7 descobriu 5
5 descobriu 4
```

As demais arestas do grafo original não entram na árvore de descoberta
quando conectam vértices que já haviam sido visitados.

#### Predecessores

```text
3  → -
6  → 3
10 → 6
11 → 10
12 → 11
7  → 12
5  → 7
4  → 5
```

#### Tempo de Descoberta

```text
TD: 3 - 6 - 10 - 11 - 12 - 7 - 5 - 4
```

#### Tempo de Finalização

Depois que o DFS chega ao vértice `4`, não existem mais vértices novos
para explorar. A finalização ocorre durante o retorno da busca:

```text
TF: 4 - 5 - 7 - 12 - 11 - 10 - 6 - 3
```

---

### DFS 3 — Componente `{8, 9}`

O DFS começa pelo vértice `8`.

```text
8 → 9
```

O vértice `9` possui apenas `8` como vizinho, que já foi visitado.

#### Árvore DFS 3

```text
8
|
9
```

#### Predecessores

```text
8 → -
9 → 8
```

#### Tempo de Descoberta

```text
TD: 8 - 9
```

#### Tempo de Finalização

```text
TF: 9 - 8
```

---

## 3. Estados de Visita e Predecessores

A tabela apresenta o estado final dos vértices após a execução dos três
DFS.

| Vértice | Visitado | Predecessor |
|---|---|---|
| 1 | `true` | - |
| 2 | `true` | 1 |
| 3 | `true` | - |
| 4 | `true` | 5 |
| 5 | `true` | 7 |
| 6 | `true` | 3 |
| 7 | `true` | 12 |
| 8 | `true` | - |
| 9 | `true` | 8 |
| 10 | `true` | 6 |
| 11 | `true` | 10 |
| 12 | `true` | 11 |

O valor `true` indica que o vértice foi visitado pelo DFS.

O predecessor representa o vértice responsável por descobrir o vértice
atual durante a busca.

---

## 4. Alcançabilidade

A partir do vértice inicial de cada DFS, todos os vértices pertencentes
ao mesmo componente conexo são alcançados.

```text
DFS 1:
1 → {1, 2}

DFS 2:
3 → {3, 4, 5, 6, 7, 10, 11, 12}

DFS 3:
8 → {8, 9}
```

Não é possível alcançar vértices de outro componente, pois não existem
arestas conectando esses componentes.

---

## 5. Aplicabilidade ao Problema

O DFS pode ser utilizado para encontrar os componentes conexos do
grafo.

No problema, cada posição `.` representa um vértice e as conexões entre
posições adjacentes representam as arestas.

Ao encontrar um vértice que ainda não foi visitado, um novo DFS é
iniciado. Esse DFS visita todos os vértices conectados ao vértice
inicial.

Assim, cada execução do DFS corresponde a um componente conexo, que
representa um cômodo.

Neste exemplo foram realizadas três execuções:

```text
DFS 1 → {1, 2}

DFS 2 → {3, 4, 5, 6, 7, 10, 11, 12}

DFS 3 → {8, 9}
```

Portanto:

```text
Quantidade de componentes conexos: 3
Quantidade de cômodos: 3
```

---

## 6. Adaptação do DFS à Representação Implícita

Como foi utilizada a representação implícita, não é necessário armazenar
explicitamente todas as arestas do grafo.

Cada `.` representa um vértice do grafo. Para encontrar seus possíveis
vizinhos, são verificadas as quatro posições adjacentes:

```text
        cima
          ↑
          |
esquerda ← . → direita
          |
          ↓
        baixo
```

Se a posição analisada também possuir `.`, existe uma conexão entre os
dois vértices.

Dessa forma, o DFS pode utilizar diretamente o mapa para descobrir os
vizinhos de cada vértice, verificando as quatro direções possíveis.
