package exercises.ex1;

import java.util.*;

import model.Graph;

public class Encomenda {

    public static List<Integer> caminhoMaisCurto(Graph graph, int start, int end) {
        // Initialize arrays to keep track of visited vertices and their predecessors
        boolean[] visited = new boolean[graph.getNumVertices()];
        int[] predecessors = new int[graph.getNumVertices()];

        // Initialize queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        predecessors[start] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Check if we've reached the end node
            if (current == end) {
                return getPath(predecessors, start, end);
            }

            // Traverse all adjacent nodes
            for (int adjacent : graph.getAdjacencyList().get(current)) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    predecessors[adjacent] = current;
                    queue.offer(adjacent);
                }
            }
        }

        // No path found
        return new ArrayList<>();
    }

    public static List<Integer> getPath(int[] predecessors, int start, int end) {
        List<Integer> path = new ArrayList<>();

        // Traverse the predecessors array backwards from the end node to the start node
        int current = end;
        while (current != -1) {
            path.add(current);
            current = predecessors[current];
        }

        // Reverse the list to get the correct order from start to end
        Collections.reverse(path);
        return path;
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

                grafo.addUndirectedEdge(v, w);

                System.out.println("Aresta adicionada com sucesso.");
            } else if (opcao == 2) {
                System.out.print("Digite o vertice de partida: ");
                int inicio = scanner.nextInt();
                System.out.print("Digite o vertice de destino: ");
                int destino = scanner.nextInt();

                List<Integer> caminho = caminhoMaisCurto(grafo, inicio, destino);
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
