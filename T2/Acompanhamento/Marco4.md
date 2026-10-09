# CSES 1668 - Building Teams

Solução em Java para o problema **Building Teams (CSES 1668)**, resolvido através da verificação de **2-colorabilidade (Grafo Bipartido)** utilizando **Busca em Profundidade Iterativa (Non-recursive DFS)**.

---

##  Código Completo

```java
package Graphos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayDeque;
import java.util.Deque;

class FastScanner {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastScanner() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                String line = reader.readLine();
                if (line == null) return null;
                tokenizer = new StringTokenizer(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}

class Graph {
    private final int V;
    private final List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}

class NonrecursiveDFS {
    private final int[] equipe;
    private boolean impossivel = false;

    @SuppressWarnings("unchecked")
    public NonrecursiveDFS(Graph G) {
        int V = G.V();
        equipe = new int[V];

        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[V];
        for (int v = 0; v < V; v++) {
            adj[v] = G.adj(v).iterator();
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (equipe[i] == 0) {
                equipe[i] = 1;
                stack.push(i);

                while (!stack.isEmpty()) {
                    int v = stack.peek();

                    if (adj[v].hasNext()) {
                        int w = adj[v].next();

                        if (equipe[w] == 0) {
                            equipe[w] = 3 - equipe[v];
                            stack.push(w);
                        } else if (equipe[w] == equipe[v]) {
                            impossivel = true;
                            return;
                        }
                    } else {
                        stack.pop();
                    }
                }
            }
        }
    }

    public boolean isImpossivel() {
        return impossivel;
    }

    public int[] getEquipes() {
        return equipe;
    }
}

public class Main {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String nStr = scanner.next();
        if (nStr == null) return;

        int n = Integer.parseInt(nStr);
        int m = scanner.nextInt();

        Graph G = new Graph(n);

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            G.addEdge(u, v);
        }

        NonrecursiveDFS dfs = new NonrecursiveDFS(G);

        if (dfs.isImpossivel()) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder sb = new StringBuilder();
            int[] equipes = dfs.getEquipes();
            for (int i = 0; i < n; i++) {
                sb.append(equipes[i]).append(i == n - 1 ? "" : " ");
            }
            System.out.println(sb.toString());
        }
    }
}




## Explicação dos Pontos Principais

### 1. Leitura de Dados e Composição do Grafo
* **Performance de E/S (FastScanner):** A leitura usa `BufferedReader` e `StringTokenizer`. Isso é necessário para processar as 10^5 entradas de nós e arestas sem estourar o limite de tempo do julgador (*Time Limit Exceeded - TLE*).
* **Mapeamento de Índices (Base 1 para Base 0):** O CSES numera os alunos de 1 a N, enquanto a estrutura de arrays em Java é indexada de 0 a N-1. Na leitura das arestas, ajustamos a entrada fazendo `scanner.nextInt() - 1`.
* **Construção do Grafo:** A classe `Graph` é inicializada com o número de vértices N. A chamada `G.addEdge(u, v)` insere a ligação bidirecional (grafo não direcionado) adicionando `v` na lista de adjacência de `u` e vice-versa.

### 2. Atribuição das Equipes com a Lógica `3 - equipe[v]`
O problema exige que dois amigos diretos fiquem em equipes diferentes, o que equivale a dividir um **grafo bipartido** usando 2 cores/equipes (representadas pelos inteiros 1 e 2).

A expressão aritmética `equipe[w] = 3 - equipe[v]` é uma forma simples de alternar as equipes entre vértices adjacentes:
* **Se o vértice atual v pertence à Equipe 1:** `equipe[w] = 3 - 1 = 2` *(o vizinho w vai para a Equipe 2)*
* **Se o vértice atual v pertence à Equipe 2:** `equipe[w] = 3 - 2 = 1` *(o vizinho w vai para a Equipe 1)*

Se durante a navegação o algoritmo encontrar um vizinho `w` que já possui a mesma equipe do vértice atual `v` (`equipe[w] == equipe[v]`), significa que um **ciclo ímpar** foi detectado no grafo. Isso torna a divisão impossível, ativando a flag `impossivel = true`.
