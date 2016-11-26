package com.arra.algorithm.collection;

public abstract class UF {

	/**
	 * initialize union-fiend data structure with N objects (0 to N-1)
	 * @param N
	 */
	public UF(int N) {}
	
	/**
	 * add connection between p and q
	 * @param p
	 * @param q
	 */
	public abstract void union(int p, int q);
	
	/**
	 * are p and q in same component?
	 * @param p
	 * @param q
	 * @return
	 */
	public abstract boolean connected(int p, int q);
	
	/**
	 * component identifier for p (0 to N-1)
	 * @param p
	 * @return
	 */
	public abstract int find(int p);
	
	/**
	 * number of components
	 * @return
	 */
	public abstract int count();
	
}
