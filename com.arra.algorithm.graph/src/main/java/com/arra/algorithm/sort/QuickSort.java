package com.arra.algorithm.sort;

/**
 * 
 * @author Gezimi
 *
 */
public class QuickSort {
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo) return;
		
		int j = partiton(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partiton(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while(true) {
			while(SortUtil.less(a[++i], v)) {
				if(i == hi) {
					break;
				}
			}
			
			while(SortUtil.less(v, a[--j])) {
				if(j == lo) {
					break;
				}
			}
			
			if(i >= j) break;
			
			SortUtil.exch(a, i, j);
		}
		SortUtil.exch(a, lo, j);
		return j;
	}
}
