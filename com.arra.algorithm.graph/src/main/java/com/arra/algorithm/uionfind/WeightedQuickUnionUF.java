package com.arra.algorithm.uionfind;

public class WeightedQuickUnionUF extends QuickUnionUF{
	/**
	 * how big is the tree of root
	 */
	private int[] sz;
	
	public WeightedQuickUnionUF(int N) {
		super(N);
		
		sz = new int[N];
		for(int i = 0; i < sz.length; i++) {
			sz[i] = 0;
		}
	}

	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		
		if(sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
}
