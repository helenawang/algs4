package sort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Selection extends Sort{
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i=0; i<N; i++) {
			int min = i;
			for(int j=i+1; j<N; j++) {
				if(less(a[j], a[min])) {
					min = j;
				}
			}
			exchange(a, i, min);
		}
	}
	//不能加override注解，那这个算什么，overwrite吗
	public static void sort_visualize(Comparable[] a) {
		int N = a.length;
		for(int i=0; i<N; i++) {
			SortVisualize.paintBefore(a);
			
			int min = i;
			for(int j=i+1; j<N; j++) {
				if(less(a[j], a[min])) {
					min = j;
				}
			}
			System.out.println("exchange " + i + " with " + min);
			exchange(a, i, min);
			
			SortVisualize.paintAfter(a);
		}
	}
	public static void main(String[] args) {
		int N = 30;
		Double[] a = new Double[N];
		for(int i=0; i<N; i++) {
			a[i] = StdRandom.uniform();//[0, 1) uniformly
		}
		sort_visualize(a);
		assert isSorted(a);
		print(a);
	}
}
