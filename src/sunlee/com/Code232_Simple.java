package sunlee.com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 * <p>
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * <p>
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * <p>
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 *
 * 官方解法1：把 s1 中所有的元素移到 s2 中，接着把新元素压入 s1。
 * 最后把 s2 中所有的元素弹出，再把弹出的元素压入 s1
 * <p>
 * 官方解法1：把 s1 中所有的元素移到 s2 中，接着把新元素压入 s1。
 * 最后把 s2 中所有的元素弹出，再把弹出的元素压入 s1
 *
 * @author sunlee
 * @date 2020/9/3 23:41
 */

/**
 *官方解法1：把 s1 中所有的元素移到 s2 中，接着把新元素压入 s1。
 * 最后把 s2 中所有的元素弹出，再把弹出的元素压入 s1
 */
/*
public class Code232_Simple {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public Code232_Simple() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void push(int x) {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
*/

/**
 * 官方解法1：把 s1 中所有的元素移到 s2 中，接着把新元素压入 s1。
 * 最后把 s2 中所有的元素弹出，再把弹出的元素压入 s1
 */
public class Code232_Simple {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;

    public Code232_Simple() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()){
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}


/**
 * 不够优雅的写法
 */
/*
public class Code232_Simple {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public static void main(String[] args) {
        Code232_Simple obj = new Code232_Simple();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    public Code232_Simple() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
    }

    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
*/
