package exercises;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Helena Wang
 * @version 0.0.1
 * @function 约瑟夫环问题 练习1.3.37
 * @time 2018/7/20 15:23
 */
public class Josephus {
    public static void main(String[] args) {
        int n, m; // n个人围坐一圈，报到m的人被杀死
        n = Integer.parseInt(args[0]);
        m = Integer.parseInt(args[1]);
        Queue<Integer> queue = new Queue<>();
        for (int i=0; i<n; i++) {//初始化队列
            queue.enqueue(i);
        }
        int cnt = 0; //当前报到的数字
        while (!queue.isEmpty()) {
            cnt = (cnt+1) % m;
            if (cnt == 0) {
                StdOut.print(queue.dequeue() + " "); // 被杀死，出队，打印
            } else {
                queue.enqueue(queue.dequeue()); // 出队，再插到队尾
            }
        }
    }
}
