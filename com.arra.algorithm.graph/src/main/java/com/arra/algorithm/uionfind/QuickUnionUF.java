package com.arra.algorithm.uionfind;

/**
 * id[i] is parent of i
 * Root of i is id[id[id[...id[i]...]]].
 * 
 * 		0	1	2	3	4	5	6	7	8	9
 * id[] 0	1	9	4	9	6	6	7	8	9
 * 
 * root(3) = root(4) = root(9) = 9
 * 
 * connected(p, q): if root(p) == root(q)
 * union(p, q): to merge components containing p and q, set id of p's root to the id of q's root
 * 
 * @author Gezimi
 *
 */
public class QuickUnionUF extends UF{
	protected int[] id;
	
	public QuickUnionUF(int N) {
		super(N);
		id = new int[N];
		//set id of each object to itself
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
	}
	
	/**
	 * chase parent pointers until reach root
	 * @param i
	 * @return
	 */
	protected int root(int i) {
		while(i != id[i]) {
			i = id[i];
		}
		return i;
	}

	/**
	 * change root of p to point to root of q
	 */
	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		
		id[i] = j;
		
	}

	@Override
	public boolean connected(int p, int q) {
		// TODO Auto-generated method stub
		return root(p) == root(q);
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return id.length;
	}
}
