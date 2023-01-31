import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int operand = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                operand = operand * 10 + c - '0';
            } else if (c == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if (c == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')'){
                result += sign * operand;
                operand = result;
                sign = stack.pop();
                result = stack.pop();
            }
        }
        return result + sign * operand;
    }
}

//class Solution {
//    public int calculate(String s) {
//        int ans = 0;
//        int sign = 1;
//        int i = 0;
//        while (i < s.length()) {
//            if (s.charAt(i) == ' ') {
//                i += 1;
//            } else if (s.charAt(i) == '+') {
//                sign = 1;
//                i += 1;
//            } else if (s.charAt(i) == '-') {
//                sign = -1;
//                i += 1;
//            } else if (s.charAt(i) == '(') {
//                int start = i + 1;
//                int left = 1;
//                i += 1;
//                while (left != 0) {
//                    if (s.charAt(i) == ')') {
//                        left -= 1;
//                    } else if (s.charAt(i) == '(') {
//                        left += 1;
//                    }
//                    i += 1;
//                }
//                ans += sign * calculate(s.substring(start, i - 1));
//            } else {
//                int start = i;
//                i += 1;
//                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//                    i += 1;
//                }
//                ans += sign * Integer.parseInt(s.substring(start, i));
//            }
//        }
//        return ans;
//    }
//}
