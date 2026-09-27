/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode offsetNode = head;
        int index = 0;
        while (index != n) {
            offsetNode = offsetNode.next;
            index++;
        }
        ListNode dummyNode = new ListNode(0, head);
        ListNode leftNode = dummyNode;
        while (offsetNode != null) {
            leftNode = leftNode.next;
            offsetNode = offsetNode.next;
        }
        leftNode.next = leftNode.next.next;
        return dummyNode.next;
    }
}