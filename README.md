# Resolução de Problemas com Grafos — Trabalho 1

## Integrantes

- Raphael Albuquerque
- Vinicius Freitas

## Sobre o trabalho

Este trabalho apresenta a modelagem e a resolução de um problema de
contagem de cômodos em um mapa utilizando conceitos de Teoria dos Grafos.

O mapa é representado por uma matriz, onde os espaços de chão (`.`)
representam vértices e as conexões entre espaços adjacentes representam
arestas.

A solução utiliza busca em profundidade (DFS) para identificar os
componentes conexos do grafo, sendo cada componente correspondente a um
cômodo.

## Organização

### Marco 1 — Problema e Modelagem

Apresentação do problema, interpretação da entrada e saída e modelagem
do mapa como um grafo.

[Ver Marco 1](acompanhamento/marco-1.md)

### Marco 2 — Representação Computacional

Apresentação das representações por matriz de adjacência, lista de
adjacência e representação implícita, incluindo suas vantagens,
desvantagens e medidas estruturais.

[Ver Marco 2](acompanhamento/marco-2.md)

### Marco 3 — Aplicação de DFS

Execução manual do DFS, estados de visita, predecessores, árvore de
busca, tempos de descoberta e finalização, alcançabilidade e aplicação
ao problema.

[Ver Marco 3](acompanhamento/marco-3.md)

### Marco 4 — Validação

Apresentação da implementação, casos de teste e validação da solução.

[Ver Marco 4](acompanhamento/marco-4.md)

## Estrutura do projeto

```text
acompanhamento/
├── marco-1.md
├── marco-2.md
├── marco-3.md
└── marco-4.md

src/
└── Main.java

evidencias/
└── accepted.png

apresentacao/
└── apresentacao.pdf

dados/
└── casos-de-teste.txt
