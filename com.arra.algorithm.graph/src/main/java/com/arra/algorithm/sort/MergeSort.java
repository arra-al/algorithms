package com.arra.algorithm.sort;

/**
 * Top-down mergesort call trace
 * 
 * sort left half
sort(a, 0, 15)
	sort(a, 0, 7)
		sort(a, 0, 3)
			sort(a, 0, 1)
				merge(a, 0, 0, 1)
			sort(a, 2, 3)
				merge(a, 2, 2, 3)
			merge(a, 0, 1, 3)
		sort(a, 4, 7)
			sort(a, 4, 5)
				merge(a, 4, 4, 5)
			sort(a, 6, 7)
				merge(a, 6, 6, 7)
			merge(a, 4, 5, 7)
		merge(a, 0, 3, 7)
		
 * sort right half
sort(a, 8, 15)
	sort(a, 8, 11)
		sort(a, 8, 9)
			merge(a, 8, 8, 9)
		sort(a, 10, 11)
			merge(a, 10, 10, 11)
		merge(a, 8, 9, 11)
	sort(a, 12, 15)
		sort(a, 12, 13)
			merge(a, 12, 12, 13)
		sort(a, 14, 15)
			merge(a, 14, 14,15)
		merge(a, 12, 13, 15)
	merge(a, 8, 11, 15)

 * merge results
merge(a, 0, 7, 15)
 * 
 * 
 * @author Gezimi
 *
 */
public class MergeSort {
	/**
	 * auxiliary array for merges
	 */
	protected static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		// Allocate space just once.
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	
	/**
	 * Sort a[lo..hi].
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo) {
			return;
		}
		
		int mid = lo + (hi - lo) / 2;
		// sort left half
		sort(a, lo, mid);
		// sort right half
		sort(a, mid+1, hi);
		// merge results
		merge(a, lo, mid, hi);
	}
	
	/**
	 * Merge a[lo..mid] with a[mid+1..hi].
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	protected static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		
		// Copy a[lo..hi] to aux[lo..hi].
		for(int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		// Merge back to a[lo..hi].
		for(int k = lo; k <= hi; k++) {
			if(j > mid) {
				a[k] = aux[j++];
			} else if(j > hi) {
				a[k] = aux[i++];
			} else if(SortUtil.less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}
}
