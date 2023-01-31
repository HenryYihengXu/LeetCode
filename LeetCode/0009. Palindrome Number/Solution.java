class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reverse = 0;
        int xCopy = x;
        while (x != 0) {
            reverse *= 10;
            reverse += x % 10;
            x /= 10;
        }
        if (reverse == xCopy) {
            return true;
        } else {
            return false;
        }
    }
}
