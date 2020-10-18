package sunlee.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * Related Topics 排序 哈希表 双指针 二分查找
 * 👍 395 👎 0
 *
 * @author sunlee
 * @date 2020/9/29 17:40
 */
public class Code350_Simple {

    public static void main(String[] args) {

    }

    /**
     * 哈希表
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        int[] arr = new int[nums2.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                arr[index++] = num;
                map.put(num, --count);
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }

    /**
     * 双指针排序
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] arr = new int[Math.min(len1, len2)];
        int index=0,index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            }else if (nums1[index1] > nums2[index2]){
                index2++;
            }else {
                arr[index++]=nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(arr,0,index);
    }
}
