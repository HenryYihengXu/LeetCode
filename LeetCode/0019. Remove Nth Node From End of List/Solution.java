class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nth = head;
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            if (i > n) {
                nth = nth.next;
            }
            curr = curr.next;
            i += 1;
        }
        if (i <= n) {
            head = head.next;
        } else {
            nth.next = nth.next.next;
        }
        return head;
    }
}
