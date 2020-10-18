package sunlee.com;

/**
 * 猜数字游戏的规则如下：
 * <p>
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * <p>
 * <p>
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 10, pick = 6
 * 输出：6
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1, pick = 1
 * 输出：1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 2, pick = 1
 * 输出：1
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：n = 2, pick = 2
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 * <p>
 * Related Topics 二分查找
 * 👍 84 👎 0
 * <p>
 * <p>
 * //leetcode submit region begin(Prohibit modification and deletion)
 * <p>
 * * Forward declaration of guess API.
 * * @param  num   your guess
 * * @return 	     -1 if num is lower than the guess number
 * *			      1 if num is higher than the guess number
 * *               otherwise return 0
 * * int guess(int num);
 *
 * @author sunlee
 * @date 2020/10/18 11:47
 */
public class Code374_Simple {

    /**
     * 暴力法
     *
     * @param n
     * @return
     */
    public static int guessNumber(int n) {
        for (int i = 1; i < n; i++) {
            if (guess(i) == 0) {
                return i;
            }
        }
        return n;
    }

    /**
     * 二分查找
     *
     * @param n
     * @return
     */
    public static int guessNumber2(int n) {
        int left = 0, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    static int guess(int i) {
        return 1;//瞎写
    }
}
