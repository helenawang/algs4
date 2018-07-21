package exercise;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author Helena Wang
 * @version 0.0.1
 * @function 牛客网的two sum问题，返回一个序列中和为target的两个元素的索引
 * @time 2018/7/21 14:26
 */
public class TwoSum_1 {
    class Element implements Comparable<Element> {
        int index;
        int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Element p) {
            if (this.value < p.value) return -1;//注意这里为了保证稳定排序，不能加等号
            else return 1;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Element[] elements = new Element[nums.length];//这里分配的空间是引用的空间，并没有分配每个Element的空间
        for (int i=0; i<nums.length; i++) {
            elements[i] = new Element(i, nums[i]);//这里才分配每个Element的空间
        }
        int[] result = new int[2];
        Arrays.sort(elements);
        for (int i=0; i<elements.length; i++) {
//            System.out.println(elements[i].value);
            if (elements[i].value == target - elements[i].value) {
                result[0] = elements[i].index;
                result[1] = elements[i+1].index; //相等的话必然相邻，且副本在后一个位置
                break;
            } else {
                int j = binSearch(elements, target - elements[i].value);
                if (j > i) {
                    result[0] = Math.min(elements[i].index, elements[j].index);
                    result[1] = Math.max(elements[i].index, elements[j].index);
                    break;
                }
            }
        }
        return result;
    }
    private static int binSearch(Element[] elements, int target) {
        int lo = 0, hi = elements.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < elements[mid].value) hi = mid - 1;
            else if (target > elements[mid].value) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,75,25};
        int target = 100;
        TwoSum_1 twoSum_1 = new TwoSum_1();
        int[] result = twoSum_1.twoSum(nums, target);
        for (int i: result) {
            StdOut.print(i + " ");
        }
    }
}
