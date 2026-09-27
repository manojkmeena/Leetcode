/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> copyMap = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            copyMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        for (Node oldNode : copyMap.keySet()) {
            Node copyNode = copyMap.get(oldNode);
            Node copyNextNode = copyMap.get(oldNode.next);
            Node copyRandomNode = copyMap.get(oldNode.random);
            copyNode.next = copyNextNode;
            copyNode.random = copyRandomNode;
        }
        return copyMap.get(head);
    }
}