package com.arra.algorithm.sort;

public class SelectionSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i < N; i++){
			int min = i;
			for(int j = i + 1; j < N; j++) {
				if(SortUtil.less(a[j], a[min])) {
					min = j;
				}
			}
			SortUtil.exch(a, i, min);
		}
	}
}
