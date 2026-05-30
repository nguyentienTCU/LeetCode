# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 1 or head == None:
            return head

        def reverse(head):
            dummy = ListNode(0, head)
            prev = dummy
            cur = head
            while cur != None:
                nextNode = cur.next
                cur.next = prev
                prev = cur
                cur = nextNode
            return prev
            
        cur = head
        count = 0
        while k-count>1:
            if cur == None:
                return head
            cur = cur.next
            count += 1
        
        if cur == None:
            return head

        rest = cur.next
        cur.next = None

        newHead = reverse(head)
        head.next = self.reverseKGroup(rest, k)
        return newHead