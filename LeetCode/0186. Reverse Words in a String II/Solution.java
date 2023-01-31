class Solution {
    public void reverseString(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start += 1;
            end -= 1;
        }
    }

    public void reverseWords(char[] s) {
        reverseString(s, 0, s.length - 1);
        int i = 0;
        while (s[i] == ' ') {
            i++;
        }
        int start = i;
        for (; i < s.length; i++) {
            if (s[i] == ' ') {
                reverseString(s, start, i - 1);
                start = i + 1;
            }
        }
        if (start < s.length) {
            reverseString(s, start, s.length - 1);
        }
    }
}
