import java.lang.Math;

class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result *= 10;
            int digit = x % 10;
            result += digit;
            x /= 10;
        }
        if (result > Math.pow(2, 31) - 1) {
            return 0;
        }
        if (result < -Math.pow(2, 31)) {
            return 0;
        }
        return (int)result;
    }
}