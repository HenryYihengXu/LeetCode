import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        char operator = '*';
        int operand = 0;
        int temp = 1;
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                operand = operand * 10 + c - '0';
            } else if (c == '*' || c == '/') {
                if (operator == '*') {
                    temp = temp * operand;
                } else {
                    temp = temp / operand;
                }
                operator = c;
                operand = 0;
            } else if (c == '+' || c == '-') {
                if (operator == '*') {
                    result += sign * temp * operand;
                } else {
                    result += sign * temp / operand;
                }
                operator = '*';
                temp = 1;
                sign = c == '+' ? 1 : -1;
                operand = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                stack.push(temp);
                stack.push(operator == '*' ? 0 : 1);
                operator = '*';
                temp = 1;
                operand = 0;
                result = 0;
                sign = 1;
            } else if (c == ')') {
                if (operator == '*') {
                    result += sign * temp * operand;
                } else {
                    result += sign * temp / operand;
                }
                operand = result;
                operator = stack.pop() == 0 ? '*' : '/';
                temp = stack.pop();
                sign = stack.pop();
                result = stack.pop();
            }
//            System.out.println("c = " + c);
//            System.out.println("result = " + result);
//            System.out.println("sign = " + sign);
//            System.out.println("operand = " + operand);
//            System.out.println("temp = " + temp);
//            System.out.println("operator = " + operator);
//            System.out.println("stack = " + stack);
//            System.out.println();
        }

        if (operator == '*') {
            result += sign * temp * operand;
        } else {
            result += sign * temp / operand;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(solution.calculate(s));
    }
}
