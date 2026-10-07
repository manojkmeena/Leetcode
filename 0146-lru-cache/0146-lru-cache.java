class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> cache;
    int capacity = 0;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            removeNode(cache.get(key));
            addNode(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            removeNode(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        addNode(cache.get(key));
        if (cache.size() > capacity) {
            cache.remove(left.next.key);
            removeNode(left.next);
        }
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addNode(Node node) {
        right.prev.next = node;
        node.prev = right.prev;
        node.next = right;
        right.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */