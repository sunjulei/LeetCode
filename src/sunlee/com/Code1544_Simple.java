package sunlee.com;

/**
 * 给你一个由大小写英文字母组成的字符串 s 。
 * <p>
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
 * <p>
 * <p>
 * 0 <= i <= s.length - 2
 * s[i] 是小写字符，但 s[i + 1] 是相同的大写字符；反之亦然 。
 * <p>
 * <p>
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * <p>
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * <p>
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "s"
 * 输出："s"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 * <p>
 * Related Topics 栈 字符串
 * 👍 10 👎 0
 *
 * @author sunlee
 * @date 2020/9/12 17:20
 */
public class Code1544_Simple {

    public static void main(String[] args) {

//        char a = 'a';
//        char A = 'A';
//        System.out.println(a - A); // input 32
//        System.out.println(a ^ A); // input 32

        System.out.println(makeGood("leEeetcode"));
    }

    public static String makeGood(String s) {
        StringBuilder ref = new StringBuilder();
        int refIndex=-1;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ref.length()>0 &&
                    Character.toLowerCase(ch)==Character.toLowerCase(ref.charAt(refIndex)) &&
                    //(ch ^ ref.charAt(refIndex))==32 &&
                    ch!=ref.charAt(refIndex)){
                ref.deleteCharAt(refIndex);
                refIndex--;
            }else {
                ref.append(ch);
                refIndex++;
            }
        }
        return ref.toString();
    }
}
