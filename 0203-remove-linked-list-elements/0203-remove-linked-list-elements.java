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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            boolean isChange = false;
            if(cur.val==val){
                if(prev==null){
                    head=head.next;
                } else {
                    prev.next = cur.next;
                }
                isChange=true;
            }
            prev = isChange==true?prev:cur;
            cur = cur.next;
        }return head;
    }
}