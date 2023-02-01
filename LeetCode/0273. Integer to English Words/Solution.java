class Solution {
    String[] thousand = {"", " Thousand", " Million", " Billion", " Trillion"};
    String[] digit = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] ten = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] ty = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String ans = "";
        int i = 0;
        String space = "";
        while (num > 0) {
            int threeDigits = num % 1000;
            if (threeDigits != 0) {
                ans = parseThreeDigits(num % 1000) + thousand[i] + space + ans;
                space = " ";
            }
            num = num / 1000;
            i += 1;
        }
        return ans;
    }

    public String parseThreeDigits(int threeDigits) {
        String result = "";
        String space = "";
        if (threeDigits >= 100) {
            result = digit[threeDigits / 100 - 1] + " Hundred";
            space = " ";
        }

        int twoDigits = threeDigits % 100;

        if (twoDigits >= 1 && twoDigits <= 9) {
            result += space + digit[twoDigits - 1];
        } else if (twoDigits >= 10 && twoDigits <= 19){
            result += space + ten[twoDigits - 10];
        } else if (twoDigits >= 20) {
            result += space + ty[twoDigits / 10 - 2];
            int oneDigit = twoDigits % 10;
            if (oneDigit % 10 != 0) {
                result += " " + digit[oneDigit - 1];
            }
        }

        return result;
    }
}
