package edu.princeton.test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;


/**
 * The Class Kruskal.
 * @author ranjodh_singh
 * @see <a
 *      href="http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/">link</a>
 */
public class Kruskal {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Graph graph = new Graph(14);
		graph.addEdge(4, 0, 1);
		graph.addEdge(8, 1, 2);
		graph.addEdge(7, 2, 3);
		graph.addEdge(9, 3, 4);
		graph.addEdge(10, 4, 5);
		graph.addEdge(2, 6, 5);
		graph.addEdge(1, 7, 6);
		graph.addEdge(8, 0, 7);
		graph.addEdge(11, 7, 1);
		graph.addEdge(7, 7, 8);
		graph.addEdge(6, 8, 6);
		graph.addEdge(2, 2, 8);
		graph.addEdge(4, 2, 5);
		graph.addEdge(14, 3, 5);
		// created the graph with different edges.
		/*for (Edge edge : graph.getNeighbours(5)) {
			System.out.println("Weight " + edge.weight + " with " + edge.otherVertex(5));

		}*/
		Queue<Edge> edges = graph.getEdges();
      
		List<Edge> MST = new ArrayList<Edge>();
		UnionFind uF = new UnionFind(edges.size());
		Edge edge;
		while (( edge = (Edge)edges.poll())!= null) {
			if (uF.union(edge.first, edge.second)) {
				MST.add(edge);
			}
		}
		for (Edge edgeList : MST) {
			System.out.println("edge : " + edgeList);
		}

	}

	/**
	 * The Class UnionFind.
	 */
	static class UnionFind {
		
		/** The array. */
		int[] array;

		/**
		 * Instantiates a new union find.
		 *
		 * @param N the n
		 */
		public UnionFind(int N) {
			array = new int[N];
			for (int i = 0; i < array.length; i++) {
				array[i] = i;
			}
		}

		/**
		 * Union.
		 *
		 * @param a the a
		 * @param b the b
		 * @return true, if successful
		 */
		boolean union(int a, int b) {
			int first = root(a);
			int second = root(b);
			if (first == second) {
				return false;
			} else {
				array[first] = second;
				return true;
			}
		}

		/**
		 * Find.
		 *
		 * @param p the p
		 * @param q the q
		 * @return true, if successful
		 */
		public boolean find(int p, int q) {
			return root(p) == root(q);
		}

		/**
		 * Root.
		 *
		 * @param i the i
		 * @return the int
		 */
		private int root(int i) {
			while (i != array[i])
				i = array[i];
			return i;
		}
	}

	/**
	 * The Class Graph.
	 */
	static class Graph {

		/** The v. */
		int V;

		/** The e. */
		int E;

		/** The adj. */
		Set<Edge>[] adj;
		/**
		 * stores all the edges.
		 */
		Queue<Edge> edges = new PriorityQueue<Edge>();

		/**
		 * Instantiates a new graph.
		 *
		 * @param V
		 *            the v
		 */
		public Graph(int V) {
			adj = new Set[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new TreeSet<Kruskal.Edge>();
			}
		}

		/**
		 * Adds the edge.
		 *
		 * @param weight
		 *            the weight
		 * @param a
		 *            the a
		 * @param b
		 *            the b
		 */
		public void addEdge(int weight, int a, int b) {
			Edge edge = new Edge(weight, a, b);

			adj[a].add(edge);
			adj[b].add(edge);
			edges.add(edge);
		}

		/**
		 * Gets the edges.
		 *
		 * @return all the edges in a queue with their natural order.
		 */
		public Queue<Edge> getEdges() {
			return edges;
		}

		/**
		 * Gets the neighbours.
		 *
		 * @param v
		 *            the v
		 * @return the neighbours
		 */
		public Iterable<Edge> getNeighbours(int v) {
			return adj[v];
		}
	}

	/**
	 * The Class Edge. for storing a particular edge with the weight associate
	 * with it.
	 */
	static class Edge implements Comparable<Edge> {

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Edge [first=" + first + ", second=" + second + ", weight=" + weight + "]";
		}

		/** The second. */
		int first, second;

		/** The weight. */
		double weight;

		/**
		 * Instantiates a new edge.
		 *
		 * @param weight
		 *            the weight
		 * @param a
		 *            the first vertex
		 * @param b
		 *            the second vertex
		 */
		public Edge(int weight, int a, int b) {
			this.weight = weight;
			this.first = a;
			this.second = b;
		}

		/**
		 * Other vertex.
		 *
		 * @param vertex
		 *            the vertex
		 * @return the int
		 */
		public int otherVertex(int vertex) {
			if (vertex == first) {
				return second;
			} else if (vertex == second) {
				return first;
			} else {
				return -1;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Edge o) {
			if (this.weight < o.weight) {
				return -1;
			} else if (this.weight > o.weight) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
