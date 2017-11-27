package sort;

import edu.princeton.cs.algs4.*;

public class SortVisualize {
	public static void paintBefore(Comparable[] a) {
		int N = a.length;
		//用背景色消除掉上一轮留下的墨迹
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setPenRadius(0.05);
		for(int j=0; j<N; j++) {
			StdDraw.point(j/(N+0.0) + 0.05, (Double) a[j]);
		}
	}
	public static void paintAfter(Comparable[] a) {
		int N = a.length;
		//用前景色画出新的墨迹
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.02);
		for(int j=0; j<N; j++) {
			StdDraw.point(j/(N+0.0) + 0.05, (Double) a[j]);
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
}
