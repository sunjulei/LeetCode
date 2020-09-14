package sunlee.com;

import java.lang.reflect.Array;
import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返
 * 回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * <p>
 * <p>
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * Related Topics 堆
 * 👍 149 👎 0
 *
 * @author sunlee
 * @date 2020/9/14 14:09
 */
public class Code703_Simple {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 8, 2};
        Code703_Simple code = new Code703_Simple(3, arr);
        System.out.println(code.add(3)); // returns 4
        System.out.println(code.add(5)); // returns 5
        System.out.println(code.add(10)); // returns 5
        System.out.println(code.add(9)); // returns 8
        System.out.println(code.add(4)); // returns 8
    }

    private PriorityQueue<Integer> queue;
    private int limit;

    public Code703_Simple(int k, int[] nums) {
        limit=k;
        queue=new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (limit > queue.size()) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }

        return queue.peek();
    }
}
