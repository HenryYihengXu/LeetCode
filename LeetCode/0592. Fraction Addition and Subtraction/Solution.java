class Solution {
    public String fractionAddition(String expression) {
        int resultNumerator = 0;
        int resultDenominator = 1;
        int i = 0;
        int j = 0;
        int sign = 1;
        while (j < expression.length()) {
            if (expression.charAt(i) == '-') {
                sign = -1;
                i += 1;
            } else {
                sign = 1;
            }
            while (expression.charAt(j) != '/') {
                j++;
            }
            int numerator = Integer.parseInt(expression.substring(i, j));
            i = j + 1;
            while (j < expression.length() && (expression.charAt(j) != '+' && expression.charAt(j) != '-')) {
                j++;
            }
            int denominator = Integer.parseInt(expression.substring(i, j));
            i = j;

            int gcdValue = gcd(Math.abs(resultDenominator), Math.abs(denominator));
            resultNumerator = resultNumerator * denominator / gcdValue + sign * numerator * resultDenominator / gcdValue;
            resultDenominator = resultDenominator / gcdValue * denominator;

            gcdValue = gcd(Math.abs(resultNumerator), Math.abs(resultDenominator));
            resultNumerator /= gcdValue;
            resultDenominator /= gcdValue;
        }
        return resultNumerator + "/" +resultDenominator;
    }

    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }
        if (a < b) {
            return gcd(b, a);
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
