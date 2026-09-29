package W3;
import java.util.Stack;

public class w3_tailop_25021815 {


    public static int precedence(char op) {

        if (op == '+' || op == '-') {
            return 1;
        }

        if (op == '*' || op == '/') {
            return 2;
        }

        return 0;
    }

    public static String convert(String expression) {

        Stack<Character> stack = new Stack<>();
        String result = "";


        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);


            if (Character.isLetterOrDigit(c)) {

                result += c;
            }


            else if (c == '(') {

                stack.push(c);
            }


            else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }


                stack.pop();
            }


            else if (c == '+' || c == '-' ||
                    c == '*' || c == '/') {

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(c)) {

                    result += stack.pop();
                }

                stack.push(c);
            }
        }


        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        String expression = "A+B*C";

        String postfix = convert(expression);

        System.out.println(postfix);
    }
}