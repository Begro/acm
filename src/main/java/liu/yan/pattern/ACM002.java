package liu.yan.pattern;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by liuyan9 on 2017/7/14.
 */
public class ACM002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num-- > 0) {
            String in = scanner.next();
            char[] cs = in.toCharArray();
            boolean b = true;
            Stack<Character> stack = new Stack<Character>();
            for (char c : cs) {
                if (c == '(' || c == '['||c=='{') {
                    stack.push(c);
                }
                if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        b = false;
                        break;
                    }
                }
                if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        b=false;
                        break;
                    }
                }
                if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        b=false;
                        break;
                    }
                }
            }
            if(!b||!stack.isEmpty()){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}
