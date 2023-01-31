class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        head = head.next;
        int i = 0;

        while (head != null && i < k - 1) {
            head = head.next;
            i += 1;
        }
        if (i < k - 1) {
            return first;
        }

        ListNode prev = first;
        head = first.next;
        i = 0;
        while (head != null && i < k - 1) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            i += 1;
        }
        first.next = reverseKGroup(head, k);
        return prev;
    }
}
