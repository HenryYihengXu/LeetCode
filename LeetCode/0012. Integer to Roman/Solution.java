import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, Character> roman = new HashMap<>();
        roman.put(1, 'I');
        roman.put(5, 'V');
        roman.put(10, 'X');
        roman.put(50, 'L');
        roman.put(100, 'C');
        roman.put(500, 'D');
        roman.put(1000, 'M');

        int base = 1;
        int digit1 = 0;
        int digit5 = 0;
        LinkedList<Character> result = new LinkedList<>();
        while (num > 0) {
            digit1 = num % 10;
            if (digit1 == 9) {
                result.addFirst(roman.get(10 * base));
                result.addFirst(roman.get(1 * base));
            } else {
                digit5 = digit1 / 5;
                digit1 = digit1 % 5;
                switch (digit1) {
                    case 4:
                        result.addFirst(roman.get(5 * base));
                        result.addFirst(roman.get(base));
                        break;
                    case 3:
                        result.addFirst(roman.get(base));
                        result.addFirst(roman.get(base));
                        result.addFirst(roman.get(base));
                        break;
                    case 2:
                        result.addFirst(roman.get(base));
                        result.addFirst(roman.get(base));
                        break;
                    case 1:
                        result.addFirst(roman.get(base));
                        break;
                    default:
               }
               if (digit5 == 1) {
                   result.addFirst(roman.get(5 * base));
               }
           }
            num = num / 10;
            base *= 10;
        }
        String s = "";
        for (Character c : result) {
            s += c;
        }
        return s;
    }
}