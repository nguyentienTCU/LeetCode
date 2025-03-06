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
        ListNode curNode = head;
        ListNode wantedNode = null;
        int count=1;
        while(curNode!=null){
            if(count==n+1){
                wantedNode=head;
            }

            if(curNode.next==null){
                if(count==n){
                    head=head.next;
                    return head;
                }
                
                if(wantedNode!=null&&wantedNode.next!=null){
                    wantedNode.next=wantedNode.next.next;
                    return head;
                }
            }

            count++;
            curNode=curNode.next;
            wantedNode = wantedNode==null?null:wantedNode.next;
        }return head;

        
    }
}