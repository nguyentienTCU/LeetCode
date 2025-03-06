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
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;;
        while(cur!=null&&cur.next!=null){
            ListNode curNext=cur.next;
            cur.next=curNext.next;
            curNext.next = head;
            head=curNext;
        }return head;
    }
}