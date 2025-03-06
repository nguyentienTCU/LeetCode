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
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }

        if(head.next==null){
            return head;
        }

        ListNode newHead = head.next;
        head.next = newHead.next;
        newHead.next = head;
        ListNode newNextNode = swapPairs(head.next);
        head.next = newNextNode;
        return newHead;
    }
}