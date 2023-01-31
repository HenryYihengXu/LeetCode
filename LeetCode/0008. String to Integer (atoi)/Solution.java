import java.lang.Math;

class Solution {
    public int myAtoi(String s) {
        long result = 0;
        boolean isPositive = true;
        boolean hasStarted = false;
        long max = (long)Math.pow(2, 31);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c < 48 || c > 57) && hasStarted) {
                break;
            }
            if ((c < 48 || c > 57) && c != ' ' && c != '+' && c != '-') {
                break;
            }
            if (c == ' ') {
                continue;
            }
            if (c == '-') {
                isPositive = false;
                hasStarted = true;
                continue;
            }
            if (c == '+') {
                hasStarted = true;
                continue;
            }

            result *= 10;
            result += c - 48;
            hasStarted = true;
            if (isPositive && result > max - 1) {
                result = max - 1;
                break;
            }
            if (!isPositive && result > max) {
                result = -max;
                break;
            }
        }
        if (!isPositive) {
            result = -result;
        }
        return (int)result;
    }
}
