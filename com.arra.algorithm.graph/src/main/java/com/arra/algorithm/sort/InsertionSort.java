package com.arra.algorithm.sort;

public class InsertionSort {
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		
		for(int i = 0; i < N; i++) {
			for(int j = i; j > 0; j--) {
				if(SortUtil.less(a[j], a[j-1])){
					SortUtil.exch(a, j, j-1);
				} else {
					break;
				}
			}
		}
	}
	
}
