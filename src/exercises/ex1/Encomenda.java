package exercises.ex1;

import java.util.*;

import model.Graph;

public class Encomenda {

	public static List<Integer> encontrarCaminhoMaisCurto(Graph grafo, int inicio, int destino) {

		Queue<Integer> fila = new LinkedList<>();
		boolean[] visitado = new boolean[grafo.getNumVertices()];
		int[] predecessores = new int[grafo.getNumVertices()];

		Arrays.fill(predecessores, -1);
		fila.add(inicio);
		visitado[inicio] = true;

		while (!fila.isEmpty()) {
			int vertice = fila.poll();
			for (int vizinho : grafo.getAdjacencyList().get(vertice)) {
				if (!visitado[vizinho]) {
					visitado[vizinho] = true;
					predecessores[vizinho] = vertice;
					fila.add(vizinho);
					if (vizinho == destino) {
						return construirCaminho(predecessores, inicio, destino);
					}
				}
			}
		}

		return null;
	}

	private static List<Integer> construirCaminho(int[] predecessores, int inicio, int destino) {
		List<Integer> caminho = new ArrayList<>();
		int vertice = destino;
		while (vertice != inicio) {
			caminho.add(vertice);
			vertice = predecessores[vertice];
		}
		caminho.add(inicio);
		Collections.reverse(caminho);
		return caminho;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o numero de vertices do grafo: ");
		int numVertices = scanner.nextInt();

		Graph grafo = new Graph(numVertices);

		System.out.print("O grafo vai ser direcionado? (S/N) ");
		boolean isDirecionado = scanner.next().equalsIgnoreCase("S");

		while (true) {
			System.out.println("\nEscolha uma opcao:");
			System.out.println("1. Adicionar uma aresta");
			System.out.println("2. Encontrar o caminho mais curto entre dois vértices");
			System.out.println("3. Imprimir o grafo");
			System.out.println("4. Sair");

			int opcao = scanner.nextInt();

			if (opcao == 1) {
				System.out.print("Digite o primeiro vertice da aresta: ");
				int v = scanner.nextInt();
				System.out.print("Digite o segundo vertice da aresta: ");
				int w = scanner.nextInt();

				if (isDirecionado) {
					grafo.addDirectedEdge(v, w);
				} else {
					grafo.addUndirectedEdge(v, w);
				}

				System.out.println("Aresta adicionada com sucesso.");
			} else if (opcao == 2) {
				System.out.print("Digite o vertice de partida: ");
				int inicio = scanner.nextInt();
				System.out.print("Digite o vertice de destino: ");
				int destino = scanner.nextInt();

				List<Integer> caminho = encontrarCaminhoMaisCurto(grafo, inicio, destino);
				System.out.println("Caminho mais curto: " + caminho);
			} else if (opcao == 3) {
				System.out.println("Grafo atual:");
				grafo.printGraph();
			} else if (opcao == 4) {
				System.out.println("Obrigado por usar.");
				break;
			} else {
				System.out.println("Opcao invalida. Tente novamente.");
			}
		}

		scanner.close();
	}

}
