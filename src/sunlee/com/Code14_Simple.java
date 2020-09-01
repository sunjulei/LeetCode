package sunlee.com;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *
 * @author sunlee
 * @date 2020/8/31 22:44
 */
public class Code14_Simple {

    public static void main(String[] args) {
        String str[] = new String[]{"flosw", "flos", "floaloasawm"};
        System.out.println(longestCommonPrefix2(str));
    }


    /**
     * 纵向扫描
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String pre = strs[0];
        for (int i = 0; i < pre.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || pre.charAt(i) != strs[j].charAt(i)) {
                    return pre.substring(0, i);
                }
            }
        }
        return pre;
    }

    /**
     * 横向扫描
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            pre = comparedTo(pre, strs[i]);
            if (pre.length() == 0) {
                break;
            }
        }
        return pre;
    }

    private static String comparedTo(String str1, String str2) {

        int i = 0;
        int s1Len = str1.length();
        int s2Len = str2.length();
        int minLen = s1Len < s2Len ? s1Len : s2Len;
        while (i < minLen && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return str1.substring(0,i);
    }
}
