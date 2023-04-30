package model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Represents a graph (directed or undirected) using an adjacency list.
 */
public class Graph {

	/** The number of vertices of the graph. */
	private int numVertices;
	/** The list of adjacent vertices to a particular vertex. */
	private ArrayList<LinkedList<Integer>> adjacencyList;

	/**
	 * 
	 * Constructs a graph with a specified number of vertices.
	 * 
	 * @param numVertices the number of vertices in the graph
	 */
	public Graph(int numVertices) {
		this.numVertices = numVertices;
		initializeAdjacencyList();
	}

	/**
	 * Initializes the adjacency list with empty linked lists for each vertex.
	 */
	private void initializeAdjacencyList() {
		this.adjacencyList = new ArrayList<>(numVertices);
		for (int i = 0; i < this.numVertices; ++i) {
			this.adjacencyList.add(new LinkedList<>());
		}
	}

	/**
	 * Adds a directed edge between two vertices in a directed graph.
	 * 
	 * @param v the source vertex
	 * @param w the destination vertex
	 */
	public void addDirectedEdge(int v, int w) {
		this.adjacencyList.get(v).add(w);
	}

	/**
	 * Adds an undirected edge between two vertices in an undirected graph.
	 * 
	 * @param v the source vertex
	 * @param w the destination vertex
	 */
	public void addUndirectedEdge(int v, int w) {
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v);
	}

	/**
	 * Prints the graph, showing the adjacency list for each vertex.
	 */
	public void printGraph() {
		for (int v = 0; v < this.numVertices; ++v) {
			System.out.print(v + ": ");
			for (Integer adj : this.adjacencyList.get(v))
				System.out.print(adj + " ");
			System.out.println();
		}
	}

	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}

	public ArrayList<LinkedList<Integer>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(ArrayList<LinkedList<Integer>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

}