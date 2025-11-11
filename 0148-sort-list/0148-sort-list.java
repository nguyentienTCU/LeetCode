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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null) return head;

        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);
        return merge(leftSorted, rightSorted);
    }

    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;      // fast starts one ahead -> left half smaller when even
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur=cur.next;
        }
        cur.next = left == null ? right : left;
        return dummy.next;
    }
}