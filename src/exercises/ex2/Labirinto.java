package exercises.ex2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import model.Graph;

public class Labirinto {

	/**
	 * Performs a BFS traversal starting from the source vertex and returns the
	 * shortest path to the destination vertex.
	 * 
	 * @param source the source vertex
	 * @param dest   the destination vertex
	 * @return a list containing the vertices on the shortest path from the source
	 *         to the destination
	 */
	public static List<Integer> findShortestPath(Graph graph, int source, int dest) {
		// array to store the visited status of each vertex
		boolean[] visited = new boolean[graph.getNumVertices()];
		// array to store the previous vertex on the shortest path to each vertex
		int[] prev = new int[graph.getNumVertices()];
		// initialize arrays
		for (int i = 0; i < graph.getNumVertices(); ++i) {
			visited[i] = false;
			prev[i] = -1;
		}

		// queue for BFS traversal
		Queue<Integer> queue = new LinkedList<Integer>();
		// add source vertex to queue and mark as visited
		queue.add(source);
		visited[source] = true;

		// perform BFS traversal
		while (!queue.isEmpty()) {
			int currentVertex = queue.poll();
			// stop BFS if destination vertex is found
			if (currentVertex == dest) {
				break;
			}
			// iterate over adjacent vertices of current vertex
			for (int neighbor : graph.getAdjacencyList().get(currentVertex)) {
				if (!visited[neighbor]) {
					// add neighbor to queue and mark as visited
					queue.add(neighbor);
					visited[neighbor] = true;
					// update previous vertex for neighbor
					prev[neighbor] = currentVertex;
				}
			}
		}

		// build shortest path by tracing back from destination vertex to source vertex
		List<Integer> shortestPath = new ArrayList<>();
		int currentVertex = dest;
		while (currentVertex != -1 && prev[currentVertex] != -1) {
			shortestPath.add(0, currentVertex);
			currentVertex = prev[currentVertex];
		}
		// add source vertex to shortest path
		shortestPath.add(0, source);

		return shortestPath;
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
					System.out.println(
							"Não foi possível adicionar um vertice na aresta, porque ele não existe no grafo.");
				}
			} else if (opcao == 2) {
				System.out.print("Digite o vertice de partida: ");
				int inicio = scanner.nextInt();
				System.out.print("Digite o vertice de destino: ");
				int destino = scanner.nextInt();

				List<Integer> caminho = findShortestPath(grafo, inicio, destino);
				System.out.println("Caminho mais curto: " + caminho);
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
