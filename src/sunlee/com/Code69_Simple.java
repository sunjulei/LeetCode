package sunlee.com;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * Related Topics 数学 二分查找
 * 👍 505 👎 0
 *
 * @author sunlee
 * @date 2020/9/19 9:52
 */
public class Code69_Simple {

    public static void main(String[] args) {
        System.out.println(mySqrt2(6));
    }

    /**
     * 取e1/2对数
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    /**
     * 二分法
     */
    public static int mySqrt2(int x) {
        int left = 0, right = x;
        while (left <= right) {
            long mid = (left + right) / 2;
            long temp=mid*mid;
            if (temp==x){
                return (int) mid;
            }else if (temp>x){
                right=(int)mid-1;
            }else{
                left=(int)mid+1;
            }
        }
        return right;
    }

    /**
     * 牛顿迭代
     */
    static int s;

    public static int mySqrt3(int x) {
        s = x;
        if (x == 0) return 0;
        return (int) sqrt(x);
    }

    private static double sqrt(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res);
        }
    }
}
