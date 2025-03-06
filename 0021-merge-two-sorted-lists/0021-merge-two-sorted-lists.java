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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        
        if(list1.val<list2.val){
            ListNode nextNode1 = list1.next;
            ListNode newHead = mergeTwoLists(nextNode1, list2);
            list1.next = newHead;
            return list1;
        } else {
            ListNode nextNode2 = list2.next;
            ListNode newHead = mergeTwoLists(nextNode2, list1);
            list2.next = newHead;
        } return list2;
    }
}