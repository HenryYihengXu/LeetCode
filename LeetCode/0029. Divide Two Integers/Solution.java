class Solution {
//    public int divide(int dividend, int divisor) {
//        long quotient = 0;
//        int dividendSign = dividend >= 0 ? 1 : -1;
//        int divisorSign = divisor >= 0 ? 1 : -1;
//        long dividendLong = dividend;
//        long divisorLong = divisor;
//        dividendLong = Math.abs(dividendLong);
//        divisorLong = Math.abs(divisorLong);
//        while (dividendLong >= divisorLong) {
//            dividendLong -= divisorLong;
//            quotient += 1;
//        }
//        quotient = quotient * dividendSign * divisorSign;
//        if (quotient < Integer.MIN_VALUE) {
//            return Integer.MIN_VALUE;
//        }
//        if (quotient > Integer.MAX_VALUE) {
//            return Integer.MAX_VALUE;
//        }
//        return (int)quotient;
//    }

    public int divide(int dividend, int divisor) {
        long quotient = 0;
        int dividendSign = dividend >= 0 ? 1 : -1;
        int divisorSign = divisor >= 0 ? 1 : -1;
        long dividendLong = dividend;
        long divisorLong = divisor;
        dividendLong = Math.abs(dividendLong);
        divisorLong = Math.abs(divisorLong);


        long base = 1;
        while (dividendLong >= divisorLong) {
            divisorLong = divisorLong << 1;
            base = base << 1;
        }
        divisorLong = divisorLong >> 1;
        base = base >> 1;

        while (dividendLong >= divisorLong && divisorLong != 0) {
            quotient += base;
            dividendLong -= divisorLong;
            while (dividendLong < divisorLong) {
                divisorLong = divisorLong >> 1;
                base = base >> 1;
            }
        }

        quotient = quotient * dividendSign * divisorSign;
        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)quotient;
    }
}
