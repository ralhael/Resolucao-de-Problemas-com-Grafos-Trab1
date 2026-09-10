
---

# `acompanhamento/marco-2.md`

```markdown
# Marco 2 — Representação Computacional

## 1. Matriz de Adjacência do Grafo Problema 1

A matriz de adjacência consiste em uma matriz quadrada na qual os
vértices compõem cada linha e cada coluna. Cada posição `X[i][j]`
representa a conexão/ligação dos respectivos vértices.

![Matriz de Adjacência](../ImgTrab1/MatrizAdjacencia.png)

* **Positivo:** Nesse modelo, a matriz de adjacência facilita encontrar
se dois vértices possuem ligação, basta consultar `M[i][j]`.

* **Negativo:** Torna-se inviável visto que o consumo de memória é muito
alto para o armazenamento da maioria das posições da matriz como `0`,
já que cada vértice possui no máximo quatro vizinhos.

---

## 2. Lista de Adjacência do Grafo Problema 1

A lista de adjacência consiste em uma lista na qual cada posição
representa um vértice do grafo e, em cada posição, existe outra lista
com todos os outros vértices que possuem conexão direta com ele.

![Lista de Adjacência](../ImgTrab1/listaAdj.png)

* **Positivo:** Nesse modelo se torna mais viável, pois são armazenados
apenas os vizinhos ligados diretamente ao vértice, que no máximo serão
quatro: cima, baixo, esquerda e direita.

* **Negativo:** Para verificar se dois vértices possuem acesso, seria
necessário percorrer a lista daquela posição até encontrar o vértice
desejado.

---

## 3. Representação Implícita do Grafo Problema 1

* **Positivo:** É a mais adequada para esse problema porque não
precisamos armazenar explicitamente as arestas. O próprio mapa permite
observar se há conectividade ou não.

Se observar cada `.` que representa nossos vértices, eles representam o
quadrado do chão. Ao olhar para cima, baixo, esquerda e direita, podemos
verificar se existe conexão caso haja outro `.` de encontro, demonstrando
a possibilidade de andar entre os dois quadrados no chão.

---

## 4. Medidas Estruturais Pertinentes

* **Ordem:** 12
* **Tamanho:** 22
