package sunlee.com;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.management.RuntimeErrorException;
import java.util.Stack;

/**
 *
 *设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 *
 *
 * 示例:
 *
 * 输入：
 *["MinStack","push","push","push","getMin","pop","top","getMin"]
 *[[],[-2],[0],[-3],[],[],[],[]]
 *
 *输出：
 *[null,null,null,null,-3,null,0,-2]
 *
 *解释：
 *MinStack minStack = new MinStack();
 *minStack.push(-2);
 *minStack.push(0);
 *minStack.push(-3);
 *minStack.getMin();   --> 返回 -3.
 *minStack.pop();
 *minStack.top();      --> 返回 0.
 *minStack.getMin();   --> 返回 -2.
 *
 *
 *
 *
 * 提示：
 *
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * Related Topics 栈 设计
 * @author sunlee
 * @date 2020/9/3 11:06
 */
public class Code155_Simple {

    public static void main(String[] args) {
        Code155_Simple minStack = new Code155_Simple();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    private Stack<Integer> data;
    private Stack<Integer> helper;

    public Code155_Simple() {
        data=new Stack<>();
        helper=new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (helper.isEmpty()||helper.peek()>=x){
            helper.push(x);
        }else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        if (!data.isEmpty()){
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()){
           return data.peek();
        }else {
            throw  new RuntimeException("当前栈为空！");
        }
    }

    public int getMin() {
        if (!helper.isEmpty()){
            return helper.peek();
        }else {
            throw  new RuntimeException("当前栈为空！");
        }
    }
}
