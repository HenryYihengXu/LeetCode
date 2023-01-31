import java.util.List;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    PriorityQueue<ListNode> pq;

    public ListNode mergeKLists(ListNode[] lists) {
        pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode ans = pq.peek();
        mergeKListWithPQ();
        return ans;
    }

    public ListNode mergeKListWithPQ() {
        if (pq.size() == 0) {
            return null;
        }
        if (pq.size() == 1) {
            return pq.poll();
        }
        ListNode smallest = pq.poll();
        if (smallest.next != null) {
            pq.add(smallest.next);
        }
        smallest.next = mergeKListWithPQ();
        return smallest;
    }
}
