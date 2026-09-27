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
        if (head.next == null)
            return null;
        int index = 1;
        ListNode newHead = reverse(head);
        ListNode curr = newHead;
        ListNode prev = null;
        while (curr != null) {
            if (index == n) {
                if(prev == null){
                    newHead = newHead.next;
                }
                else{
                    prev.next = curr.next;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        return reverse(newHead);
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}