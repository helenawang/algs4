package sort;

import edu.princeton.cs.algs4.StdRandom;

public class Merge extends Sort{
	private static Comparable[] aux;
	public static void sortTD(Comparable[] a) {
		aux = new Comparable[a.length];
		sortTD(a, 0, a.length-1);
	}
	/**
	 * sort a[lo, hi] in top-down manner
	 * @param a
	 * @param lo
	 * @param hi
	 */
	private static void sortTD(Comparable[] a, int lo, int hi) {
		if(hi <= lo) return ;//区间长度<=0，返回
		int mid = lo + (hi-lo)/2;
		sortTD(a, lo, mid);
		sortTD(a, mid+1, hi);
		SortVisualize.paintBefore(a);
		merge(a, lo, mid, hi);
		SortVisualize.paintAfter(a);
	}
	/**
	 * sort a[lo, hi] in bottom-up manner
	 * @param a
	 */
	private static void sortBU(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[a.length];
		for(int sz = 1; sz < N; sz += sz) {
			for(int lo=0; lo < N-sz; lo += sz+sz) {
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
			}
		}
	}
	/**
	 * merge a[lo..mid] with a[mid+1..hi]
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		//first copy into auxiliary array aux[]
		for(int k=lo; k<=hi; k++) {
			aux[k] = a[k];
		}
		//merge back to a[]
		int i=lo, j=mid+1;
		for(int k=lo; k<=hi; k++) {
			if	   (i > mid) a[k] = aux[j++];//i已耗尽; left half exhausted
			else if(j > hi)  a[k] = aux[i++];//j已耗尽; right half exhausted
			else if(less(aux[i], aux[j])) a[k] = aux[i++];//取较小的那个，注意比较的是aux[]，不是a[]
			else a[k] = aux[j++];
		}
	}
	public static void main(String[] args) {
		int N = 20;
		Double[] a = new Double[N];
		for(int i=0; i<N; i++) {
			a[i] = StdRandom.uniform();//[0, 1) uniformly
		}
		print(a);
		sortTD(a);
		assert isSorted(a);
		print(a);

	}
}
