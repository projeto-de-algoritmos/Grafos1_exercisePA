# Grafos 1 - Exercícios PA

**Número da Lista**: 1<br>
**Conteúdo da Disciplina**: Grafos 1<br>

## Alunos
|Matrícula | Aluno |
| -- | -- |
| 19/0029731  |  Ingrid da Silva Carvalho |
| 19/0115548  |  Pedro Lucas Garcia |

## Sobre 
O projeto é destinado a matéria de Projeto de Algoritmos da UNB-FGA, mais especificamente ao conteúdo aprendido sobre grafos 1.

### Exercício 1 - Encomenda
- Enunciado:

Você foi contratado para ajudar a empresa de transporte de uma cidade a encontrar a rota mais curta para entregar uma encomenda em um bairro específico. A cidade é representada por um grafo não direcionado onde as arestas representam as ruas da cidade e os vértices representam os cruzamentos. Você precisa criar um programa que, dado o grafo da cidade, o ponto de partida e o ponto de entrega, encontre o caminho mais curto entre esses pontos. Para isso, você deve usar a busca em largura (BFS).

- Entradas:

Um objeto Graph contendo o grafo da cidade.
Um inteiro representando o ponto de partida.
Um inteiro representando o ponto de entrega.

- Saída esperada:

Uma lista de inteiros representando o caminho mais curto entre o ponto de partida e o ponto de entrega. A lista deve ser ordenada da origem até o destino. Se não houver caminho entre os pontos, a lista deve estar vazia.
 
- Casos de teste:
1. Grafo com 4 vértices, arestas (0,1), (0,2), (1,3), (2,3), ponto de partida 0 e ponto de entrega 3.
- Saída esperada: [0, 2, 3]

2. Grafo com 5 vértices, arestas (0,1), (0,2), (1,3), (2,3), ponto de partida 0 e ponto de entrega 4.
- Saída esperada: []

### Exercício 2 - Labirinto
- Enunciado: 

Você é responsável por desenvolver um sistema de navegação de um jogo de labirinto. O labirinto é representado por um grafo não direcionado, onde os vértices são as salas e as arestas indicam as portas que interligam as salas. O objetivo é encontrar o caminho mais curto da sala de entrada até a sala de saída. Para isso, você deve implementar um algoritmo que utiliza BFS.

- Entradas:

Um objeto Graph contendo o grafo do labirinto.
Um inteiro representando a sala de entrada.
Um inteiro representando a sala de saída.

- Saída esperada:

Uma lista de inteiros representando o caminho mais curto entre a sala de entrada e a sala de saída. A lista deve ser ordenada da origem até o destino. Se não houver caminho entre as salas, a lista deve estar vazia.

- Casos de teste:
1. Grafo com 6 vértices e arestas (0,1), (0,2), (1,3), (2,4), (3,5) e (4,5). Sala de entrada: 0. Sala de saída: 5.
- Saída esperada:
Caminho mais curto: [0, 1, 3, 5]

2. Grafo com 4 vértices e arestas (0,1), (0,2), (2,3). Sala de entrada: 0. Sala de saída: 3.
- Saída esperada:
Caminho mais curto: [0, 2, 3]

### Exercício 3 - Rede social
- Enunciado: 

Você foi contratado por uma empresa de redes sociais para encontrar a distância de amizade entre dois usuários. Cada usuário é representado por um vértice e duas pessoas são consideradas amigas se há uma aresta que as liga. Você deve implementar um algoritmo que encontra a distância de amizade entre dois usuários utilizando BFS.

- Entradas:

Um objeto Graph contendo o grafo de amizade.
Um inteiro representando o usuário de origem.
Um inteiro representando o usuário de destino.

- Saída esperada:

Um inteiro representando a distância de amizade entre os usuários. Se não houver conexão entre os usuários, a distância de amizade deve ser -1.

- Casos de teste:
1. Grafos com 6 vértices e arestas (0, 1), (0, 2), (1, 3), (1, 4) e (2, 5). Amigo inicial: 0. Amigo final: 5.
- Saída esperada:
Distancia: 2

2. Grafos com 6 vértices e arestas (0, 1), (1, 2), (2, 3), (3, 4) e (4, 5). Amigo inicial: 0. Amigo final: 5.
- Saída esperada:
Distancia: 5

3. Grafos com 6 vértices e arestas (0, 1), (1, 2), (2, 3), (3, 4) e (4, 5). Amigo inicial: 0. Amigo final: 4.
- Saída esperada:
Distancia: 4

### Exercício 4 - Message Route
Baseado no site cses.fi: 
https://cses.fi/problemset/task/1667/

### Exercício 5 - Apertos de mão
- Enunciado:
Baseado na regra dos seis apertos de mão, o intuito é descobrir a quantidade minima de partos de mãos que separam duas pessoas.

- Entradas:
nomes das duas pessoas que descobriremos a distancia
dois inteiros com a quantidade de pessoas e a quantidade de apertos de mão
nomes das pessoas
nome da pessoa x que apertou a mão da pessoa y

- Saída esperada:
quantidade mínima de apertos de mão para conectar as pessoas

- Caso de teste:
1. marcos maria
5 7
marcos
marta
mateus
marlia
maria
marcos mateus
marta maria
marcos marlia
marta marcos
maria marlia
marlia marta
marcos marlia

- Saída esperada:
2

## Instalação 
**Linguagem**: java<br>




