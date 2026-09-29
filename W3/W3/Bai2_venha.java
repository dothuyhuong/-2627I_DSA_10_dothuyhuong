package W3;

import java.util.Scanner;
import java.util.Stack;

public class Bai2_venha {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Nếu là ngoặc mở, push vào stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Nếu là ngoặc đóng, kiểm tra và pop khỏi stack
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return "NO";
                }
            }
        }

        // Nếu stack trống nghĩa là tất cả các ngoặc đã đóng khớp
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                String s = scanner.next();
                System.out.println(isBalanced(s));
            }
        }
        scanner.close();
    }
}
