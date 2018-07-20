package exercises;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.regex.Pattern;

/**
 * @author Helena Wang
 * @version 0.0.2
 * @function 补全左括号
 * @time 2018/7/18 16:26
 */
public class ParenthesesCompletion {
    private Stack<String> operands;
    private Stack<String> operators;

    public ParenthesesCompletion() {

    }

    /**
     * 判断s是否为数字
     * @param s
     * @return
     */
    private boolean isNumeric(String s) {
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        if (pattern.matcher(s).matches()) return true;
        else return false;
    }

    /**
     * 版本2，参考了 https://blog.csdn.net/u013066244/article/details/53197756
     * @param string
     * @return
     */
    public String complete_ver2(String string) {
        operands = new Stack<>();
        operators = new Stack<>();
        String [] str = string.split(" ");
        for (String s: str) {
            if (isNumeric(s)) {
                operands.push(s);
            } else if (s.equals(")")) {
                String opn2 = operands.pop();
                String opn1 = operands.pop();
                String opr = operators.pop();
                String new_opn = "( " + opn1 + " " + opr + " " + opn2 + " )"; // 注意这步，把一个表达式拼接为一个操作数再重新压栈
                operands.push(new_opn);
            } else {
                operators.push(s);
            }
        }
//        StdOut.println(operands);
        return operands.toString();
    }

    /**
     * 补全左括号，版本1
     * @param string
     */
    public String complete(String string) {
        operands = new Stack<>();
        operators = new Stack<>();
        String[] str = string.split(" ");
        for (String s: str) {
            if (!s.equals(")")) operands.push(s);
            else {
                while (!operands.isEmpty() && !operands.peek().equals("(")) {
                    operators.push(operands.pop());
                }
                operands.push("(");
                while (!operators.isEmpty()) {
                    operands.push(operators.pop());
                }
                operands.push(")");
//                for (String ss: operands) {
//                    StdOut.print(ss + " ");
//                }
//                StdOut.println();
            }
        }
        for (String s: operands) {
            operators.push(s);
        }
//        for (String s: operators) {
//            StdOut.print(s + " ");
//        }
//        while (!operands.isEmpty()) {
//            StdOut.print(operands.pop() + " ");
//        }
//        StdOut.println();
        return operators.toString();
    }
    public static void main(String[] args) {
        String expr = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        StdOut.println("输入：" + expr);
        StdOut.println("输出：");
        ParenthesesCompletion pc = new ParenthesesCompletion();
        StdOut.println("版本1：" + pc.complete(expr));//TODO:这个版本和标准答案不一致，但也是合法的表达式，不过括号多余了两个
        StdOut.println("版本2：" + pc.complete_ver2(expr));//这个版本和标答一致
    }
}
