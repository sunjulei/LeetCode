package sunlee.com;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * @author sunlee
 * @date 2020/9/1 23:32
 */
public class Code20_Simple {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    //暴力法
    public static boolean isValid(String s) {
        s=s.replaceAll(" ","");
        if (s.length()%2!=0) return false;
        Map<Character,Character> map=new HashMap();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        for (int i = 0; i < s.length()/2; i++) {
            char key = s.charAt(i);
            char val=s.charAt(s.length()-1-i);
            if (val!=map.get(key)){
                return false;
            }
        }
        return true;
    }
}
