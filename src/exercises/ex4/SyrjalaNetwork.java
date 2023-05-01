package exercises.ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import model.Graph;

public class SyrjalaNetwork {

	public static List<Integer> findShortestPath(Graph graph, int start, int end) {
		int numVertices = graph.getNumVertices();
		boolean[] visited = new boolean[numVertices];
		int[] parent = new int[numVertices];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		parent[start] = -1;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == end) { // encontrou o nó final
				List<Integer> path = new ArrayList<>();
				int node = end;
				while (node != -1) {
					path.add(node);
					node = parent[node]; // adiciona o nó pai ao caminho
				}
				Collections.reverse(path);
				return path;
			}

			for (int neighbor : graph.getAdjacencyList().get(current)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					parent[neighbor] = current; // armazena o nó pai
					queue.add(neighbor);
				}
			}
		}

		// não encontrou caminho
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// Create graph
		Graph graph = new Graph(n);

		// Add edges
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			graph.addUndirectedEdge(a, b);
		}

		int start = 0;
		int end = n - 1;

		// Find shortest path
		List<Integer> path = findShortestPath(graph, start, end);

		if (path == null) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(path.size());
			for (int i = 0; i < path.size(); i++) {
				System.out.print((path.get(i) + 1) + " ");
			}
		}
		sc.close();
	}

}
