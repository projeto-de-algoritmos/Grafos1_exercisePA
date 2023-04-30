package exercises.ex3;

import java.util.*;

import model.Graph;

public class SocialNetwork {

	public static int distanceOfFriendship(Graph graph, int user1, int user2) {
		Queue<Integer> queue = new LinkedList<>(); // Fila de visitas
		boolean[] visited = new boolean[graph.getNumVertices()]; // Marcador de visitas
		int[] distance = new int[graph.getNumVertices()]; // Distância de amizade

		// Inicializa o vetor de distância com -1
		Arrays.fill(distance, -1);

		queue.add(user1); // Adiciona o usuário de origem na fila
		visited[user1] = true; // Marca o usuário de origem como visitado
		distance[user1] = 0; // Define a distância de amizade do usuário de origem como 0

		while (!queue.isEmpty()) {
			int current = queue.poll(); // Remove o próximo usuário a ser visitado da fila

			// Verifica se o usuário atual é o usuário de destino
			if (current == user2) {
				return distance[current];
			}

			// Percorre todos os amigos do usuário atual
			for (int friend : graph.getAdjacencyList().get(current)) {
				if (!visited[friend]) {
					visited[friend] = true; // Marca o amigo como visitado
					distance[friend] = distance[current] + 1; // Define a distância de amizade do amigo
					queue.add(friend); // Adiciona o amigo na fila de visitas
				}
			}
		}

		// Se não encontrou uma conexão entre os usuários, retorna -1
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o numero de vertices do grafo: ");
		int numVertices = scanner.nextInt();

		Graph grafo = new Graph(numVertices);

		while (true) {
			System.out.println("\nEscolha uma opcao:");
			System.out.println("1. Adicionar uma aresta");
			System.out.println("2. Encontrar o caminho mais curto entre dois vértices");
			System.out.println("3. Imprimir o grafo");
			System.out.println("4. Sair");

			int opcao = scanner.nextInt();

			if (opcao == 1) {
				System.out.print("Vertice1 da aresta: ");
				int v = scanner.nextInt();
				System.out.print("Vertice2 da aresta: ");
				int w = scanner.nextInt();

				if (v < numVertices && w < numVertices) {
					grafo.addUndirectedEdge(v, w);

					System.out.println("Aresta adicionada com sucesso.");
				} else {
					System.out.println("Nao foi possivel adicionar um vertice na aresta, porque ele nao existe no grafo.");
				}
			} else if (opcao == 2) {
				System.out.print("Digite o vertice de partida: ");
				int inicio = scanner.nextInt();
				System.out.print("Digite o vertice de destino: ");
				int destino = scanner.nextInt();

				int caminho = distanceOfFriendship(grafo, inicio, destino);
				System.out.println("Distancia: " + caminho);
			} else if (opcao == 3) {
				grafo.printGraph();
			} else if (opcao == 4) {
				break;
			} else {
				System.out.println("Opcao invalida. Tente novamente.");
			}
		}

		scanner.close();
	}
}
