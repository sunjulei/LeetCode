package sunlee.com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *
 * @author sunlee
 * @date 2020/9/1 23:32
 */
public class Code20_Simple {

    public static void main(String[] args) {
        System.out.println(isValid(("{{")));
    }


    /**
     * 方法一：栈
     *遇到左括号就入栈，遇到右括号就对比，如果和栈顶成一对，则弹栈，再继续比，否则返回false
     */
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 方法二：栈
     * 和方法一类似，只是遇到左括号就存右括号，遇到右括号就拿栈顶判断是否相等
     */
    public static boolean isValid2(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='{') stack.push('}');
            else if (c==('(')) stack.push(')');
            else if (c=='[') stack.push(']');
            else if (stack.isEmpty()||c!=stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
