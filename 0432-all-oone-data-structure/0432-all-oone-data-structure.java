class AllOne {

    class Node{
        int freq;
        HashSet<String> keys;
        Node next;
        Node prev;
        Node(int freq){
            this.freq = freq;
            keys = new HashSet<>();
        }
    }

    HashMap<String, Node> map;
    Node dummyHead;
    Node dummyTail;

    public AllOne() {
        map = new HashMap<>();
        dummyHead = new Node(0);
        dummyTail = new Node(0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    private void insertNodeAfter(Node existing, Node newNode){
        newNode.next = existing.next;
        existing.next.prev = newNode;
        existing.next = newNode;
        newNode.prev = existing;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void inc(String key) {
        Node currentNode = map.getOrDefault(key, dummyHead);
        int freq = currentNode.freq + 1;
        Node newNode = currentNode.next.freq == freq ? currentNode.next : new Node(freq);
        newNode.keys.add(key);
        map.put(key, newNode);
        if(currentNode.next.freq != freq){
            insertNodeAfter(currentNode, newNode);
        }

        // clean old node
        if(currentNode != dummyHead){
            currentNode.keys.remove(key);
            if(currentNode.keys.isEmpty()){
                removeNode(currentNode);
            }
        }

    }
    
    public void dec(String key) {
        Node currentNode = map.get(key);
        int freq = currentNode.freq - 1;
        Node newNode = currentNode.prev.freq == freq ? currentNode.prev : new Node(freq);
        newNode.keys.add(key);
        map.put(key, newNode);
        if(currentNode.prev.freq != freq){
            insertNodeAfter(currentNode.prev, newNode);
        }

        // clean old node
        currentNode.keys.remove(key);
        if(currentNode.keys.isEmpty()){
            removeNode(currentNode);
        }
    }
    
    public String getMaxKey() {
        if(dummyTail.prev == dummyHead){
            return "";
        }
        return dummyTail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if(dummyHead.next == dummyTail){
            return "";
        }
        return dummyHead.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */