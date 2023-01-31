import java.util.HashMap;

class DLinkedNode {
    int key;
    int val;
    DLinkedNode prev;
    DLinkedNode next;

    public DLinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedNode(0, 0);
        tail = new DLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
//        head.prev = null;
//        tail.next = null;
    }

    public void addNode(DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.val = value;
            removeNode(node);
            addNode(node);
        } else {
            DLinkedNode node = new DLinkedNode(key, value);
            cache.put(key, node);
            addNode(node);
            if (cache.size() > capacity) {
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        }
    }

    public void printLRU() {
        DLinkedNode curr = head;
        while (curr != null) {
            System.out.print("(" + curr.key + ", " + curr.val + "), ");
            curr = curr.next;
        }
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//class LRUCache {
//    private int capacity;
//    private HashMap<Integer, DLinkedNode> map;
//    private DLinkedNode head;
//    private DLinkedNode tail;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<>();
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key)) {
//            return -1;
//        }
//
//        DLinkedNode node = map.get(key);
//        if (node == tail) {
//            return node.val;
//        } else if (node == head) {
//            head = node.next;
//            node.next.prev = null;
//        } else {
//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//        }
//        tail.next = node;
//        node.prev = tail;
//        node.next = null;
//        tail = node;
//        printLRU();
//        return node.val;
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            DLinkedNode node = map.get(key);
//            node.val = value;
//            if (node == tail) {
//                return;
//            } else if (node == head) {
//                head = node.next;
//                node.next.prev = null;
//            } else {
//                node.prev.next = node.next;
//                node.next.prev = node.prev;
//            }
//            tail.next = node;
//            node.prev = tail;
//            node.next = null;
//            tail = node;
//        } else {
//            DLinkedNode node = new DLinkedNode(key, value);
//            if (tail == null) {
//                node.prev = null;
//                node.next = null;
//                tail = node;
//                head = node;
//            } else {
//                tail.next = node;
//                node.prev = tail;
//                node.next = null;
//                tail = node;
//            }
//            map.put(key, node);
//            if (map.size() > capacity) {
//                map.remove(head.key);
//                head.next.prev = null;
//                head = head.next;
//            }
//        }
//        printLRU();
//
//    }
//
//    public void printLRU() {
//        DLinkedNode curr = head;
//        while (curr != null) {
//            System.out.print("(" + curr.key + ", " + curr.val + "), ");
//            curr = curr.next;
//        }
//        System.out.println();
//    }
//}
