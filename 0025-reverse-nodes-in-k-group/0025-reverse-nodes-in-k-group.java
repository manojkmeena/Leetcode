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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode greoupPrev = dummyHead;
        while (true) {
            ListNode kthNode = kthNode(greoupPrev, k);
            if (kthNode == null) {
                break;
            }
            ListNode greoupNext = kthNode.next;

            ListNode prev = greoupNext;
            ListNode curr = greoupPrev.next;
            while (curr != greoupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = greoupPrev.next;
            greoupPrev.next = kthNode;
            greoupPrev = temp;
        }
        return dummyHead.next;
    }

    private ListNode kthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}