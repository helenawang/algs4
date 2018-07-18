package exercises;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Helena Wang
 * @version 0.0.1
 * @function 判断是否是合法的栈混洗序列
 * @time 2018/7/18 16:50
 */
public class StackOrderValidation {//TODO:push to github and write a blog
    private Stack<Integer> stack;
    private Queue<Integer> queue;
    public StackOrderValidation() {
        stack = new Stack<>();
        queue = new Queue<>();
    }
    public boolean validate(String string) {
        String[] str = string.split(" ");
        for (String s: str) {
            queue.enqueue(Integer.parseInt(s));
        }
        int cur = -1; //当前入过栈的最大元素
        while (!queue.isEmpty()) {
            while (cur < queue.peek()) {//尝试让栈顶和队列头的元素匹配
                cur++;
                stack.push(cur);
            }

            if (queue.peek() == stack.peek()) { //匹配上，抵消掉
                queue.dequeue();
                stack.pop();
            } else return false;//下一个元素不在栈顶，被压着，序列不可能
        }
        return true;
    }

    public static void main(String[] args) {
        StackOrderValidation sov = new StackOrderValidation();
        String[] strings = { //测试用例出自《算法4th》练习1.3.3
                "4 3 2 1 0 9 8 7 6 5",
                "4 6 8 7 5 3 2 9 0 1",
                "2 5 6 7 4 8 9 3 1 0",
                "4 3 2 1 0 5 6 7 8 9",
                "1 2 3 4 5 6 9 8 7 0",
                "0 4 6 5 3 8 1 7 2 9",
                "1 4 7 9 8 6 5 3 0 2",
                "2 1 4 3 6 5 8 7 9 0"
        };
        for (int i=0; i<strings.length; i++) {
            StdOut.println(i + ": " + sov.validate(strings[i]));
        }
    }
}
