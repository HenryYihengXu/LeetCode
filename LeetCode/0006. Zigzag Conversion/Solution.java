import java.util.ArrayList;

class Solution {
    public int len;

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        len = s.length();
        String[] zigzag = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            zigzag[i] = "";
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int quotient = i / (numRows - 1);
            int remainder = i % (numRows - 1);
            if (remainder == 0) {
                if (quotient % 2 == 0) {
                    zigzag[0] += c;
                } else {
                    zigzag[numRows - 1] += c;
                }
            } else {
                if (quotient % 2 == 0) {
                    zigzag[remainder] += c;
                } else {
                    zigzag[numRows - remainder - 1] += c;
                }
            }
        }
        String result = "";
        for (String str : zigzag) {
            result += str;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("aaa");
    }
}