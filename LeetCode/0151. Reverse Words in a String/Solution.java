class Solution {
    public String reverseWords(String s) {
        if (s.equals("")) {
            return "";
        }
        String[] strs = s.trim().split("\\s+");
        String ans = "";
        for (int i = strs.length - 1; i > 0; i--) {
            System.out.println(strs[i]);
            ans += strs[i] + " ";
        }
        ans += strs[0];
        return ans;
    }
}
