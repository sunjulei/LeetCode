package sunlee.com;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 *
 * @author sunlee
 * @date 2020/8/30 9:38
 */
public class Code2 {
    public static void main(String[] args) {
        System.out.println(reverse2(Integer.MIN_VALUE));
    }

    /**
     * 标准解法
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)
                    || res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            res = res * 10 + pop;
            x /= 10;
        }
        return res;
    }

    /**
     * 可用64位时的解法
     *
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = (res * 10) + (x % 10);
            x /= 10;
        }
        return (int) res == res ? (int)res : 0;
    }
}
