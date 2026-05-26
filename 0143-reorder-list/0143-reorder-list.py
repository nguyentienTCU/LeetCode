# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:            
        if head == None or head.next == None:
            return

        fast = head.next
        slow = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        first = head
        second = slow.next
        prev = None
        while second:
            nextNode = second.next
            second.next = prev
            prev = second
            second = nextNode
            
        second = prev
        slow.next = None
        while second:
            firstNext = first.next
            secondNext = second.next
            first.next = second
            second.next = firstNext
            first = firstNext
            second = secondNext
            