Aqui está o código pronto para você copiar e colar no seu arquivo:Markdown# Marco 3 — Aplicação Básica de DFS

## 1. Lista de Adjacência

A partir da representação do grafo, foi construída a lista de adjacência dos vértices. A ordem dos vizinhos na lista depende da forma como as arestas são encontradas durante a leitura da matriz. Como a inserção dos vizinhos é realizada no início da lista, o vizinho encontrado mais recentemente fica na primeira posição.

Para o vértice `4`, caso `3` seja encontrado primeiro e `6` posteriormente, a lista será:

```text
4 → [6, 3]
Assim, o DFS seguirá primeiro o vizinho 6 e posteriormente 3.A lista de adjacência utilizada é:Plaintext1  → [2]
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
2. Execução Manual do DFSO grafo possui três componentes conexos. Portanto, é necessário iniciar um DFS para cada componente ainda não visitado.DFS 1 — Componente {1, 2}O DFS começa pelo vértice 1.Plaintext1 → 2
O vértice 2 possui apenas 1 como vizinho, que já foi visitado.Árvore DFS 1Plaintext1
|
2
PredecessoresPlaintext1 → -
2 → 1
Tempo de Descoberta e FinalizaçãoTD: 1 - 2TF: 2 - 1DFS 2 — Componente {3, 4, 5, 6, 7, 10, 11, 12}O DFS começa pelo vértice 3. A lista de adjacência de 3 é: 3 → [6, 4]. Portanto, o primeiro vizinho analisado será 6. A execução ocorre da seguinte forma:Plaintext3 → 6 → 10 → 11 → 12 → 7 → 5 → 4
Ao chegar em 4, seus vizinhos já foram visitados, portanto a busca começa a retornar.Árvore DFS 2A árvore representa as arestas utilizadas pelo DFS para descobrir cada novo vértice:Plaintext3
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
(Exemplo: 3 descobriu 6; 6 descobriu 10; e assim por diante. As demais arestas do grafo original não entram na árvore de descoberta quando conectam vértices que já haviam sido visitados).PredecessoresPlaintext3  → -
6  → 3
10 → 6
11 → 10
12 → 11
7  → 12
5  → 7
4  → 5
Tempo de Descoberta e FinalizaçãoDepois que o DFS chega ao vértice 4, não existem mais vértices novos para explorar. A finalização ocorre durante o retorno da busca:TD: 3 - 6 - 10 - 11 - 12 - 7 - 5 - 4TF: 4 - 5 - 7 - 12 - 11 - 10 - 6 - 3DFS 3 — Componente {8, 9}O DFS começa pelo vértice 8.Plaintext8 → 9
O vértice 9 possui apenas 8 como vizinho, que já foi visitado.Árvore DFS 3Plaintext8
|
9
PredecessoresPlaintext8 → -
9 → 8
Tempo de Descoberta e FinalizaçãoTD: 8 - 9TF: 9 - 83. Estados de Visita e PredecessoresA tabela apresenta o estado final dos vértices após a execução dos três DFS. O valor true indica que o vértice foi visitado, e o predecessor representa o vértice responsável por descobrir o vértice atual durante a busca.VérticeVisitadoPredecessor1true-2true13true-4true55true76true37true128true-9true810true611true1012true114. AlcançabilidadeA partir do vértice inicial de cada DFS, todos os vértices pertencentes ao mesmo componente conexo são alcançados. Não é possível alcançar vértices de outro componente, pois não existem arestas conectando esses componentes.DFS 1: 1 → {1, 2}DFS 2: 3 → {3, 4, 5, 6, 7, 10, 11, 12}DFS 3: 8 → {8, 9}5. Aplicabilidade ao ProblemaO DFS pode ser utilizado para encontrar os componentes conexos do grafo.No problema, cada posição . representa um vértice e as conexões entre posições adjacentes representam as arestas. Ao encontrar um vértice que ainda não foi visitado, um novo DFS é iniciado. Esse DFS visita todos os vértices conectados ao vértice inicial.Assim, cada execução do DFS corresponde a um componente conexo, que representa um cômodo. Neste exemplo foram realizadas três execuções:DFS 1 → Componente 1DFS 2 → Componente 2DFS 3 → Componente 3Portanto:Quantidade de componentes conexos: 3Quantidade de cômodos: 36. Adaptação do DFS à Representação ImplícitaComo foi utilizada a representação implícita, não é necessário armazenar explicitamente todas as arestas do grafo.Cada . representa um vértice do grafo. Para encontrar seus possíveis vizinhos, são verificadas as quatro posições adjacentes:Plaintext        cima
         ↑
         |
esquerda ← . → direita
         |
         ↓
       baixo
