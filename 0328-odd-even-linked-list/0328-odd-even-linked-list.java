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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return head;
        }
        ListNode lastOdd = head;
        ListNode lastEven = head.next;
        while(lastEven!=null && lastEven.next!=null){
            ListNode cur = lastEven.next;
            ListNode curNext = cur.next;
            cur.next = lastOdd.next;
            lastOdd.next = cur;
            lastEven.next = curNext;
            lastOdd=cur;
            lastEven = curNext;
        }
        return head;
    }
}