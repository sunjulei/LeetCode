package sunlee.com;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如 sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * <p>
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 * <p>
 * Related Topics 数学 二分查找
 * 👍 172 👎 0
 *
 * @author sunlee
 * @date 2020/10/18 10:18
 */
public class Code367_Simple {

    public static void main(String[] args) {

    }

    /**
     * 二分查找法
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, mid, squared;
        while (left <= right) {
            mid = left + (right - left) / 2;
            squared = mid * mid;
            if (squared == num) {
                return true;
            } else if (squared > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * 牛顿迭代法
     * @param num
     * @return
     */
    public static boolean isPerfectSquare2(int num) {
        if (num < 2) {
            return true;
        }

        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }

        return (x * x == num);
    }
}
