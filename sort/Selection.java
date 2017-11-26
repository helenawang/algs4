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
	
	public static void sort_visualize(Comparable[] a) {
		int N = a.length;
		for(int i=0; i<N; i++) {
			//先用背景色消除掉上一轮留下的墨迹
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.setPenRadius(0.05);
			for(int j=0; j<N; j++) {
				StdDraw.point(j/10.0 + 0.05, (Double) a[j]);
			}
			
			int min = i;
			for(int j=i+1; j<N; j++) {
				if(less(a[j], a[min])) {
					min = j;
				}
			}
			System.out.println("exchange " + i + " with " + min);
			exchange(a, i, min);
			
			//再用前景色画出新的墨迹
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.setPenRadius(0.02);
			for(int j=0; j<N; j++) {
				StdDraw.point(j/10.0 + 0.05, (Double) a[j]);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		int N = 10;
		Double[] a = new Double[N];
		for(int i=0; i<N; i++) {
			a[i] = StdRandom.uniform();//[0, 1) uniformly
		}
		sort_visualize(a);
		assert isSorted(a);
		print(a);
	}
}
