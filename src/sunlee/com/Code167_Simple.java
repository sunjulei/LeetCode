package sunlee.com;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * Related Topics 数组 双指针 二分查找
 * 👍 398 👎 0
 *
 * @author sunlee
 * @date 2020/9/19 15:10
 */
public class Code167_Simple {

    public static void main(String[] args) {

    }

    /**
     * 二分查找法
     */
    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (numbers[i] == target - numbers[mid]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[i] > target - numbers[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 双指针法
     */
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left<right){
            if (numbers[left] == target - numbers[right]) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] > target - numbers[right]) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1,-1};
    }
}
