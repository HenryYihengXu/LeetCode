class Solution {
    public int lastCharacter(int[] data) {
        boolean flag = true;
        for (int i = data.length - 2; i >= 0; i--) {
            if (data[i] <= 127) {
                return flag ? 1 : 2;
            }
            flag = !flag;
        }
        return flag ? 1 : 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data1 = {128, 128, 128, 128, 128};
        int[] data2 = {128, 128, 128, 0, 128};
        int[] data3 = {128, 128, 0, 128, 128};
        int[] data4 = {128, 0, 128, 128, 0};
        int[] data5 = {0, 128, 128, 128, 0};
        int[] data6 = {128, 0, 0, 128, 0};
        int[] data7 = {128, 128, 0, 0, 0};
        System.out.println(solution.lastCharacter(data1)); // should be 1
        System.out.println(solution.lastCharacter(data2)); // should be 1
        System.out.println(solution.lastCharacter(data3)); // should be 2
        System.out.println(solution.lastCharacter(data4)); // should be 1
        System.out.println(solution.lastCharacter(data5)); // should be 2
        System.out.println(solution.lastCharacter(data6)); // should be 2
        System.out.println(solution.lastCharacter(data7)); // should be 1
    }
}



//class Solution {
//    public int lastCharacter(int[] data) {
//        int n = data.length;
//        for (int i = n - 2; i >= 0; i--) {
//            if (data[i] <= 127) {
//                return (n - i) % 2 + 1;
//            }
//        }
//        return 2 - n % 2;
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] data1 = {128, 128, 0, 0};
//        int[] data2 = {128, 128, 128, 0};
//        int[] data3 = {128, 128, 128, 128, 0};
//        System.out.println(solution.lastCharacter(data1));
//        System.out.println(solution.lastCharacter(data2));
//        System.out.println(solution.lastCharacter(data3));
//    }
//}
