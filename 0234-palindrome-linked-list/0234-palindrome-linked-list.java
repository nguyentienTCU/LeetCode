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
    public boolean isPalindrome(ListNode head) {
        if(head.next==null){
            return true;
        }

        if(head==null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondList = slow;
        ListNode cur = secondList;
        ListNode firstList = head;

        while(cur!=null && cur.next!=null){
            ListNode curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = secondList;
            secondList = curNext;
        }


        while(secondList!=null){
            if(firstList.val!=secondList.val){
                return false;
            }
            firstList = firstList.next;
            secondList = secondList.next;
        }
        return true;
    }
}