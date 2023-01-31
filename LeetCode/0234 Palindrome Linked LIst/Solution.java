import java.util.LinkedList;
import java.util.Stack;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        Stack<Integer> stack = new Stack<>();
        while (two != null) {
            stack.add(one.val);
            one = one.next;
            if (two.next == null) {
                stack.pop();
                break;
            }
            two = two.next.next;
        }
        while (one != null) {
            if (stack.pop() != one.val) {
                return false;
            }
            one = one.next;
        }
        return true;
    }
}
