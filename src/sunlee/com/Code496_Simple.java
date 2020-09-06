package sunlee.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个
 * 比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * <p>
 * 提示：
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 *
 * @author sunlee
 * @date 2020/9/4 20:33
 */
public class Code496_Simple {

    public static void main(String[] args) {

        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] ints = nextGreaterElement3(nums1, nums2);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * 暴力法1
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2)  {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums2[i] == nums1[j]) {
                    result[j] = -1;
                    for (int k = i + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[j]) {
                            result[j] = nums2[k];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 暴力法2
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    res[i] = -1;
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums1[i] < nums2[k]) {
                            res[i] = nums2[k];
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * 官方解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
