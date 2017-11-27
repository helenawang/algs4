package sort;

import edu.princeton.cs.algs4.StdRandom;

public class Insertion extends Sort{
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i=1; i<N; i++) {
			//insert a[i] among a[0] to a[i-1]
			SortVisualize.paintBefore(a);
			for(int j=i; j>0 && less(a[j], a[j-1]); j--) {
				//a[i]的实际位置在a[0]到a[i-1]中单调向0方向移动，一旦触及比它小的，即就位。
				exchange(a, j-1, j);
			}
			SortVisualize.paintAfter(a);
		}
	}
	/**
	 * 改进版，交换改为后移
	 * @param a
	 */
	public static void sort2(Comparable[] a) {
		int N = a.length;
		for(int i=1; i<N; i++) {
			Comparable temp = a[i];
			int j = i;
			for(; j>0 && less(temp, a[j-1]); j--) {//注意这里比较的是temp和a[j-1]
				//只后移，不做实际交换；利用temp暂存a[i]，找好位置后再写入
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
	public static void main(String[] args) {
		int N = 30;
		Double[] a = new Double[N];
		for(int i=0; i<N; i++) {
			a[i] = StdRandom.uniform();//[0, 1) uniformly
		}
		sort(a);
		assert isSorted(a);
		print(a);
	}
}
