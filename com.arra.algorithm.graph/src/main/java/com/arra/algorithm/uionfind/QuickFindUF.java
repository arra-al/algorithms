package com.arra.algorithm.uionfind;

/**
 * componets: 
 * 0---5---6
 * 1---2---7
 * 3---4---8---9
 * 
 * 0,5,6 are connected
 * 1,2,7 are connected
 * 3,4,8,9 are connected
 * 
 * 		0	1	2	3	4	5	6	7	8	9
 * id[] 0	1	1	8	8	0	0	1	8	8
 * 
 * id[0] == id[5] == id[6] = 0
 * id[1] == id[2] == id[7] = 1
 * id[3] == id[4] == id[8] ==id[9] = 8
 * 
 * QuickFindUF has the union operation too expensive
 * 
 * The worst case is when we want to union all elements (objects) of id[]
 * Takes N^2 array accesses to process the sequence of N union commands
 * on N objects
 * 
 * @author Gezimi
 *
 */
public class QuickFindUF extends UF{
	/**
	 * integer array of size N
	 * p and q are connected if they have the same id;
	 */
	private int[] id;
	
	public QuickFindUF(int N) {
		super(N);
		id = new int[N];
		//set id of each object to itself (N array accesses)
		for(int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		
		//change all entries with id[p] to id[q] (at most 2N + 2 array accesses)
		for(int i = 0; i < id.length; i++) {
			if(id[i] == pid) {
				id[i] = qid;
			}
		}
		
	}

	/**
	 * check if p and q are in the same component (have same id)
	 */
	@Override
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	@Override
	public int find(int p) {
		// TODO Auto-generated method stub
		return id[p];
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return id.length;
	}
}
