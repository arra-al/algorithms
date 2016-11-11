package com.arra.algorithm.graph;

import java.io.InputStream;

import com.arra.algorithm.collection.Bag;

public class Graph {
	private final int V;
	private Bag<Integer>[] adj;
	
	/**
	 * Create an empty graph with V vertices
	 * @param V
	 */
	public Graph(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	
	/**
	 * Create a graph from input stream
	 * @param in
	 */
	public Graph(InputStream in) {
		
	}
	
	/**
	 * add an edge v-w
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	/**
	 * number of vertices
	 * @return
	 */
	public int V(){
		return this.V;
	}
	
	/**
	 * number of edges
	 * @return
	 */
	public int E() {
		return this.V - 1;
	}
}
