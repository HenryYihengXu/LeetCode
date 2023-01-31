class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int i = 0;
        String result = "";
        boolean isFinished = false;
        while (!isFinished) {
            String str = strs[0];
            if (i >= str.length()) {
                break;
            }
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                str = strs[j];
                if (i >= str.length() || c != str.charAt(i)) {
                    isFinished = true;
                    break;
                }
            }
            if (!isFinished) {
                result += c;
            }
            i += 1;
        }
        return result;
    }
}
