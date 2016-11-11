package com.arra.algorithm.graph;

public class GraphUtil {

	/**
	 * compute the degree of v
	 * @param G
	 * @param v
	 * @return
	 */
	public static int degree(Graph G, int v) {
		int degree = 0;
		for(int w : G.adj(v)) {
			degree++;
		}
		
		return degree;
	}
	
	/**
	 * compute max degree
	 * @param G
	 * @return
	 */
	public static int maxDegre(Graph G) {
		int max = 0;
		for(int v = 0; v < G.V(); v++) {
			int tempDegree = degree(G, v);
			if(tempDegree > max) {
				max = tempDegree;
			}
		}
		return max;
	}
	
	/**
	 * compute average degree
	 * @param G
	 * @return
	 */
	public static double averangeDegree(Graph G) {
		return 2.0 * G.E() / G.V();
	}
	
	/**
	 * number of self loops
	 * @param G
	 * @return
	 */
	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		for(int v = 0; v < G.V(); v++) {
			for(int w : G.adj(v)) {
				if(v==w) {
					count++;
				}
			}
		}
		return count/2;//each edge counted twice
	}
}
