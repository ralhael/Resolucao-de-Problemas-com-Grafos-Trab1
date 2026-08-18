# Resolução de Problemas com Grafos

## Mini Trabalho — Modelagem de um Mapa como Grafo

### 1. Problema

O problema apresenta um mapa de um prédio representado por uma matriz `N × M`.

Cada posição do mapa pode representar:

* `.` → quadrado de chão, onde é possível andar;
* `#` → parede.

É possível se movimentar para cima, baixo, esquerda e direita pelos quadrados de chão.

O objetivo é **contar a quantidade de cômodos existentes no prédio**.

### 2. Modelagem como Grafo

Para representar o problema utilizando a teoria dos grafos, podemos transformar o mapa em um grafo.

A representação utilizada foi:

* **Vértice:** cada quadrado de chão (`.`) do mapa;
* **Aresta:** existe uma aresta entre dois vértices quando os respectivos quadrados de chão são vizinhos e é possível andar diretamente entre eles;
* **Parede (`#`):** não é representada por um vértice e impede a existência de uma aresta entre os quadrados separados por ela.

Dessa forma, os caminhos possíveis dentro de cada cômodo são representados pelas arestas do grafo.

### 3. Componentes Conexos

Um cômodo pode ser representado como um **componente conexo** do grafo.

Isso significa que todos os quadrados de chão pertencentes ao mesmo cômodo possuem um caminho entre si.

Por exemplo, se temos:

```text
..#
..#
###
```

os quatro quadrados de chão pertencem ao mesmo componente conexo e, portanto, representam um cômodo.

Já em:

```text
..#..
..#..
..#..
```

existem dois componentes conexos, pois a parede impede a passagem entre os dois grupos.

Portanto, para descobrir o número de cômodos, podemos contar a quantidade de componentes conexos existentes no grafo.

### 4. Representação do Problema

Imagem da questão original:

![Questão](# Resolução de Problemas com Grafos

## Mini Trabalho — Modelagem de um Mapa como Grafo

### 1. Problema

O problema apresenta um mapa de um prédio representado por uma matriz `N × M`.

Cada posição do mapa pode representar:

* `.` → quadrado de chão, onde é possível andar;
* `#` → parede.

É possível se movimentar para cima, baixo, esquerda e direita pelos quadrados de chão.

O objetivo é **contar a quantidade de cômodos existentes no prédio**.

### 2. Modelagem como Grafo

Para representar o problema utilizando a teoria dos grafos, podemos transformar o mapa em um grafo.

A representação utilizada foi:

* **Vértice:** cada quadrado de chão (`.`) do mapa;
* **Aresta:** existe uma aresta entre dois vértices quando os respectivos quadrados de chão são vizinhos e é possível andar diretamente entre eles;
* **Parede (`#`):** não é representada por um vértice e impede a existência de uma aresta entre os quadrados separados por ela.

Dessa forma, os caminhos possíveis dentro de cada cômodo são representados pelas arestas do grafo.

### 3. Componentes Conexos

Um cômodo pode ser representado como um **componente conexo** do grafo.

Isso significa que todos os quadrados de chão pertencentes ao mesmo cômodo possuem um caminho entre si.

Por exemplo, se temos:

```text
..#
..#
###
```

os quatro quadrados de chão pertencem ao mesmo componente conexo e, portanto, representam um cômodo.

Já em:

```text
..#..
..#..
..#..
```

existem dois componentes conexos, pois a parede impede a passagem entre os dois grupos.

Portanto, para descobrir o número de cômodos, podemos contar a quantidade de componentes conexos existentes no grafo.

### 4. Representação do Problema

Imagem da questão original:

![Questão](# Resolução de Problemas com Grafos

## Mini Trabalho — Modelagem de um Mapa como Grafo

### 1. Problema

O problema apresenta um mapa de um prédio representado por uma matriz `N × M`.

Cada posição do mapa pode representar:

* `.` → quadrado de chão, onde é possível andar;
* `#` → parede.

É possível se movimentar para cima, baixo, esquerda e direita pelos quadrados de chão.

O objetivo é **contar a quantidade de cômodos existentes no prédio**.

### 2. Modelagem como Grafo

Para representar o problema utilizando a teoria dos grafos, podemos transformar o mapa em um grafo.

A representação utilizada foi:

* **Vértice:** cada quadrado de chão (`.`) do mapa;
* **Aresta:** existe uma aresta entre dois vértices quando os respectivos quadrados de chão são vizinhos e é possível andar diretamente entre eles;
* **Parede (`#`):** não é representada por um vértice e impede a existência de uma aresta entre os quadrados separados por ela.

Dessa forma, os caminhos possíveis dentro de cada cômodo são representados pelas arestas do grafo.

### 3. Componentes Conexos

Um cômodo pode ser representado como um **componente conexo** do grafo.

Isso significa que todos os quadrados de chão pertencentes ao mesmo cômodo possuem um caminho entre si.

Por exemplo, se temos:

```text
..#
..#
###
```

os quatro quadrados de chão pertencem ao mesmo componente conexo e, portanto, representam um cômodo.

Já em:

```text
..#..
..#..
..#..
```

existem dois componentes conexos, pois a parede impede a passagem entre os dois grupos.

Portanto, para descobrir o número de cômodos, podemos contar a quantidade de componentes conexos existentes no grafo.

### 4. Representação do Problema

Imagem da questão original:

![Questão](# Resolução de Problemas com Grafos

## Mini Trabalho — Modelagem de um Mapa como Grafo

### 1. Problema

O problema apresenta um mapa de um prédio representado por uma matriz `N × M`.

Cada posição do mapa pode representar:

* `.` → quadrado de chão, onde é possível andar;
* `#` → parede.

É possível se movimentar para cima, baixo, esquerda e direita pelos quadrados de chão.

O objetivo é **contar a quantidade de cômodos existentes no prédio**.

### 2. Modelagem como Grafo

Para representar o problema utilizando a teoria dos grafos, podemos transformar o mapa em um grafo.

A representação utilizada foi:

* **Vértice:** cada quadrado de chão (`.`) do mapa;
* **Aresta:** existe uma aresta entre dois vértices quando os respectivos quadrados de chão são vizinhos e é possível andar diretamente entre eles;
* **Parede (`#`):** não é representada por um vértice e impede a existência de uma aresta entre os quadrados separados por ela.

Dessa forma, os caminhos possíveis dentro de cada cômodo são representados pelas arestas do grafo.

### 3. Componentes Conexos

Um cômodo pode ser representado como um **componente conexo** do grafo.

Isso significa que todos os quadrados de chão pertencentes ao mesmo cômodo possuem um caminho entre si.

Por exemplo, se temos:

```text
..#
..#
###
```

os quatro quadrados de chão pertencem ao mesmo componente conexo e, portanto, representam um cômodo.

Já em:

```text
..#..
..#..
..#..
```

existem dois componentes conexos, pois a parede impede a passagem entre os dois grupos.

Portanto, para descobrir o número de cômodos, podemos contar a quantidade de componentes conexos existentes no grafo.

### 4. Representação do Problema

Imagem da questão original:

![Grafo da questão](ImgTrab1/printq.png)

### 5. Representação como Grafo

A partir do mapa, cada quadrado de chão foi transformado em um vértice e foram adicionadas arestas entre os quadrados que possuem movimentação direta entre si.

![Grafo da questão](ImgTrab1/grafo1Questao.png)

### 6. Conclusão

A modelagem do problema como um grafo permite interpretar o mapa de uma forma mais abstrata:

```text
Quadrado de chão → Vértice
Possibilidade de movimentação → Aresta
Cômodo → Componente conexo
```

Assim, o problema de contar os cômodos pode ser tratado como um problema de **contagem de componentes conexos em um grafo**.

Essa modelagem também permite utilizar algoritmos de busca em grafos, como **DFS (Depth-First Search)** ou **BFS (Breadth-First Search)**, para percorrer os quadrados de cada cômodo e determinar quantos componentes conexos existem.
)

### 5. Representação como Grafo

A partir do mapa, cada quadrado de chão foi transformado em um vértice e foram adicionadas arestas entre os quadrados que possuem movimentação direta entre si.

![Grafo da questão](ImgTrab1/grafo1Questao.png)

### 6. Conclusão

A modelagem do problema como um grafo permite interpretar o mapa de uma forma mais abstrata:

```text
Quadrado de chão → Vértice
Possibilidade de movimentação → Aresta
Cômodo → Componente conexo
```

Assim, o problema de contar os cômodos pode ser tratado como um problema de **contagem de componentes conexos em um grafo**.

Essa modelagem também permite utilizar algoritmos de busca em grafos, como **DFS (Depth-First Search)** ou **BFS (Breadth-First Search)**, para percorrer os quadrados de cada cômodo e determinar quantos componentes conexos existem.
)

### 5. Representação como Grafo

A partir do mapa, cada quadrado de chão foi transformado em um vértice e foram adicionadas arestas entre os quadrados que possuem movimentação direta entre si.

![Grafo da questão](ImgTrab1/grafo1Questao.png)

### 6. Conclusão

A modelagem do problema como um grafo permite interpretar o mapa de uma forma mais abstrata:

```text
Quadrado de chão → Vértice
Possibilidade de movimentação → Aresta
Cômodo → Componente conexo
```

Assim, o problema de contar os cômodos pode ser tratado como um problema de **contagem de componentes conexos em um grafo**.

Essa modelagem também permite utilizar algoritmos de busca em grafos, como **DFS (Depth-First Search)** ou **BFS (Breadth-First Search)**, para percorrer os quadrados de cada cômodo e determinar quantos componentes conexos existem.
)

### 5. Representação como Grafo

A partir do mapa, cada quadrado de chão foi transformado em um vértice e foram adicionadas arestas entre os quadrados que possuem movimentação direta entre si.

![Grafo da questão](ImgTrab1/grafo1Questao.png)

### 6. Conclusão

A modelagem do problema como um grafo permite interpretar o mapa de uma forma mais abstrata:

```text
Quadrado de chão → Vértice
Possibilidade de movimentação → Aresta
Cômodo → Componente conexo
```

Assim, o problema de contar os cômodos pode ser tratado como um problema de **contagem de componentes conexos em um grafo**.

Essa modelagem também permite utilizar algoritmos de busca em grafos, como **DFS (Depth-First Search)** ou **BFS (Breadth-First Search)**, para percorrer os quadrados de cada cômodo e determinar quantos componentes conexos existem.
