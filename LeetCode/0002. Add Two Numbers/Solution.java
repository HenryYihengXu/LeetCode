// Definition for singly-linked list.
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers2(l1, l2, 0);
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            } else {
                return new ListNode(1);
            }
        }
        if (l1 == null) {
            ListNode curr = l2;
            ListNode prev = null;
            while (carry == 1) {
                if (curr == null) {
                    prev.next = new ListNode(1);
                    break;
                }
                int val = curr.val + carry;
                curr.val = val % 10;
                carry = val / 10;
                prev = curr;
                curr = curr.next;
            }
            return l2;
        }
        if (l2 == null) {
            ListNode curr = l1;
            ListNode prev = null;
            while (carry == 1) {
                if (curr == null) {
                    prev.next = new ListNode(1);
                    break;
                }
                int val = curr.val + carry;
                curr.val = val % 10;
                carry = val / 10;
                prev = curr;
                curr = curr.next;
            }
            return l1;
        }
        ListNode result = new ListNode(0);
        int val = l1.val + l2.val + carry;
        result.val = val % 10;
        carry = val / 10;
        result.next = addTwoNumbers2(l1.next, l2.next, carry);
        return result;
    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result = new ListNode();
//        ListNode curr = result;
//        int extra = 0;
//        while (true) {
//            if (l1 == null && l2 == null) {
//                return result;
//            }
//            if (l1 == null) {
//                curr.val = l2.val + extra;
//                extra = curr.val / 10;
//                curr.val = curr.val % 10;
//                if (l2.next != null) {
//                    curr.next = new ListNode();
//                } else if (extra == 1) {
//                    curr.next = new ListNode();
//                    curr.next.val = 1;
//                }
//            } else if (l2 == null) {
//                curr.val = l1.val + extra;
//                extra = curr.val / 10;
//                curr.val = curr.val % 10;
//                if (l1.next != null) {
//                    curr.next = new ListNode();
//                } else if (extra == 1) {
//                    curr.next = new ListNode();
//                    curr.next.val = 1;
//                }
//            } else {
//                curr.val = (l1.val + l2.val) + extra;
//                extra = curr.val / 10;
//                curr.val = curr.val % 10;
//                if (l1.next != null || l2.next != null) {
//                    curr.next = new ListNode();
//                } else if (extra == 1) {
//                    curr.next = new ListNode();
//                    curr.next.val = 1;
//                }
//            }
//            curr = curr.next;
//            if (l1 != null) {
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                l2 = l2.next;
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println("aaa");
    }
}
//79.76
