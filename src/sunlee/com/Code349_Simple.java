package sunlee.com;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * Related Topics 排序 哈希表 双指针 二分查找
 * 👍 231 👎 0
 *
 * @author sunlee
 * @date 2020/9/20 12:56
 */
public class Code349_Simple {

    public static int[] swapSet(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] ints = new int[set1.size()];
        int index = 0;
        for (Integer s : set1) {
            if (set2.contains(s)) {
                ints[index++]=s;
            }
        }
        return Arrays.copyOf(ints, index);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        if (nums1.length > nums2.length) {
            return swapSet(set1, set2);
        } else {
            return swapSet(set2, set1);
        }
    }

}
